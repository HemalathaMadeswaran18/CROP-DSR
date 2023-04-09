package com.example.fyp_app;

import static com.example.fyp_app.DiseaseClassify.increaseContrast;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.fyp_app.ml.CropclassifyModel;
import com.example.fyp_app.ml.ShortenedModel;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;

public class CropClassify extends AppCompatActivity {



    Bitmap bitmap;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.classify_crop_layout);

        Button uploadimg = findViewById(R.id.upload_image_button_crop_classify);
        Button cropClassify = findViewById(R.id.crop_classify_button);
        Button capture = findViewById(R.id.capture_button_crop_classify);

        //to get camera permission
        getpermission() ;
        //upload the image
        uploadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });

        //classify the crop
        cropClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo import image and then classify

                try {
                    CropclassifyModel model = CropclassifyModel.newInstance(CropClassify.this);

                    // Creates inputs for reference.

                    bitmap = Bitmap.createScaledBitmap(bitmap,224,224,true);
                    bitmap = increaseContrastc(bitmap);
                    bitmap = weinerFilterc(bitmap,5,0.9);
                    bitmap = increaseSharpnessc(bitmap);

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

                    // Run model inference and get result
                    CropclassifyModel.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    //result1.setText(getMax(outputFeature0.getFloatArray()));
                    System.out.println("THE FINAL VALUE CLASS IS:  "+getMax(outputFeature0.getFloatArray())  );

                    // Releases model resources if no longer used.
                    model.close();
                } catch (IOException e) {
                    // TODO Handle the exception
                }
            }
        });


        //to capture image from the camera
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,12);
            }
        });



    }



    int getMax(float arr[]){
        int max =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]> arr[max])max =i;

        }
        return max;
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

    void getpermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(CropClassify.this, new String[]{android.Manifest.permission.CAMERA},11);
            }
        }

    }

    public static Bitmap increaseContrastc(Bitmap bitmap) {
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



    public Bitmap weinerFilterc(Bitmap image, int kernelSize, double noiseVariance) {
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

    public Bitmap increaseSharpnessc(Bitmap image) {
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

}
