package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OffenceType extends Activity {
    String res = "";String insurance,owner ,vechile_no,vechtype,dName,dmobile;
    String vechiletype;
    String uidtype;
    String uidvalue;

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
            }
        }
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_offencetype);

        Button butt1 = (Button) findViewById(R.id.butt1);
        Button butt2 = (Button) findViewById(R.id.butt2);
        Button butt3 = (Button) findViewById(R.id.butt3);
        Button butt4 = (Button) findViewById(R.id.butt4);
        Button butt5 = (Button) findViewById(R.id.butt5);
        Button butt6 = (Button) findViewById(R.id.butt24);
        butt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OffenceType.this,OffenceDetail.class);

                intent.putExtra("dName", dName);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype",vechiletype);
                intent.putExtra("uidtype",uidtype);
                intent.putExtra("uidvalue",uidvalue);
                startActivity(intent);        }
        });
        butt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OffenceType.this,OffenceDetail2.class);
                intent.putExtra("dName", dName);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype",vechiletype);
                intent.putExtra("uidtype",uidtype);
                intent.putExtra("uidvalue",uidvalue);
                startActivity(intent);        }
        });
        butt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OffenceType.this,OffenceDetail3.class);
                intent.putExtra("dName", dName);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype",vechiletype);
                intent.putExtra("uidtype",uidtype);
                intent.putExtra("uidvalue",uidvalue);
                startActivity(intent);        }
        });
        butt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OffenceType.this,OffenceDetail4.class);
                intent.putExtra("dName", dName);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype",vechiletype);
                intent.putExtra("uidtype",uidtype);
                intent.putExtra("uidvalue",uidvalue);
                startActivity(intent);        }
        });
        butt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OffenceType.this,OffenceDetail5.class);
                intent.putExtra("dName", dName);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype",vechiletype);
                intent.putExtra("uidtype",uidtype);
                intent.putExtra("uidvalue",uidvalue);
                startActivity(intent);        }
        });
        butt6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OffenceType.this,OffenceDetail6.class);

                intent.putExtra("dName", dName);
                intent.putExtra("vechileno", vechile_no);
                intent.putExtra("dmobile", dmobile);
                intent.putExtra("vechiletype",vechiletype);
                intent.putExtra("uidtype",uidtype);
                intent.putExtra("uidvalue",uidvalue);
                startActivity(intent);        }
        });
    }


}
