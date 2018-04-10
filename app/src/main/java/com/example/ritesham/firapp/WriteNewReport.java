package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteNewReport extends AppCompatActivity {
    private Button submitFIR;
    private EditText etPD1,etPD2,etPD3,etPD4,etPD5,etPO1,etPO2,etPO3,etPO4,etRF1,etRF2;
    private Spinner SO,city,pStation,chori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_new_report);
        submitFIR=findViewById(R.id.btnFirSubmit);
        etPD1=findViewById(R.id.etCname);
        etPD2=findViewById(R.id.etCname2);
        etPD3=findViewById(R.id.etCaddress);
        etPD4=findViewById(R.id.etCmail);
        etPD5=findViewById(R.id.etCmob);
        etPO1=findViewById(R.id.etPlace);
        etPO2=findViewById(R.id.etDate);
        etPO3=findViewById(R.id.etTime);
        etPO4=findViewById(R.id.etFacts);
        etRF1=findViewById(R.id.etAgainst);
        etRF2=findViewById(R.id.etDiscription);
        SO=findViewById(R.id.spSO);
        city=findViewById(R.id.spCity);
        pStation=findViewById(R.id.spThana);
        chori=findViewById(R.id.spChori);

        showmsg("WARNING","If you'll write fake report then\nPolice will take action against you!");


        submitFIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Reports Table");

                ReportsTable reportsTable=new ReportsTable(etPD1.getText().toString(),SO.getSelectedItem().toString()+" "+etPD2.getText().toString(),
                        etPD3.getText().toString(),etPD4.getText().toString(),etPD5.getText().toString(),
                        etPO1.getText().toString(),city.getSelectedItem().toString(),pStation.getSelectedItem().toString(),
                        etPO2.getText().toString(),etPO3.getText().toString(), etPO4.getText().toString(),
                        chori.getSelectedItem().toString(),etRF1.getText().toString(),etRF2.getText().toString());

                myRef.child(VictimLogin.sID).setValue(reportsTable);
                Toast.makeText(getApplicationContext(),"Your FIR is Submitted!",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(WriteNewReport.this,VictimOptions.class);
                startActivity(intent);

            }
        });


    }

    public void showmsg(String title, String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

}
