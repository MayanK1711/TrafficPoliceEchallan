package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OffenceDetail4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_offencedetail4);
        this.setTitle("Number Plate Related Offences");

        Button but18 = (Button) findViewById(R.id.butt18);
        Button but19 = (Button) findViewById(R.id.butt19);
        but18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffenceDetail4.this, SendMailActivity.class);
                startActivity(intent);
            }
        });

        but19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OffenceDetail4.this, SendMailActivity.class);
                startActivity(intent1);
            }
        });


    }
}
