package com.msg91.sendotp.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Review extends AppCompatActivity {
TextView pname,pdetails;
EditText review,name;
Button sudmit;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        pname=findViewById(R.id.repname);
        pdetails=findViewById(R.id.repd);
        review=findViewById(R.id.yourreview);
        sudmit=findViewById(R.id.re_btn);
        name=findViewById(R.id.ryname);

        i=getIntent();
        pname.setText(i.getStringExtra("name1"));
        pdetails.setText(i.getStringExtra("name2"));
//        pname3.setText(i.getStringExtra("name2"));


sudmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        if (review.getText().toString().isEmpty()){

            review.setError("Empty field");

        }
       else if (name.getText().toString().isEmpty()){

            name.setError("Empty field");

        }
        else{
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/AgroTimes/userreview.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server
                            Toast.makeText(Review.this,response,Toast.LENGTH_LONG).show();
                            if(response.equals("Registration Successful"))
                            {

                                new SweetAlertDialog(Review.this, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("Thankyou")
                                        .setContentText("back to home!")
                                        .setConfirmText("ok")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                sDialog
                                                        .setTitleText("Logining...!")

                                                        .setConfirmText("OK")

                                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                            @Override
                                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                Intent in=new Intent(Review.this,MainActivityhome.class);
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



                    params.put("a",i.getStringExtra("name1"));
                    params.put("b",i.getStringExtra("name2"));
                    params.put("name", name.getText().toString());
                    params.put("review", review.getText().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                    return params;
                }

            };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(Review.this);
            requestQueue.add(stringRequest);
        }










    }
});


    }
}
