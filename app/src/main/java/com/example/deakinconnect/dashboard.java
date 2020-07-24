package com.example.deakinconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity {
    private CardView mUnit1,mUnit2,mUnit3,mUnit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mUnit1= findViewById(R.id.card1);
        mUnit2=findViewById(R.id.card2);
        mUnit3=findViewById(R.id.card3);
        mUnit4=findViewById(R.id.card4);

        mUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),unit1.class));
                return;
            }
        });
        mUnit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),unit2.class));
                return;
            }
        });
        mUnit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),unit3.class));
                return;
            }
        });
        mUnit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),unit4.class));
                return;
            }
        });
    }
}
