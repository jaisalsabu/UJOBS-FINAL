package com.msg91.sendotp.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.msg91.sendotp.sample.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Cart extends AppCompatActivity {
    TextView pname0,pname20;
    EditText pname30;
    ImageView pname40;
    Intent i;
    Button bt0;
    SharedPreferences shu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        shu=getSharedPreferences("data",MODE_PRIVATE);
        pname0=findViewById(R.id.pname0);
        bt0=findViewById(R.id.p_btn0);
        pname20=findViewById(R.id.pname20);
        pname30=findViewById(R.id.pname30);
        pname40=findViewById(R.id.pname40);
        i=getIntent();
        pname0.setText(i.getStringExtra("name"));
        pname20.setText(i.getStringExtra("name1"));
        pname30.setText(i.getStringExtra("name2"));
        Picasso.get().load(i.getStringExtra("image")).into(pname40);
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/AgroTimes/addcart.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//If we are getting success from server
                                Toast.makeText(Cart.this,response,Toast.LENGTH_LONG).show();
                                if(response.equals("Registration Successful"))
                                {

                                    new SweetAlertDialog(Cart.this, SweetAlertDialog.WARNING_TYPE)
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
                                                                    Intent in=new Intent(Cart.this,Signin.class);
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


                        params.put("phone",shu.getString("phone",null));//correct
                        params.put("name",i.getStringExtra("name1"));//correct
                        params.put("det",i.getStringExtra("name2"));//correct
                        params.put("price",i.getStringExtra("name"));//correct
                        params.put("image",i.getStringExtra("image"));//correct



//returning parameter
                        return params;
                    }

                };
//Adding the string request to the queue
                RequestQueue requestQueue = Volley.newRequestQueue(Cart.this);
                requestQueue.add(stringRequest);

            }
        });

    }
}
