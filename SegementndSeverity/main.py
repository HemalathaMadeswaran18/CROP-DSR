from flask import Flask, request, jsonify
import cv2
import numpy as np

app = Flask(__name__)

@app.route('/')
def home():
    return 'welcome home' 

@app.route('/diseased_area', methods=['POST'])
def get_diseased_area():
    # Get the image file from the form data
    file = request.files['image']
    
    # Read the image file using OpenCV
    img = cv2.imdecode(np.fromstring(file.read(), np.uint8), cv2.IMREAD_UNCHANGED)
    
    # Convert the image to HSV color space
    hsv_img = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

        # Create color masks to isolate green, brown, and yellow colors in the image
    mask_green = cv2.inRange(hsv_img, (36,0,0), (86,255,255))
    mask_brown = cv2.inRange(hsv_img, (8, 60, 20), (30, 255, 200))
    mask_yellow = cv2.inRange(hsv_img, (21, 39, 64), (40, 255, 255))

    # Combine color masks into one mask
    mask = cv2.bitwise_or(mask_green, mask_brown)
    mask = cv2.bitwise_or(mask, mask_yellow)

    # Apply mask to original image
    res = cv2.bitwise_and(img, img, mask=mask)

    # Define the range of brown color in HSV color space
    lower_brown = np.array([0, 50, 50])
    upper_brown = np.array([30, 255, 255])

    # Create a mask that selects only brown pixels in the range
    mask = cv2.inRange(res, lower_brown, upper_brown)

    # Apply a median filter to reduce noise
    mask = cv2.medianBlur(mask, 5)

    # Invert the mask to get the diseased spots in white
    inv_mask = cv2.bitwise_not(mask)

    # Convert the image to grayscale
    gray_img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # Apply the mask on the grayscale image
    masked_img = cv2.bitwise_and(gray_img, gray_img, mask=inv_mask)

    # Apply color mapping to the masked image to highlight the diseased spots in brown color
    colormask = cv2.applyColorMap(masked_img, cv2.COLORMAP_AUTUMN)

    # Combine the color mask with the original image
    output = cv2.addWeighted(img, 0.7, colormask, 0.3, 0)

    # Calculate the percentage of the diseased area
    total_pixels = img.shape[0] * img.shape[1]
    diseased_pixels = np.count_nonzero(mask == 255)
    diseased_area_percentage = (diseased_pixels / total_pixels) * 100

    # Assign a severity score and corresponding infection level based on the percentage of leaf area affected
    if diseased_area_percentage <= 15:
        severity_score = 1
        infection_level = "Low infection"
    elif diseased_area_percentage <= 50:
        severity_score = 2
        infection_level = "Moderate infection"
    else:
        severity_score = 3
        infection_level = "High infection"
    
    # Return the result as JSON
    result = {
        'diseased_area_percentage': diseased_area_percentage,
        'severity_score': severity_score,
        'infection_level': infection_level
    }
    return jsonify(result)

if __name__ == '__main__':
    app.run(debug=True)
