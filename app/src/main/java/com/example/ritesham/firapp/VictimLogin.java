package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VictimLogin extends AppCompatActivity {
    private Button login;
    private TextView forgetPassword,newUser;
    private EditText loginId,pass;
    public static String sID,sPin;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim_login);
        loginId=findViewById(R.id.etID);
        pass=findViewById(R.id.etPin);
        login=findViewById(R.id.btnLogin);
        forgetPassword=findViewById(R.id.tvForget);
        newUser=findViewById(R.id.tvNewUser);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference= FirebaseDatabase.getInstance().getReference().child("Victim Table").child(loginId.getText().toString());
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        sID=dataSnapshot.child("username").getValue(String.class);
                        sPin=dataSnapshot.child("password").getValue(String.class);

                        if (loginId.getText().toString().equals(sID)&&pass.getText().toString().equals(sPin))
                        {
                           // Toast.makeText(getApplicationContext(),"Login Successfull!",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(VictimLogin.this,VictimOptions.class);
                            startActivity(intent);
                        }
                        else if (loginId.getText().toString().equals("")||pass.getText().toString().equals(""))
                        {
                            Toast.makeText(getApplicationContext(),"Please enter Login ID and Password!",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Your ID or Password is wrong!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });



            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Currently not available!",Toast.LENGTH_SHORT).show();

            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Will be available!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(VictimLogin.this,NewVictimRegis.class);
                startActivity(intent);

            }
        });
    }
}
