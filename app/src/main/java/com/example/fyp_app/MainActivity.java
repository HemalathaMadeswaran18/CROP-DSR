package com.example.fyp_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cropClassify = (Button)findViewById(R.id.classifyButton);
        Button cropDisease = (Button)findViewById(R.id.diseaseButton);
        Button chatbot =(Button) findViewById(R.id.chatbotButton);




        //check if opencv has been launched
        if(OpenCVLoader.initDebug()){
            System.out.println("loaded opencv");
        }


        //launch the crop classification page
        cropClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CropClassify.class);
                startActivity(intent);
            }
        });

        //launch the crop disease classification
        cropDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DiseaseClassify.class);
                startActivity(intent);
            }
        });

        //launch the chatbot page
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO ADD PAGE FOR  CHATBOT
            }
        });






    }





}