package com.sajin.cropinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoanLanding extends AppCompatActivity {
    CardView myLoan,applyloan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_landing);
        getSupportActionBar().setTitle("Loan");
        myLoan = findViewById(R.id.myLoan);
        applyloan = findViewById(R.id.applyLoan);


        myLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyLoan.class);
                startActivity(i);
            }
        });

        applyloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ApplyLoan.class);
                startActivity(i);
            }
        });

    }
}