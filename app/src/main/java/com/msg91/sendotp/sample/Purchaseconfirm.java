package com.msg91.sendotp.sample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Purchaseconfirm extends AppCompatActivity implements PaymentResultListener {
    EditText name, ph, email, add, nos;
    Button pay;
    Intent i;
String f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchaseconfirm);
        name = findViewById(R.id.pnm);
        ph = findViewById(R.id.pphn);
        email = findViewById(R.id.pem);
        add = findViewById(R.id.pad);
        pay = findViewById(R.id.pay);
        nos = findViewById(R.id.nos);
        i = getIntent();
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startPayment();


            }
        });
    }

    public void startPayment() {
        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        final Activity activity = this;

        final Checkout co = new Checkout();

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Flower Shop");
            options.put("description", "Demoing Charges");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount", String.valueOf(Integer.parseInt(i.getStringExtra("amount")) * (Integer.parseInt(nos.getText().toString())) * 100));

            JSONObject preFill = new JSONObject();
            preFill.put("email", "test@razorpay.com");
            preFill.put("contact", "9876543210");

            options.put("prefill", preFill);

            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(final String s) {
        f=s;
        if (ph.getText().toString().isEmpty()) {

            ph.setError("empty ");

        } else if (email.getText().toString().isEmpty()) {

            email.setError("empty ");

        } else if (name.getText().toString().isEmpty()) {

            name.setError("empty ");

        } else if (add.getText().toString().isEmpty()) {

            add.setError("empty ");

        } else if (nos.getText().toString().isEmpty()) {

            nos.setError("empty ");

        } else {


            StringRequest stringRequest;
            stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/AgroTimes/productpayment.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server
                            Toast.makeText(Purchaseconfirm.this, response, Toast.LENGTH_LONG).show();
//
                            // ph.getText().clear();
                            email.getText().clear();
                            name.getText().clear();
                            add.getText().clear();
                            nos.getText().clear();

                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");


                                }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
// Toast.makeText(Signin.this, "success", Toast.LENGTH_LONG).show();
                            if (response.contains("success")) {
                               // Toast.makeText(Purchaseconfirm.this,s,Toast.LENGTH_LONG).show();
                                Intent in = new Intent(getApplicationContext(), Recipt.class);
                                in.putExtra("tid", s);
                                startActivity(in);
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
//Adding parameters to request
                    params.put("tid", s);
                    params.put("nm", name.getText().toString());
                    params.put("ph", ph.getText().toString());
                    params.put("tdance", email.getText().toString());
                    params.put("tname", add.getText().toString());
                    params.put("nos", nos.getText().toString());
                    params.put("amt", i.getStringExtra("amount"));
                    params.put("pnm", i.getStringExtra("pname"));
                    params.put("pd", i.getStringExtra("pd"));

//returning parameter
                    return params;
                }

            };


            //Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(Purchaseconfirm.this);
            requestQueue.add(stringRequest);

        }

        new SweetAlertDialog(Purchaseconfirm.this, SweetAlertDialog.WARNING_TYPE)
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
sms();
                                        Intent in = new Intent(Purchaseconfirm.this, MainActivityhome.class);
                                        startActivity(in);

                                    }
                                })
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                })
                .show();

    }

    @Override
    public void onPaymentError(int i, String s) {

    }

    public void sms() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/ArtGal/c_copy1.php ",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Purchaseconfirm.this, response, Toast.LENGTH_LONG).show();
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
//Adding parameters to request
                params.put("tid", f);
                params.put("tname", name.getText().toString());
                params.put("tph", ph.getText().toString());
                params.put("tadd", add.getText().toString());
                params.put("tnos", nos.getText().toString());
                params.put("tppraice", i.getStringExtra("amount"));
                params.put("tpname", i.getStringExtra("pname"));
                params.put("tpdetails", i.getStringExtra("pd"));


//returning parameter
                return params;
            }
        };
        RequestQueue requestQueue1 = Volley.newRequestQueue(Purchaseconfirm.this);
        requestQueue1.add(stringRequest);
    }
}
