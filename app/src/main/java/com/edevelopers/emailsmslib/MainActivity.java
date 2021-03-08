package com.edevelopers.emailsmslib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.widget.Toast;

import com.edevelopers.emailsms.Model.ResultClas;
import com.edevelopers.emailsms.Service.OtpSendRequest;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Email = "Email"; /****Enter Email***/
        String Apikey = "";
        String ApiSecret = "";
        String AppName = "Test App Email"; /**** Application Name***/
        OtpSendRequest.SendEmailOtp(MainActivity.this, Apikey, ApiSecret, AppName, Email, new OtpSendRequest.Callback_Otp() {
            @Override
            public void onSuccess(String ResultOtp) {

                /****Navigate To another activity and get otp from user and verify it. ***/

                Boolean b = OtpSendRequest.OtpVerification(MainActivity.this,"Get User Otp Here");
                if(b){
                    Toast.makeText(MainActivity.this,"Verification Complete ",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String Error) {
                Toast.makeText(MainActivity.this,"Error "+Error,Toast.LENGTH_SHORT).show();
            }
        });


    }
}