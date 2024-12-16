package com.sajin.cropinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyLoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loan);
        getSupportActionBar().setTitle("My Loan");
    }
}