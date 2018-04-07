package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
        }

        public void serchclick(View v){


            String res = "";
            String insurance, owner, vechile_no;
            EditText tx1 = (EditText) findViewById(R.id.transid);
            TextView textView4,textView6,textView3;
            String s1 = tx1.getText().toString();
            textView4=findViewById(R.id.textView4);
            textView6=findViewById(R.id.textView6);
            textView3=findViewById(R.id.textView3);

            try {
                //yaha server ka ip address add krege
                URL u1 = new URL(" http://192.168.238.1:9595/project/webapi/myresource/vechileeinfobyvechno?enterdvechno=" + s1 + "");
                HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                ucon.setRequestMethod("POST");
                ucon.setDoInput(true);
                ucon.setDoOutput(true);

                //yaha lagaya buffer reader
                BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                res = br.readLine();
                // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show()
                if(res.equalsIgnoreCase("no info found ")){
                    textView6.setText("");
                    textView4.setText("");
                    textView3.setText("");
                } else {
                    String[] Vechieino = res.split("\\W+");
                    insurance = Vechieino[0];
                    owner = Vechieino[1];
                    vechile_no = Vechieino[2];
                    Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();
                    String name = "Vehicle Number: " + vechile_no;
                    textView4.setText(name);
                    String name1 = "Insurance: " + insurance;
                    textView6.setText(name1);
                    String name2 = "Owner Name: " + owner;
                    textView3.setText(name2);
                } //set the valu of above variable to gui

            } catch (Exception e) {
                System.out.print(e);
                e.printStackTrace();
                Toast.makeText(getBaseContext(), "NO INFO FOUND", Toast.LENGTH_LONG).show();
                textView6.setText("");
                textView4.setText("");
                textView3.setText("");

            }


        }
}