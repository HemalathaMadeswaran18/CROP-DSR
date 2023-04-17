package com.example.fyp_app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.example.fyp_app.ml.ShortenedModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.MatOfDouble;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Collections.min;
import static java.util.Collections.max;
import static java.lang.Math.log10;
import static java.lang.Math.log;
import static java.lang.Math.exp;
import static java.lang.Math.abs;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class DiseaseClassify extends AppCompatActivity {

    Bitmap bitmap;
    ImageView imageView;
    int localModelClassify =99;
    public  double probability1;

    public int valid=1;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify_disease_layout);

        Button uploadimg = (Button) findViewById(R.id.upload_image_button_classify_disease);
        Button diseaseClassify = findViewById(R.id.classify_disease_button);
        Button capture = findViewById(R.id.capture_button_disease_classify);
        Button showRemedy = findViewById(R.id.showRemedy_btn);
        Button cloudClassify = findViewById(R.id.cloud_classify_btn);
        Button severity = findViewById(R.id.severity_btn);
        Button cloudSeverity = findViewById(R.id.cloudSeverity);

        imageView = findViewById(R.id.imageView3);
        TextView result1  = findViewById(R.id.classify_disease_textView);

        //to get camera permission
        getpermission() ;



        uploadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });






        //to load model and classify
        diseaseClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //todo import model and load
                try {
                    ShortenedModel model = ShortenedModel.newInstance(DiseaseClassify.this);

                    // Creates inputs for reference.

                    bitmap = Bitmap.createScaledBitmap(bitmap,224,224,true);
                    //bitmap = increaseContrast(bitmap);
                    //bitmap = weinerFilter(bitmap,5,0.9);
                   // bitmap = increaseSharpness(bitmap);
// Normalize pixel values to be between 0 and 1
                    float[] pixelBuffer = new float[224 * 224 * 3];
                    int[] pixels = new int[224 * 224];
                    bitmap.getPixels(pixels, 0, 224, 0, 0, 224, 224);
                    for (int i = 0; i < pixels.length; i++) {
                        final int val = pixels[i];
                        pixelBuffer[i * 3 + 0] = ((val >> 16) & 0xFF) / 255.0f;
                        pixelBuffer[i * 3 + 1] = ((val >> 8) & 0xFF) / 255.0f;
                        pixelBuffer[i * 3 + 2] = (val & 0xFF) / 255.0f;
                    }

                    // Create TensorBuffer from normalized pixel buffer
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
                    inputFeature0.loadArray(pixelBuffer, new int[]{1, 224, 224, 3});

//                    //flask
//                    predictDisease(bitmap);


                    // Run model inference and get result
                    ShortenedModel.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    localModelClassify = getMax(outputFeature0.getFloatArray());

                    float findValidImage = getMaxClassvalue(outputFeature0.getFloatArray());

                    if(findValidImage <0.999){
                        result1.setText("ERROR: PLEASE ENTER A VALID IMAGE");
                        valid=0;
                    }
                    else {

                        ClassNameMapper mapper = new ClassNameMapper();

                        // get class name for index 3
                        String className = mapper.getClassName(localModelClassify);
                        result1.setText(className.toString());
                        System.out.println(localModelClassify);
                        System.out.println("THE FINAL VALUE CLASS IS:  " + getMax(outputFeature0.getFloatArray()));
                    }







                    // Releases model resources if no longer used.
                    model.close();
                } catch (IOException e) {
                    // TODO Handle the exception
                }

            }
        });


        //to capture images
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,12);
            }
        });


        //to go thru db
        showRemedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "roomdbnew").allowMainThreadQueries().build();
                RemedyDAO remedyDao = db.remedyDao();


                // List<Remedy> remedys = remedyDao.getAll();
                // String str = "";

                //    for(Remedy remedy: remedys)
                //        str = str+"\t "+remedy.getCropName()+" "+remedy.getCropName()+"\n \n";

                //  System.out.println("THE DB HAS"+str);

                System.out.println(localModelClassify);

                if (localModelClassify == 99) {
                    result1.setText("Classify the image first");
                } else {
                    try {

                        System.out.println("the remedy is" + Remedy.getRemedyById(localModelClassify));
                        //result1.setText(Remedy.getRemedyById(localModelClassify).toString());
                        //Convert to byte array
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] byteArray = stream.toByteArray();

                        Intent in1 = new Intent(DiseaseClassify.this, ShowRemedy.class);
                        in1.putExtra("image", byteArray);
                        in1.putExtra("cropName", Remedy.getRemedyById(localModelClassify).getCropName().toString());
                        in1.putExtra("disease", Remedy.getRemedyById(localModelClassify).getDisease().toString());
                        in1.putExtra("cause", Remedy.getRemedyById(localModelClassify).getCause().toString());
                        in1.putExtra("indicator", Remedy.getRemedyById(localModelClassify).getIndicator().toString());
                        in1.putExtra("lowInfection", Remedy.getRemedyById(localModelClassify).getRemedy().toString());


                        startActivity(in1);
                    } catch (NullPointerException n) {

                        result1.setText("Classify the disease first!!");
                    }


                }
            }
        });


        cloudClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a file in the app's internal storage directory
                File file = new File(DiseaseClassify.this.getFilesDir(), "myImage.jpg");

                result1.setText("Request sent,Please wait. This could take a minute");

                // Save the bitmap to the file
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(120, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .build();

                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("image",file.getName(),RequestBody.create(MediaType.parse("image/jpeg"),file))
                        .build();

                String url = "https://flask-api-383406.el.r.appspot.com/predict";

                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... voids) {
                        try {
                            Response response = client.newCall(request).execute();
                            String responseBody = response.body().string();
                            JSONObject json = new JSONObject(responseBody);
                            String predictedClass = json.getString("class");
                            double probability = json.getDouble("probability");
                            probability1 = probability;
                            return "Predicted class: " + predictedClass + "\nProbability: " + probability;
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        if (result != null) {
                            if(probability1<0.999){
                                result1.setText("error: invalid image or image unclear please try again");
                            }else {
                                result1.setText(result);
                            }
                        } else {
                            result1.setText("Error occurred.");
                        }
                    }
                }.execute();

            }
        });




        severity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (localModelClassify == 99) {
                    result1.setText("Classify the image first");
                } else {

                    if (valid == 0) {
                        result1.setText("ERROR: please upload valid image and classify");
                    } else {
                        Bitmap segementedBitmap = processBitmap(bitmap);

                        String sever = processImage(segementedBitmap);
                        result1.setText(sever.toString());
//segment code
                        //  Bitmap segementedBitmap =   processBitmap(bitmap);
                        //  imageView.setImageBitmap(segementedBitmap);
                    }
                }
            }
        });

        cloudSeverity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a file in the app's internal storage directory
                File file = new File(DiseaseClassify.this.getFilesDir(), "myImage.jpg");
                result1.setText("Request sent,Please wait. This could take a minute");
                // Save the bitmap to the file
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(120, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .build();

                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("image",file.getName(),RequestBody.create(MediaType.parse("image/jpeg"),file))
                        .build();

                String url = "https://severity-flask.el.r.appspot.com/diseased_area";

                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... params) {
                        try {
                            Response response = client.newCall(request).execute();
                            String responseBody = response.body().string();
                            JSONObject json = new JSONObject(responseBody);
                            double diseasedAreaPercentage = json.getDouble("diseased_area_percentage");
                            String infectionLevel = json.getString("infection_level");
                            int severityScore = json.getInt("severity_score");
                            // Handle the response here
                            System.out.println("Diseased area percentage: " + diseasedAreaPercentage);
                            System.out.println("Infection level: " + infectionLevel);
                            System.out.println("Severity score: " + severityScore);
                            String result =  "Infection level: " + infectionLevel + "\nSeverity score: " + severityScore;
                            return result;
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        if (localModelClassify == 99) {
                            result1.setText("Classify the image first");
                        } else {
                            if (result != null) {
                                if (valid == 0) {
                                    result1.setText("ERROR: please upload valid image and classify");
                                } else {
                                    result1.setText(result);
                                }
                            }
                        }
                    }
                }.execute();

            }
        });









    }

//    private void sendImageToFlaskAPI(Bitmap bitmap) {
//        String url = "http://your-flask-api-url.com/predict";
//
//        // Convert bitmap to byte array
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] imageBytes = baos.toByteArray();
//
//        // Create Volley request
//        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url,
//                new Response.Listener<NetworkResponse>() {
//                    @Override
//                    public void onResponse(NetworkResponse response) {
//                        // Handle response from Flask API
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Handle error
//                    }
//                }) {
//
//            @Override
//            protected Map<String, DataPart> getByteData() {
//                Map<String, DataPart> params = new HashMap<>();
//                params.put("image", new DataPart("image.jpg", imageBytes));
//                return params;
//            }
//        };
//
//        // Add the request to the Volley request queue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(multipartRequest);
//    }


    private byte[] getByteArrayFromFile(String filePath) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }


    int getMax(float arr[]){
        int max =0;
        for(int i=0;i<arr.length;i++){
            System.out.println("the vaL"+arr[i]);
            if(arr[i]> arr[max])max =i;

        }
        System.out.println("arr max is "+ arr[max]);
        if(arr[max]<0.99){
            System.out.println("ERROR: enter valid image");
        }
        return max;
    }

    float getMaxClassvalue(float arr[]){
        int max =0;
        for(int i=0;i<arr.length;i++){
            System.out.println("the vaL"+arr[i]);
            if(arr[i]> arr[max])max =i;

        }
        System.out.println("arr max is "+ arr[max]);
        if(arr[max]<0.99){
            System.out.println("ERROR: enter valid image");
        }
        return  arr[max];
    }


    void getpermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(DiseaseClassify.this, new String[]{android.Manifest.permission.CAMERA},11);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==11){
            if(grantResults.length >0){
                if(grantResults[0]!= PackageManager.PERMISSION_GRANTED){
                    this.getpermission();

                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==10){
            if(data!=null){
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        else if(requestCode==12){
            //user is captureing image
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static Bitmap increaseContrast(Bitmap bitmap) {
        // Convert bitmap to Mat
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);

        // Convert to grayscale
        Mat gray = new Mat();
        Imgproc.cvtColor(mat, gray, Imgproc.COLOR_BGR2GRAY);

        // Find minimum and maximum pixel values
        double[] minVal = new double[1];
        double[] maxVal = new double[1];
        Point minLoc = new Point();
        Point maxLoc = new Point();
        MatOfDouble minMax = new MatOfDouble();
        Core.minMaxLoc(gray, minMax);
        // Apply contrast stretching
        Mat stretched = new Mat();
        Core.normalize(gray, stretched, 0, 255, Core.NORM_MINMAX);
        Core.convertScaleAbs(stretched, stretched, 255 / (maxVal[0] - minVal[0]), -minVal[0] * 255 / (maxVal[0] - minVal[0]));

        // Convert back to bitmap
        Bitmap resultBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(stretched, resultBitmap);

        return resultBitmap;
    }



    public Bitmap weinerFilter(Bitmap image, int kernelSize, double noiseVariance) {
        // Convert the Bitmap to a Mat object
        Mat mat = new Mat();
        Utils.bitmapToMat(image, mat);

        // Create a 2D Gaussian kernel with a specified standard deviation
        Mat gaussianKernel = Imgproc.getGaussianKernel(kernelSize, noiseVariance);
        Core.normalize(gaussianKernel, gaussianKernel, 1, 0, Core.NORM_INF);

        // Convolve the image with the Gaussian kernel
        Mat smoothedMat = new Mat();
        Imgproc.filter2D(mat, smoothedMat, -1, gaussianKernel);

        // Calculate the spectral mean and variance of the image
        Scalar mean = Core.mean(smoothedMat);
        Mat varianceMat = new Mat();
        Core.absdiff(smoothedMat, new Scalar(mean.val[0]), varianceMat);
        Core.pow(varianceMat, 2.0, varianceMat);
        Scalar variance = Core.mean(varianceMat);

        // Apply the Wiener filter
        Mat meanMat = new Mat(mat.rows(), mat.cols(), mat.type(), new Scalar(mean.val[0]));
        Mat subtractedMat = new Mat();
        Core.subtract(mat, meanMat, subtractedMat);
        Mat multipliedMat = new Mat();
        Core.multiply(subtractedMat, subtractedMat, multipliedMat);
        Mat dividedMat = new Mat();
        Core.divide(multipliedMat, new Scalar(variance.val[0] + noiseVariance), dividedMat);
        Mat filteredMat = new Mat();
        Core.divide(subtractedMat, new Scalar(variance.val[0] + noiseVariance), filteredMat);
        Core.multiply(filteredMat, dividedMat, filteredMat);
        Core.add(filteredMat, new Scalar(mean.val[0]), filteredMat);
        Core.normalize(filteredMat, filteredMat, 0, 255, Core.NORM_MINMAX);
        filteredMat.convertTo(filteredMat, CvType.CV_8UC1);

        // Convert the Mat object back to a Bitmap
        Bitmap filteredBitmap = Bitmap.createBitmap(filteredMat.cols(), filteredMat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(filteredMat, filteredBitmap);

        return filteredBitmap;
    }

    public Bitmap increaseSharpness(Bitmap image) {
        // Convert the Bitmap to a Mat object
        Mat mat = new Mat();
        Utils.bitmapToMat(image, mat);

        // Create the sharpening kernel
        Mat kernel = new Mat(3, 3, CvType.CV_32F);
        float[] kernelValues = {0, -1, 0, -1, 5, -1, 0, -1, 0};
        kernel.put(0, 0, kernelValues);

        // Apply the sharpening kernel to the image
        Mat filteredMat = new Mat();
        Imgproc.filter2D(mat, filteredMat, -1, kernel);

        // Add the filtered image to the original to increase sharpness
        Mat sharpenedMat = new Mat();
        Core.addWeighted(mat, 1.5, filteredMat, -0.5, 0, sharpenedMat);

        // Convert the Mat object back to a Bitmap
        Bitmap sharpenedBitmap = Bitmap.createBitmap(sharpenedMat.cols(), sharpenedMat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(sharpenedMat, sharpenedBitmap);

        return sharpenedBitmap;
    }


//
//    public void predictDisease(Bitmap image) {
//        System.out.println("reached predict class");
//        // Convert the bitmap image to a byte array
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] byteArray = stream.toByteArray();
//
//        // Build the request body with the image byte array
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("image", "image.jpg", RequestBody.create(MediaType.parse("image/jpeg"), byteArray))
//                .build();
//
//        // Build the HTTP request with the request body
//        Request request = new Request.Builder()
//                .url("http://localhost:5000/predict")
//                .post(requestBody)
//                .build();
//
//        // Send the HTTP request and handle the response
//        OkHttpClient client = new OkHttpClient();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                // Handle the error
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    // Handle the error
//                }
//
//                String responseBody = response.body().string();
//
//                try {
//                    // Parse the JSON response
//                    JSONObject jsonObject = new JSONObject(responseBody);
//                    String className = jsonObject.getString("class");
//                    double probability = jsonObject.getDouble("probability");
//                    System.out.println("THE CLASS FROM FLASK IS "+ className);
//                    // Update the UI with the prediction results
//
//                } catch (JSONException e) {
//                    // Handle the error
//                }
//            }
//        });
//    }
//
//


    public Bitmap processBitmap(Bitmap inputBitmap) {
        // Convert the input bitmap to OpenCV Mat format
        Mat img = new Mat();
        Utils.bitmapToMat(inputBitmap, img);

        // Convert the image from BGR color space to HSV color space
        Mat hsv = new Mat();
        Imgproc.cvtColor(img, hsv, Imgproc.COLOR_BGR2HSV);

        // Create a binary mask for the color range of interest
        Mat mask = new Mat();
        Scalar lowerBound = new Scalar(8, 0, 0);
        Scalar upperBound = new Scalar(86, 255, 255);
        Core.inRange(hsv, lowerBound, upperBound, mask);

        // Apply the mask to the original image
        Mat res = new Mat();
        Core.bitwise_and(img, img, res, mask);

        // Convert the result back to Bitmap format
        Bitmap outputBitmap = Bitmap.createBitmap(res.width(), res.height(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(res, outputBitmap);

        return outputBitmap;
    }



    public String processImage(Bitmap bitmap) {
        // Convert the bitmap to a Mat object
        Mat img = new Mat();
        Utils.bitmapToMat(bitmap, img);

        // Convert the image to HSV color space
        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2HSV);

        // Define the range of brown color in HSV color space
        Scalar lower_brown = new Scalar(0, 50, 50);
        Scalar upper_brown = new Scalar(30, 255, 255);

        // Create a mask that selects only brown pixels in the range
        Mat mask = new Mat();
        Core.inRange(img, lower_brown, upper_brown, mask);

        // Invert the mask to get the diseased spots in white
        Mat inv_mask = new Mat();
        Core.bitwise_not(mask, inv_mask);

        // Convert the image to grayscale
        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);

        // Apply the mask on the grayscale image
        Mat masked_img = new Mat();
        Core.bitwise_and(img, img, masked_img, inv_mask);

        // If no brown disease spots are found, look for white disease spots
        if (Core.countNonZero(mask) == 0) {
            Scalar lower_white = new Scalar(0, 0, 150);
            Scalar upper_white = new Scalar(255, 30, 255);

            // Create a mask that selects only white pixels in the range
            mask = new Mat();
            Core.inRange(img, lower_white, upper_white, mask);

            // Apply a median filter to reduce noise
            Imgproc.medianBlur(mask, mask, 5);

            // Invert the mask to get the diseased spots in white
            inv_mask = new Mat();
            Core.bitwise_not(mask, inv_mask);

            // Apply the mask on the grayscale image
            masked_img = new Mat();
            Core.bitwise_and(img, img, masked_img, inv_mask);
        }

        // Combine the mask with the original image
        Mat output = new Mat();
        Core.bitwise_and(img, img, output, mask);

        // Calculate the percentage of the diseased area
        int total_pixels = bitmap.getWidth() * bitmap.getHeight();
        int diseased_pixels = Core.countNonZero(mask);
        double diseased_area_percentage = ((double)diseased_pixels / total_pixels) * 100;

        // Assign infection level based on the percentage of leaf area affected
        String infection_level;
        if (diseased_area_percentage <= 15) {
            infection_level = "Low infection";
        } else if (diseased_area_percentage <= 50) {
            infection_level = "Moderate infection";
        } else {
            infection_level = "High infection";
        }

        // Display the results
        System.out.println("Diseased area percentage: " + diseased_area_percentage);
        System.out.println("Infection level: " + infection_level);
        return "Infection level: " + infection_level;

    }


}



