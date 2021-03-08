package com.edevelopers.emailsms.Service;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.edevelopers.emailsms.Library.Const;
import com.edevelopers.emailsms.Library.customRequest;
import com.edevelopers.emailsms.Model.ModelClass;
import com.edevelopers.emailsms.Model.ResultClas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataAccessLib {
    public static final String apiurl = "http://emailsmsservice.edevlopers.com/api/emailsms/";

    public interface Callback
    {
        void onSuccess(ResultClas Result);

        void onError(String Error);
    }


    public static void RequestOtp( ModelClass Modeldata, final Callback callback){
        RequestQueue queue= Volley.newRequestQueue(Modeldata.getContext());
        String url = apiurl+"sendMessage";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.accumulate(Const.api_key, Modeldata.getApi_key());
            jsonObject.accumulate(Const.appname, Modeldata.getAppname());
            jsonObject.accumulate(Const.api_secret, Modeldata.getApi_secret());
            jsonObject.accumulate(Const.email, Modeldata.getEmail());
            jsonObject.accumulate(Const.phonenumber, Modeldata.getPhonenumber());
            jsonObject.accumulate(Const.type, Modeldata.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try{
            customRequest jsonObjectRequest = new customRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    ResultClas fed = new ResultClas();
                    try{
                        for(int i = 0;i < response.length();i++){
                            JSONObject explrObject = response.getJSONObject(i);
                            fed = new ResultClas(
                                    explrObject.getString(Const.otp),
                                    explrObject.getString(Const.validsec),
                                    explrObject.getString(Const.type)
                            );
                        }
                    }
                    catch (Exception e){
                        callback.onError(e.getMessage());
                    }
                    Const.RecievedRequest = fed;
                    callback.onSuccess(fed);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    callback.onError(error.getMessage());
                }
            });

            queue.add(jsonObjectRequest);
        }catch (Exception e) {
            Log.d(Const.TAG,""+e.getMessage());
        }
    }
}
