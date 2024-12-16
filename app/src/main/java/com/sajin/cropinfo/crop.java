package com.sajin.cropinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class crop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        getSupportActionBar().setTitle("Crop Prediction");
    }
}