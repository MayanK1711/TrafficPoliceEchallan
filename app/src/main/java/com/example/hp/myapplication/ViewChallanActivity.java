package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewChallanActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewchallan);
        Button butt24 = (Button) findViewById(R.id.butt24);
        Button butt25 = (Button) findViewById(R.id.butt25);

        butt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewChallanActivity.this, ViewChallanVNActivity.class);
                startActivity(intent);
            }
        });
        butt25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewChallanActivity.this, ViewChallanTActivity.class);
                startActivity(intent);
            }
        });
    }
}
