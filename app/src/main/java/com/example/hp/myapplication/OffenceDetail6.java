package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OffenceDetail6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_offencedetail6);
        this.setTitle("Traffic Signal Related Offences");

        Button but23 = (Button) findViewById(R.id.butt23);
        Button but24 = (Button) findViewById(R.id.butt24);
        Button but25 = (Button) findViewById(R.id.butt25);
        but23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffenceDetail6.this, SendMailActivity.class);
                startActivity(intent);
            }
        });

        but24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OffenceDetail6.this, SendMailActivity.class);
                startActivity(intent1);
            }
        });
        but25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail6.this, SendMailActivity.class);
                startActivity(intent2);
            }
        });


    }
}
