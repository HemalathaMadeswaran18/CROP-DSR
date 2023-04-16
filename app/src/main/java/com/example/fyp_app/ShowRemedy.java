package com.example.fyp_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowRemedy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_remedy_layout);

        TextView cropName = findViewById(R.id.cropName_tv);
        TextView disease = findViewById(R.id.disease_tv);
        TextView cause = findViewById(R.id.cause_tv);
        TextView indicator = findViewById(R.id.indicator_tv);
        TextView lowInfection = findViewById(R.id.lowInfection);
        TextView moderateInfection = findViewById(R.id.moderateInfection_tv);
        TextView highInfection = findViewById(R.id.highInfection_tv);
        ImageView imageView = findViewById(R.id.imageView4);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView.setImageBitmap(bmp);


        cropName.setText(getIntent().getExtras().getString("cropName"));
        disease.setText(getIntent().getExtras().getString("disease"));
        cause.setText(getIntent().getExtras().getString("cause"));
        indicator.setText(getIntent().getExtras().getString("indicator"));
        lowInfection.setText(getIntent().getExtras().getString("lowInfection"));
        moderateInfection.setText(getIntent().getExtras().getString("moderateInfection"));
        highInfection.setText(getIntent().getExtras().getString("highInfection"));






    }
}