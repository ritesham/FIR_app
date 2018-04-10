package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoliceOptions extends AppCompatActivity {
    private Button newReports,processReports,rejectedReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_options);
        newReports=findViewById(R.id.btnNewReports);
        processReports=findViewById(R.id.btnProReports);
        rejectedReports=findViewById(R.id.btnRejReports);

        newReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PoliceOptions.this,NewReports.class);
                startActivity(intent);

            }
        });

        processReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PoliceOptions.this,ProcessReports.class);
                startActivity(intent);

            }
        });

        rejectedReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PoliceOptions.this,RejectReports.class);
                startActivity(intent);

            }
        });
    }
}
