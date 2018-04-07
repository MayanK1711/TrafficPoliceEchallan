package com.example.hp.myapplication;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class finalact extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    private EditText user;
    private EditText pass;
    private EditText subject;
    private EditText body;
    private EditText recipient;
    private ImageView  imageHolder;
    private final int requestCode = 20;
    private Bitmap bitmap;
    String storeFilename;
    File finalFile;String MAILBODY;

    //Send button
    private Button buttonSend; String VECH_NO;String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalact);
        //Initializing the views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
       // editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        //editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        buttonSend = (Button) findViewById(R.id.buttonSend);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                MAILBODY= null;
            } else {
                MAILBODY = extras.getString("EMAilbody");
                VECH_NO = extras.getString("vechileno");



                try {
                    //yaha server ka ip address add krege
                    URL u1 = new URL("http://192.168.238.1:9595/project/webapi/myresource/getemailid?entervechno=" +
                            VECH_NO + "");
                    HttpURLConnection ucon = (HttpURLConnection) u1.openConnection();
                    ucon.setRequestMethod("POST");
                    ucon.setDoInput(true);
                    ucon.setDoOutput(true);

                    //yaha lagaya buffer reader)
                    BufferedReader br = new BufferedReader(new InputStreamReader(ucon.getInputStream()));
                   mail = br.readLine();
                    Toast.makeText(this, mail+"", Toast.LENGTH_SHORT).show();
                    editTextEmail.setText(mail);
                }
                catch (Exception e){
                    System.out.print(e);
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

               // http://192.168.238.1:9595/project/webapi/myresource/getemailid
               // Toast.makeText(this, "Email is "+MAILBODY, Toast.LENGTH_SHORT).show();
            }
        }

        Button capturedImageButton = (Button)this.findViewById(R.id.imagebuttton);//todo write id of button of image click
        capturedImageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                finalact.this.startActivityForResult(photoCaptureIntent, 20);
            }
        });

        //Send button
         Button buttonSend;
    }

    private void sendEmail() {
        //Getting content for email
        String email = editTextEmail.getText().toString().trim();
       // String subject = editTextSubject.getText().toString().trim();
        //String message = editTextMessage.getText().toString().trim();
        Toast.makeText(this, email+MAILBODY+"", Toast.LENGTH_SHORT).show();
        //Creating SendMail object
        SendMail sm = new SendMail(this, email, "MAIL FOR  TRAFFIC CHALLAN", MAILBODY,finalFile);

        //Executing sendmail to send email
        sm.execute();
    }

    public void onClick(View v) {
        sendEmail();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.getClass();
        if(20 == requestCode && resultCode == -1) {
            this.bitmap = (Bitmap)data.getExtras().get("data");
            String partFilename = this.currentDateFormat();
            this.storeCameraPhotoInSDCard(this.bitmap, partFilename);
            Uri tempUri = this.getImageUri(this.getApplicationContext(), this.bitmap);
            finalFile = new File(this.getRealPathFromURI(tempUri));
            Toast.makeText(this, finalFile+"image attached", Toast.LENGTH_SHORT).show();

        }

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", (String)null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = this.getContentResolver().query(uri, (String[])null, (String)null, (String[])null, (String)null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex("_data");
        return cursor.getString(idx);
    }

    private String currentDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String currentTimeStamp = dateFormat.format(new Date());
        return currentTimeStamp;
    }

    private void storeCameraPhotoInSDCard(Bitmap bitmap, String currentDate) {
        File outputFile = new File(Environment.getExternalStorageDirectory(), "photo_" + currentDate + ".jpg");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private Bitmap getImageFileFromSDCard(String filename) {
        Bitmap bitmap = null;
        File imageFile = new File(Environment.getExternalStorageDirectory() + filename);

        try {
            FileInputStream fis = new FileInputStream(imageFile);
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        }

        return bitmap;
    }
}
