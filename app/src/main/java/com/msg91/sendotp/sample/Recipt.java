package com.msg91.sendotp.sample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Recipt extends AppCompatActivity {
Intent j;
String a,b,c,d,e,f,g,h,hh;

TextView rid,rname,rph,remail,radd,rnos,rprice,rpname,rpdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);
        rid = findViewById(R.id.rid);
        rname = findViewById(R.id.rname);
        rph = findViewById(R.id.rph);
        remail=findViewById(R.id.remail);
        radd=findViewById(R.id.radd);
        rnos=findViewById(R.id.rnos);
        rprice=findViewById(R.id.rprice);
        rpname=findViewById(R.id.rpname);
        rpdetails=findViewById(R.id.rpdetails);
        j=getIntent();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/AgroTimes/recipt.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
                                a=json_obj.getString("trackid_id");
                                b=json_obj.getString("name");
                                c=json_obj.getString("phone");
                                d=json_obj.getString("email");
                                e=json_obj.getString("address");
                                f=json_obj.getString("nos");
                                g=json_obj.getString("price");
                                h=json_obj.getString("product_name");
                                hh=json_obj.getString("product_details");
                                rid.setText(a);
                                rname.setText(b);
                                rph.setText(c);
                                remail.setText(d);
                                radd.setText(e);
                                rnos.setText(f);
                                rprice.setText(g);
                                rpname.setText(h);
                               rpdetails.setText(hh);

                            }
//Toast.makeText(
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
if(response.contains("success"))
{
    new Handler().postDelayed(new Runnable() {


        @Override
        public void run() {
            // This method will be executed once the timer is over
            Intent i = new Intent(Recipt.this, MainActivityhome.class);
            startActivity(i);
            finish();
        }
    }, 3500);
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

                params.put("tid", j.getStringExtra("tid"));

//returning parameter
                return params;
            }

        };


//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        sms();
    }
public void sms()
{
    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Flower_maegument_system/c_copy1.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
//If we are getting success from server
                    Toast.makeText(Recipt.this, response, Toast.LENGTH_LONG).show();
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

            params.put("tid",rid.getText().toString());
            params.put("tname",rname.getText().toString());
            params.put("tph",rph.getText().toString());
            params.put("tadd",radd.getText().toString());
            params.put("tnos",rnos.getText().toString());
            params.put("tppraice",rprice.getText().toString());
            params.put("tpname",rpname.getText().toString());
            params.put("tpdetails",rpdetails.getText().toString());


            return params;
        }

    };


//Adding the string request to the queue
    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
    requestQueue.add(stringRequest);
}


}








