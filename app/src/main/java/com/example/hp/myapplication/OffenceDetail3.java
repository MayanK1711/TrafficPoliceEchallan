package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OffenceDetail3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_offencedetail3);
        this.setTitle("Road Marketing Related Offences");

        Button but15 = (Button) findViewById(R.id.butt15);
        Button but16 = (Button) findViewById(R.id.butt16);
        Button but17 = (Button) findViewById(R.id.butt17);
        but15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffenceDetail3.this, SendMailActivity.class);
                startActivity(intent);
            }
        });

        but16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OffenceDetail3.this, SendMailActivity.class);
                startActivity(intent1);
            }
        });
        but17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail3.this, SendMailActivity.class);
                startActivity(intent2);
            }
        });


    }
}
