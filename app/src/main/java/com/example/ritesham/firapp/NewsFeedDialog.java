package com.example.ritesham.firapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewsFeedDialog extends AppCompatActivity {
    private Button rejectBtn,actionBtn;
    private DatabaseReference databaseFirstRef;
    private TextView tvCD1,tvCD2,tvCD3,tvCD4,tvCD5,tvPO1,tvPO2,tvPO3,tvPO4,tvPO5,tvPO6,tvAF1,tvAF2,tvAF3,tvAF4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_dialog);
        Intent intent=getIntent();
        final String usr=intent.getStringExtra("Complainant Name");
        rejectBtn=findViewById(R.id.btnReject);
        actionBtn=findViewById(R.id.btnAction);

        tvCD1=findViewById(R.id.tvCname);
        tvCD2=findViewById(R.id.tvCname2);
        tvCD3=findViewById(R.id.tvCaddress);
      //  tvCD4=findViewById(R.id.tvMail);
      //  tvCD5=findViewById(R.id.tvMob);
        tvPO1=findViewById(R.id.tvPlace);
        tvPO2=findViewById(R.id.tvCity);
        tvPO3=findViewById(R.id.tvThana);
        tvPO4=findViewById(R.id.tvDate);
        tvPO5=findViewById(R.id.tvTime);
     //   tvPO6=findViewById(R.id.tvFact);
        tvAF1=findViewById(R.id.tvCtype);
        tvAF2=findViewById(R.id.tvCagainst);
     //   tvAF3=findViewById(R.id.tvDescription);
        tvAF4=findViewById(R.id.tvCstatus);


        databaseFirstRef= FirebaseDatabase.getInstance().getReference().child("Reports Table").child(usr);

        databaseFirstRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                String value1=dataSnapshot.child("cName").getValue(String.class);
                String value2=dataSnapshot.child("cName2").getValue(String.class);
                String value3=dataSnapshot.child("cAddress").getValue(String.class);
              //  String value4=dataSnapshot.child("cMail").getValue(String.class);
              //  String value5=dataSnapshot.child("cMob").getValue(String.class);
                String value6=dataSnapshot.child("place").getValue(String.class);
                String value7=dataSnapshot.child("city").getValue(String.class);
                String value8=dataSnapshot.child("thana").getValue(String.class);
                String value9=dataSnapshot.child("date").getValue(String.class);
                String value10=dataSnapshot.child("time").getValue(String.class);
             //   String value11=dataSnapshot.child("facts").getValue(String.class);
                String value12=dataSnapshot.child("cFor").getValue(String.class);
                String value13=dataSnapshot.child("cAgainst").getValue(String.class);
             //   String value14=dataSnapshot.child("discription").getValue(String.class);
                String value15=dataSnapshot.child("Status").getValue(String.class);

                tvCD1.setText(value1);
                tvCD2.setText(value2);
                tvCD3.setText(value3);
             //   tvCD4.setText(value4);
             //   tvCD5.setText(value5);
                tvPO1.setText(value6);
                tvPO2.setText(value7);
                tvPO3.setText(value8);
                tvPO4.setText(value9);
                tvPO5.setText(value10);
            //    tvPO6.setText(value11);
                tvAF1.setText(value12);
                tvAF2.setText(value13);
             //   tvAF3.setText(value14);
                tvAF4.setText(value15);


            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
