package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
private Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
   Button=(Button)findViewById(R.id.butt24);
    Button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
             HomeActivity();
        }
    });

    }
        public void HomeActivity(){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String res = "";
            EditText tx1 = (EditText) findViewById(R.id.transid);
            EditText tx2 = (EditText) findViewById(R.id.PASSWORD);
            String s1 = tx1.getText().toString();
            String s2 = tx2.getText().toString();

            try {
                //yaha server ka ip address add krege
                URL u1 = new URL(" http://192.168.238.1:9595/project/webapi/myresource/checklogin?enterid=" + s1 + "&enterpass=" + s2 + "");
                // "http://"+ StaticIP.ipurl +"/first/webapi/myresource/checkloginservice?enterid=" + s1 + "&enterpass=" + s2 + "");
            //    Toast.makeText(this, u1+"", Toast.LENGTH_SHORT).show();
                HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                ucon.setRequestMethod("POST");
                ucon.setDoInput(true);
                ucon.setDoOutput(true);

                //yaha lagaya buffer reader
                BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                res = br.readLine();
               // Toast.makeText(getBaseContext(), res+"obtained  data is ", Toast.LENGTH_LONG).show();
                // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show()
                    System.out.println("login called from android"+res);
                if (res.equalsIgnoreCase("true")) {
                    Intent intent=new Intent(this,HomeActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getBaseContext(), "invalid id or passsword", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                System.out.print(e);
                e.printStackTrace();
                Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();

            }

        }
}








