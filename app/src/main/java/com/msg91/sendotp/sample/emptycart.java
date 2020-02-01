package com.msg91.sendotp.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class emptycart extends AppCompatActivity {
    Button empty;
    SharedPreferences sfr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emptycart);
        empty=findViewById(R.id.button);
        sfr=getSharedPreferences("data",MODE_PRIVATE);
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/AgroTimes/agroemptcrt.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//If we are getting success from server
                                Toast.makeText(emptycart.this,response,Toast.LENGTH_LONG).show();
                                if(response.equals("Registration Successful"))
                                {

                                    new SweetAlertDialog(emptycart.this, SweetAlertDialog.WARNING_TYPE)
                                            .setTitleText("Registration Success")
                                            .setContentText("Login to Dashboard!")
                                            .setConfirmText("Yes,Login")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sDialog) {
                                                    sDialog
                                                            .setTitleText("Logining...!")

                                                            .setConfirmText("OK")

                                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                                @Override
                                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                    Intent in=new Intent(emptycart.this,Signin.class);
                                                                    startActivity(in);
                                                                }
                                                            })
                                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                                }
                                            })
                                            .show();

                                }


                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                            }

                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();


                        params.put("phone",sfr.getString("phone",null));



//returning parameter
                        return params;
                    }

                };
//Adding the string request to the queue
                RequestQueue requestQueue = Volley.newRequestQueue(emptycart.this);
                requestQueue.add(stringRequest);

            }
        });

    }
}
