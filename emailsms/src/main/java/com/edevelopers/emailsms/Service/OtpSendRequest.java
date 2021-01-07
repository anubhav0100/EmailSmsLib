package com.edevelopers.emailsms.Service;

import android.content.Context;

import com.edevelopers.emailsms.Library.Const;
import com.edevelopers.emailsms.Model.ModelClass;
import com.edevelopers.emailsms.Model.ResultClas;

import java.util.ArrayList;

public class OtpSendRequest {

    public interface Callback_Otp
    {
        void onSuccess(ResultClas ResultOtp);

        void onError(String Error);
    }

    public static void SendEmailOtp(Context context, String Apikey, String ApiSecret, String AppName, String Email, final Callback_Otp otp){
        final ResultClas fed = new ResultClas();
        ModelClass model = new ModelClass(context,Apikey,ApiSecret,AppName,Email, Const.TYPE_EMAIL);
        DataAccessLib.RequestOtp(model, new DataAccessLib.Callback() {
            @Override
            public void onSuccess(ResultClas Result) {
                otp.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                otp.onError(Error);
            }
        });
    }

    public static void SendPhoneNumberOtp(Context context,String Apikey,String ApiSecret,String AppName,String PhoneNumber, final Callback_Otp otp){
        final ResultClas fed = new ResultClas();
        ModelClass model = new ModelClass(context,Apikey,ApiSecret,AppName,PhoneNumber, Const.TYPE_PHONE_NUMBER);
        DataAccessLib.RequestOtp(model, new DataAccessLib.Callback() {
            @Override
            public void onSuccess(ResultClas Result) {
                otp.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                otp.onError(Error);
            }
        });
    }

    public static Boolean OtpVerification(Context context,String Otp){
        if(Const.RecievedRequest.getOtp().equals(Otp)){
            return true;
        }
        else{
            return false;
        }
    }

}
