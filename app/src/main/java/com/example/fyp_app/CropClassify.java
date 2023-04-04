package com.example.fyp_app;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CropClassify extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.classify_crop_layout);

        Button uploadimg = findViewById(R.id.upload_image_button_crop_classify);
        Button cropClassify = findViewById(R.id.crop_classify_button);
        Button capture = findViewById(R.id.capture_button_crop_classify);

        //upload the image
        uploadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo upload the image
            }
        });

        //classify the crop
        cropClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo import image and then classify
            }
        });


        //to capture image from the camera
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo to get image from the crop
            }
        });



    }
}
