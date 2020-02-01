package com.msg91.sendotp.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class sellerregister extends AppCompatActivity {
    EditText sname, semail, sphone,saddress,spass,scnpass;
    TextView snametxt, semailtxt,saddresstxt,sphonetxt,spasstxt,spasscntxt,login;
    CardView sregister_card;
    Button sregisterbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerregister);
        sname = findViewById(R.id.sellername);
        snametxt = findViewById(R.id.sellernametxt);
        semail = findViewById(R.id.selleremail);
        semailtxt = findViewById(R.id.selleremailtxt);
        sphone = findViewById(R.id.sellerphone);
        sphonetxt=findViewById(R.id.sellerphonetxt);
        saddress = findViewById(R.id.selleraddress);
        saddresstxt= findViewById(R.id.selleraddresstxt);
        spass=findViewById(R.id.sellerpassword);
        spasstxt=findViewById(R.id.sellerpasswordtxt);
        scnpass=findViewById(R.id.sellercnpassword);
        spasscntxt=findViewById(R.id.sellercnpasswordtxt);
        login=findViewById(R.id.text);
        sregister_card = findViewById(R.id.sellerregister_card);
        sregisterbutton=findViewById(R.id.sellerregister_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iorewse=new Intent(getApplicationContext(),Admin_login.class);
                startActivity(iorewse);
            }
        });
        sregisterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(sname.getText().toString().isEmpty()||semail.getText().toString().isEmpty()||sphone.getText().toString().isEmpty()||saddress.getText().toString().isEmpty()||spass.getText().toString().isEmpty()||scnpass.getText().toString().isEmpty())&&(spass.getText().toString().equals(scnpass.getText().toString()))) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/PlaceMe/adminreg.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(sellerregister.this, response, Toast.LENGTH_LONG).show();
                                    if (response.equals("Success")) {

                                        new SweetAlertDialog(sellerregister.this, SweetAlertDialog.WARNING_TYPE)
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
                                                                        Intent in = new Intent(sellerregister.this, Admin_login.class);
                                                                        startActivity(in);
                                                                    }
                                                                })
                                                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                                    }
                                                })
                                                .show();


//
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


                            params.put("name", sname.getText().toString());
                            params.put("email_id", semail.getText().toString());
                            params.put("phno", sphone.getText().toString());
                            params.put("address", saddress.getText().toString());
                            params.put("password", spass.getText().toString());

//returning parameter
                            return params;
                        }

                    };


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(sellerregister.this);
                    requestQueue.add(stringRequest);
                } else
                {
                    Toast.makeText(sellerregister.this,"Unsuccesfull Attempt",Toast.LENGTH_LONG).show();

                }
            }


        });


    }
}
