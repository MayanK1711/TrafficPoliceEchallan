package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OffenceDetail5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_offencedetail5);
        this.setTitle("Traffic Police Related Offences");

        Button but20 = (Button) findViewById(R.id.butt20);
        Button but21 = (Button) findViewById(R.id.butt21);
        Button but22 = (Button) findViewById(R.id.butt22);
        but20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffenceDetail5.this, SendMailActivity.class);
                startActivity(intent);
            }
        });

        but21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OffenceDetail5.this, SendMailActivity.class);
                startActivity(intent1);
            }
        });
        but22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail5.this, SendMailActivity.class);
                startActivity(intent2);
            }
        });


    }
}
