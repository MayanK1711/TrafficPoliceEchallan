package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SendMailActivity extends Activity {

    String res = "";String insurance,owner ,vechile_no,vechtype,chlllancode,dName,dmobile;
    String vechiletype;
    String uidtype;
    String uidvalue,offensedetail,offensecategory,section,panelty;
        String BODY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                dName= null;
            } else {
                dName= extras.getString("dName");
                vechile_no=extras.getString("vechileno");
                dName= extras.getString("dName");
                dmobile= extras.getString("dmobile");
                vechiletype= extras.getString("vechiletype");
                uidtype= extras.getString("uidtype");
                uidvalue= extras.getString("uidvalue");
                chlllancode=extras.getString("chalancode",chlllancode);
                offensedetail=extras.getString("offensedetail",offensedetail);
                section=extras.getString("section",section);
                panelty=extras.getString("panelty",panelty);
                offensecategory=extras.getString("offensecategory",offensecategory);
                // BODY="Hello "+ "\n"+"This mail is to inform you that your vechile  no"+vechile_no+"of type"+vechiletype+"has violated the traffic rules in accordance to the following section "+ section+"under category of traffic rules "+ offensecategory+"with the offens of "+offensedetail+"due to which a panelty has been imposed of Rs"+panelty+".Vechile is being driven by "+dName+".This is your transaction id to be used for furthur coommunication ";
            }
        }
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sendmail);
         final Button button1 = (Button) findViewById(R.id.butt24);
         final Button button2 = (Button) findViewById(R.id.butt25);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button2.getVisibility() == View.GONE) {
                    button2.setVisibility(View.VISIBLE);
                } else {
                    button2.setVisibility(View.GONE);
                }
            }
        });
    }
}
