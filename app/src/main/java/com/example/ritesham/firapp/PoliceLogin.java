package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PoliceLogin extends AppCompatActivity {
    private Button login;
    private TextView forgetPassword;
    private EditText id,pin;
  //  private static String spId,spPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        login=findViewById(R.id.btnPlogin);
        forgetPassword=findViewById(R.id.tvPforget);
        id=findViewById(R.id.etPid);
        pin=findViewById(R.id.etPpin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().equals("policestation")&&pin.getText().toString().equals("police"))
                {
                  //  Toast.makeText(getApplicationContext(),"Login Successfull!",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(PoliceLogin.this,PoliceOptions.class);
                    startActivity(intent);

                }
                else if (id.getText().toString().equals("")||pin.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter Login ID and Password!",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Your ID or Password is wrong!",Toast.LENGTH_SHORT).show();

                }


            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Currently not available!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
