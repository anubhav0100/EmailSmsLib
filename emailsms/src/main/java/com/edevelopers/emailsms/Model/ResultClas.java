package com.edevelopers.emailsms.Model;

import com.edevelopers.emailsms.Library.Const;

public class ResultClas {
    String otp="";
    String validsec="";
    int type= 0;

    public ResultClas(){

    }

    public ResultClas(String otp,String validsec,String type){
        this.otp = otp;
        this.validsec = validsec;
        if(type.equals("Email")){
            this.type = Const.TYPE_EMAIL;
        }
        else if(type.equals("Msg")){
            this.type = Const.TYPE_PHONE_NUMBER;
        }
    }

    public int getType() {
        return type;
    }

    public String getOtp() {
        return otp;
    }

    public String getValidsec() {
        return validsec;
    }
}
