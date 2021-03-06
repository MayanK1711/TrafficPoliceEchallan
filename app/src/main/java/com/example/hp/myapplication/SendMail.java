package com.example.hp.myapplication;

/**
 * Created by lenovo-i5 on 27-03-2018.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by Belal on 10/30/2015.
 */

//Class is extending AsyncTask because this class is going to perform a networking operation
public class SendMail extends AsyncTask<Void,Void,Void> {

    //Declaring Variables
    private Context context;
    private Session session;
    Multipart multipart;
    //Information to send email
    private String email;
    private String subject;
    private String message;
    private Multipart _multipart;
    File image;
    BodyPart messageBodyPart; String EmailBody;
    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;  MimeMessage mm;

    //Class Constructor
    public SendMail(Context context, String email, String subject, String message,File file){
        //Initializing variables
        this.context = context;
        this.email = email;
        this.subject = subject;//message   UNDO I HAVE INTERCHANGED SUBJECT TO EASSAGE AND MESSAGE TO SUBJECT
        this.message = message;///subject
        image=file; EmailBody=message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context,"Sending message","Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
        Toast.makeText(context,"Message Sent",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });

        try {
            //Creating MimeMessage object
          mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Adding subject
            //addAttachment(image.toString());

            mm.setSubject(subject);
            //Adding message

            mm.setText(message);
            //add attachment
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(EmailBody);//TESTING
            messageBodyPart.setContent(EmailBody,"text/html");//TESTING
             multipart = new MimeMultipart();//testing
            multipart.addBodyPart(messageBodyPart);//testing

            addAttachment(image.toString());

            //this._multipart.addBodyPart(messageBodyPart);

            System.out.print("mail is being to be delivered");
            mm.setHeader("X-Priority", "1");
            mm.setContent(multipart);//testing to be uncomment


            //Sending email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAttachment(String filename) throws Exception {
       BodyPart messageBodyPart = new MimeBodyPart(); // testing to be commented
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));// testing chanfge to mm
        messageBodyPart.setFileName(filename);// testing chanfge to mm
        multipart.addBodyPart(messageBodyPart);//tetsing to be comment

    }



}
