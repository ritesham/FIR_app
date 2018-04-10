package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VictimOptions extends AppCompatActivity {
    private Button newReport,viewReport,cancelReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim_options);
        newReport=findViewById(R.id.btnNewReport);
        viewReport=findViewById(R.id.btnViewReport);
        cancelReport=findViewById(R.id.btnCancelReport);

        newReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VictimOptions.this,WriteNewReport.class);
                startActivity(intent);

            }
        });

        viewReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VictimOptions.this,ExistingReport.class);
                startActivity(intent);

            }
        });

        cancelReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VictimOptions.this,CancelReport.class);
                startActivity(intent);

            }
        });
    }
}
