package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class OffenceDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_offencedetail);
        this.setTitle("Offences Related To Documents");

        Button but7 = (Button) findViewById(R.id.butt7);
        Button but8 = (Button) findViewById(R.id.butt8);
        Button but9 = (Button) findViewById(R.id.butt9);
        Button but10 = (Button) findViewById(R.id.butt10);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffenceDetail.this, finalact.class);
                startActivity(intent);
            }
        });

        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OffenceDetail.this, SendMailActivity.class);
                startActivity(intent1);
            }
        });
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail.this, SendMailActivity.class);
                startActivity(intent2);
            }
        });
        but10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail.this, SendMailActivity.class);
                startActivity(intent2);
            }
        });


    }
}
