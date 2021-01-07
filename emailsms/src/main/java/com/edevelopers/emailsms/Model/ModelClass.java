package com.edevelopers.emailsms.Model;

import android.app.Activity;
import android.content.Context;

import com.edevelopers.emailsms.Library.Const;

public class ModelClass {

    Context context;
    String api_key="";
    String appname="";
    String api_secret="";
    String email="";
    String phonenumber="";
    String type = "";

    public ModelClass(){

    }

    public ModelClass(Context context, String api_key, String apisecret, String appname, String emailorPhonenumber, int type){
        this.context = context;
        this.api_key = api_key;
        this.api_secret = apisecret;
        this.appname = appname;
        if(type == Const.TYPE_EMAIL){
            this.email = emailorPhonenumber;
            this.type = "Email";
        }
        else if(type == Const.TYPE_PHONE_NUMBER){
            this.phonenumber = emailorPhonenumber;
            this.type = "Msg";
        }
    }

    public Context getContext() {
        return context;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public String getAppname() {
        return appname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getType() {
        return type;
    }
}
