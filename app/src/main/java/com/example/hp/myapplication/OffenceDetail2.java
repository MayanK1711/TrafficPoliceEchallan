package com.example.hp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OffenceDetail2 extends AppCompatActivity {


    String res = "";String insurance,owner ,vechile_no,vechtype,chlllancode,dname,dmobile;
    String vechiletype;
    String uidtype;
    String uidvalue,offensedetail,offensecategory,section,panelty; String transaction_id;
    String EMAILBODY;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                dname = null;
            } else {
                dname = extras.getString("dName");
                vechile_no = extras.getString("vechileno");
                dname = extras.getString("dName");
                dmobile = extras.getString("dmobile");
                vechiletype = extras.getString("vechiletype");
                uidtype = extras.getString("uidtype");
                uidvalue = extras.getString("uidvalue");
              //  Toast.makeText(getBaseContext(), dname+vechile_no+vechiletype+uidtype+uidvalue+dmobile, Toast.LENGTH_LONG).show();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
        }

        setContentView(R.layout.activity_offencedetail2);
        this.setTitle("Offences Related To Driving");

        Button but11 = (Button) findViewById(R.id.drive1);
        Button but12 = (Button) findViewById(R.id.drive2);
        Button but13 = (Button) findViewById(R.id.drive3);
        Button but14 = (Button) findViewById(R.id.drive4);
        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffenceDetail2.this, finalact.class);
                chlllancode = "drive1";

                try {
                    //yaha server ka ip address add krege
                    URL u1 = new URL("  http://192.168.238.1:9595/project/webapi/myresource/GENERALCHALLANINFO?enterchalancode=" +
                            chlllancode + "");
                    HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                    ucon.setRequestMethod("POST");
                    ucon.setDoInput(true);
                    ucon.setDoOutput(true);

                    //yaha lagaya buffer reader
                    BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                    res = br.readLine();
                    // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();

                    String[] info = res.split("\\W+");
                    chlllancode = info[0];
                    offensedetail = info[1];
                    offensecategory = info[2];
                    section = info[3];
                    panelty = info[4];
                   // Toast.makeText(getBaseContext(), dname+vechile_no+vechiletype+uidtype+uidvalue+dmobile+chlllancode+offensecategory+offensedetail+section+panelty, Toast.LENGTH_LONG).show();
                    transaction_id=randomize();
                    EMAILBODY="Hello "+ "\n"+"This mail is to inform you that your vehiCle  no :"+ "\n"+vechile_no+" of type "+vechiletype+" has violated the traffic rules in accordance to the following section "+ section+" under category of traffic rules "+ offensecategory+"  with the offence of  "+ "\n"+offensedetail+"  due to which a panelty has been imposed of Rs "+panelty+" .Vechile is being driven by  "+ "\n"+dname+" .The transaction id is" +transaction_id+".You can also find the attached image  of your vechile  in attachment. " ;

                    URL u11 = new URL("http://192.168.238.1:9595/project/webapi/myresource/generatechalan?enterdvechno="+vechile_no+"&enterdname="+dname+"&entermobileno="+dmobile+"&enteruid="+uidvalue+"&enterchallanno="+chlllancode+"&entertransid="+transaction_id);

                    HttpURLConnection ucon11 =(HttpURLConnection) u11.openConnection();

                    ucon11.setRequestMethod("POST");
                    ucon11.setDoInput(true);
                    ucon11.setDoOutput(true);
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(ucon11.getInputStream()));
                    String  res1 = br1.readLine();
                   // Toast.makeText(OffenceDetail2.this, res1+"", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    System.out.print(e);
                    e.printStackTrace();
                  //  Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
                intent.putExtra("dName", dname);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype", vechiletype);
                intent.putExtra("uidtype", uidtype);
                intent.putExtra("uidvalue", uidvalue);
                intent.putExtra("EMAilbody",EMAILBODY);

                startActivity(intent);
            }
        });

        but12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OffenceDetail2.this, SendMailActivity.class);

                chlllancode = "drive2";

                try {
                    //yaha server ka ip address add krege
                    URL u1 = new URL(" http:192.168.238.1:9595/project/webapi/myresource/GENERALCHALLANINFO?enterchalancode=" +
                            chlllancode + "");
                    HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                    ucon.setRequestMethod("POST");
                    ucon.setDoInput(true);
                    ucon.setDoOutput(true);

                    //yaha lagaya buffer reader)
                    BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                    res = br.readLine();
                    // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();

                    String[] info = res.split("\\W+");
                    chlllancode = info[0];
                    offensedetail = info[1];
                    offensecategory = info[2];
                    section = info[3];
                    panelty = info[4];
                }
                catch (Exception e) {
                    System.out.print(e);
                    e.printStackTrace();
                 //   Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();


                }
                intent1.putExtra("dName", dname);
                intent1.putExtra("vechileno", vechile_no);
                intent1.putExtra("dmobile", dmobile);
                intent1.putExtra("vechiletype", vechiletype);
                intent1.putExtra("uidtype", uidtype);
                intent1.putExtra("uidvalue", uidvalue);
                startActivity(intent1);
            }
        });
        but13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail2.this, finalact.class);
                chlllancode = "drive3";

                try {
                    //yaha server ka ip address add krege
                    URL u1 = new URL(" http:192.168.238.1:9595/project/webapi/myresource/GENERALCHALLANINFO?enterchalancode=" +
                            chlllancode + "");
                    HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                    ucon.setRequestMethod("POST");
                    ucon.setDoInput(true);
                    ucon.setDoOutput(true);

                    //yaha lagaya buffer reader
                    BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                    res = br.readLine();
                    // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();

                    String[] info = res.split("\\W+");
                    chlllancode = info[0];
                    offensedetail = info[1];
                    offensecategory = info[2];
                    section = info[3];
                    panelty = info[4];
                } catch (Exception e) {
                    System.out.print(e);
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();


                }
                intent2.putExtra("dName", dname);
                intent2.putExtra("vechileno", vechile_no);
                intent2.putExtra("dmobile", dmobile);
                intent2.putExtra("vechiletype", vechiletype);
                intent2.putExtra("uidtype", uidtype);
                intent2.putExtra("uidvalue", uidvalue);


                startActivity(intent2);
            }
        });
        but14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OffenceDetail2.this, SendMailActivity.class);

                chlllancode = "drive1";

                try {
                    //yaha server ka ip address add krege
                    URL u1 = new URL(" http:192.168.238.1:9595/project/webapi/myresource/GENERALCHALLANINFO?enterchalancode=" +
                            chlllancode + "");
                    HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                    ucon.setRequestMethod("POST");
                    ucon.setDoInput(true);
                    ucon.setDoOutput(true);

                    //yaha lagaya buffer reader
                    BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                    res = br.readLine();
                    // Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();

                    String[] info = res.split("\\W+");
                    chlllancode = info[0];
                    offensedetail = info[1];
                    offensecategory = info[2];
                    section = info[3];
                    panelty = info[4];
                } catch (Exception e) {
                    System.out.print(e);
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();


                }
                intent2.putExtra("dName", dname);
                intent2.putExtra("vechileno", vechile_no);
                intent2.putExtra("dmobile", dmobile);
                intent2.putExtra("vechiletype", vechiletype);
                intent2.putExtra("uidtype", uidtype);
                intent2.putExtra("uidvalue", uidvalue);

                startActivity(intent2);
            }
        });


    }
    private static String randomize(){
        Random r = new Random();
        List<Integer> digits=  new ArrayList<>();
        String number = "";
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        for (int i = 10; i > 0; i--) {
            int randomDigit = r.nextInt(i);
            number+=digits.get(randomDigit);
            digits.remove(randomDigit);
        }
        return number;
    }
}
