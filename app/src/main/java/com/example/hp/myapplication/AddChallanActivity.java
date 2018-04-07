package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddChallanActivity extends Activity  {
    String iteamvalue;
    Spinner dropdoownmenu;
    Spinner spinner;String iteamvalue1;boolean phone_no_check; boolean name_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_addchallan);

        Button but4 = (Button) findViewById(R.id.butt24);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddChallanActivity.this, OffenceType.class);

                String res = "";String insurance,owner ,vechile_no,vechtype;
                EditText tx1 = (EditText) findViewById(R.id.vechileno);
                EditText tx2 = (EditText) findViewById(R.id.dname);
	            EditText tx3 = (EditText) findViewById(R.id.dmobile);
                EditText tx4 = (EditText) findViewById(R.id.uidvalue);



                String s1 = tx1.getText().toString();
                String s2 = tx2.getText().toString();
                String s3= tx3.getText().toString();
                String s4= tx4.getText().toString();
                      phone_no_check= isValidMobile(s3);
                      name_check=IsvalidateName(s2);

                String vechiletype=iteamvalue;
                         if(phone_no_check && name_check && s1.length()>0 && s4.length()>0 && s3.length()==10){
                             //set the value of uid uidtype vechile type from the gui
                             intent.putExtra("dName", s2);
                             intent.putExtra("vechileno", s1);
                             intent.putExtra("dmobile", s3);
                             intent.putExtra("vechiletype",vechiletype);
                             intent.putExtra("uidtype",iteamvalue1);
                             intent.putExtra("uidvalue",s4);


                            // Toast.makeText(AddChallanActivity.this, "Selected :" + iteamvalue1, Toast.LENGTH_SHORT).show();
                             startActivity(intent);
                         }
                         else{
                             Toast.makeText(AddChallanActivity.this, "incorrect data ", Toast.LENGTH_SHORT).show();
                         }
                String uidvalue;

            }
        });

        dropdoownmenu = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<>();
        list.add("Two Wheller");
        list.add("Four Wheller");
        list.add("other");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdoownmenu.setAdapter(adapter);
        dropdoownmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 iteamvalue = parent.getItemAtPosition(position).toString();
               // Toast.makeText(AddChallanActivity.this, "Selected :" + iteamvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner = (Spinner) findViewById(R.id.spinner1);
        List<String> list1 = new ArrayList<>();
        list1.add("Adhar Card");
        list1.add("Pan Card");
        list1.add("Voter ID");
        list1.add("other");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 iteamvalue1 = parent.getItemAtPosition(position).toString();
               // Toast.makeText(AddChallanActivity.this, "Selected :" + iteamvalue1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
    public static boolean IsvalidateName(String txt) {

        String regx = "^[\\p{L} .'-]+$";;
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
}