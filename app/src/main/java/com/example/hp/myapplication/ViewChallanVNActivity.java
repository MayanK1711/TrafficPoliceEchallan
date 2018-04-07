package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViewChallanVNActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewchallanvn);
        Button but24 = (Button) findViewById(R.id.butt24);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        but24.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {


                String res = "";
                String insurance, owner, vechile_no,challan_id;
                EditText tx1 = (EditText) findViewById(R.id.transid);
                TextView textView4,textView6,textView7,textView3;
                String s1 = tx1.getText().toString();
                textView4=findViewById(R.id.textView4);
                textView6=findViewById(R.id.textView6);
                textView7=findViewById(R.id.textView7);
                textView3=findViewById(R.id.textView3);

                try {
                    //yaha server ka ip address add krege
                    URL u1 = new URL(" http://192.168.238.1:9595/project/webapi/myresource/vechileeinfobychallanno?enterdvechno=" + s1 + "");
                    HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                    ucon.setRequestMethod("POST");
                    ucon.setDoInput(true);
                    ucon.setDoOutput(true);

                    //yaha lagaya buffer reader
                    BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                    res = br.readLine();
                    // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show()
                    String[] Vechieino = res.split("\\W+");

                    insurance = Vechieino[0];
                    vechile_no = Vechieino[2];
                    challan_id = Vechieino[1];
                   owner=Vechieino[3];
                    Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();
                    String name="Vehicle Number: " +vechile_no;
                    textView4.setText(name);
                    String name1="Insurance: " +insurance;
                    textView6.setText(name1);
                    String name2="Owner Name: " +owner;
                    textView7.setText(name2);
                    String name3="challan id : " +challan_id;
                   textView3.setText(name3);

                    //set the valu of above variable to gui

                } catch (Exception e) {
                    System.out.print(e);
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(), "NO INFO FOUND", Toast.LENGTH_LONG).show();
                    textView3.setText("");
                    textView7.setText("");
                    textView6.setText("");
                    textView4.setText("");
                }

            }
        }); } }


