import numpy as np
import tensorflow as tf
from tensorflow import keras
from PIL import Image
from flask import Flask, jsonify,request


# Load the saved model
model = keras.models.load_model('CROPDISEASE.h5')

# Define a dictionary to map class indices to class names
class_names = {0: 'Apple - Apple Scab', 1: 'apple black rot', 2: 'cedar apple rust', 3: 'apple healthy', 4: 'bg -anthracnose', 5: 'bg- HEALTHY', 6: 'bg- leaf crinkle', 7: 'bg - powdery mildew', 8: 'bg yellow mosaic', 9: 'grape black rot', 10: 'grape esca black measles', 11: 'grape HEALTHY', 12: 'grape leaf blight', 13: 'potatto early blight', 14: 'potatto healthy', 15: 'potato late blight', 16: 'tomato bacterial spot', 17: 'tomato early blight', 18: 'tomato healthy', 19: 'tomato late blight', 20: 'ttomato septoria'}

# Define a Flask app
app = Flask(__name__)


@app.route('/')
def home():
    return 'welcome home' 



# Define an endpoint for the prediction
@app.route('/predict', methods=['POST'])
def predict():
    # Get the image from the request
    file = request.files['image']
    image = Image.open(file.stream)
    image = image.resize((224, 224))  # Resize the image to the expected input size of the model
    image = np.array(image)  # Convert the image to a numpy array
    image = image / 255.0  # Normalize the pixel values to be between 0 and 1
    image = np.expand_dims(image, axis=0)  # Add an extra dimension to the array to represent the batch size

    # Make a prediction on the image
    prediction = model.predict(image)

    # Get the predicted class label
    class_label = np.argmax(prediction)

    # Get the predicted class name and the corresponding probability
    class_name = class_names[class_label]
    probability = float(prediction[0][class_label])

    # Return the predicted class and probability as a JSON response
    response = {'class': class_name, 'probability': probability}
    return jsonify(response)




if __name__ == '__main__':
    app.run(debug=True)
