package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViewChallanTActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewchallant);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        }


        public void clicktransactiob(View v){

            String res = "";String insurance,owner ,vechile_no,offensedetail;
            EditText tx1 = (EditText) findViewById(R.id.transid);

            String s1 = tx1.getText().toString();

            try {
                //yaha server ka ip address add krege
                URL u1 = new URL(" http://192.168.238.1:9595/project/webapi/myresource/vechileinfobytransid?entertransactionid=" + s1 +"");
                        HttpURLConnection
                        ucon = (HttpURLConnection) u1.openConnection();
                ucon.setRequestMethod("POST");
                ucon.setDoInput(true);
                ucon.setDoOutput(true);

                //yaha lagaya buffer reader
                BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                res = br.readLine();
                 Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();
                String[] Vechieino=	res.split("\\W+");

                vechile_no=Vechieino[0];
                owner =Vechieino[1];
                insurance=Vechieino[2];
                offensedetail=Vechieino[3];
                //set the valu of above variable to gui

            }
            catch (Exception e) {
                System.out.print(e);
                e.printStackTrace();
                Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();

            }



        }
}
