package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewVictimRegis extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5;
    private Button NewAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_victim_regis);
        et1=findViewById(R.id.etName4regis);
        et2=findViewById(R.id.etMob4regis);
        et3=findViewById(R.id.etMail4regis);
        et4=findViewById(R.id.etUsername4regis);
        et5=findViewById(R.id.etPass4regis);
        NewAcc=findViewById(R.id.btnCreatAcc);
        NewAcc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Victim Table");

                VictimTable victimTable=new VictimTable(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString(),et5.getText().toString());

                myRef.child(et4.getText().toString()).setValue(victimTable);
                Toast.makeText(getApplicationContext(),"New Victim Account Created!",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(NewVictimRegis.this,VictimLogin.class);
                startActivity(intent);
            }
        });
    }
}
