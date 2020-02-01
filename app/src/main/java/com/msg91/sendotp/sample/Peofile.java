package com.msg91.sendotp.sample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Peofile extends AppCompatActivity {
    SharedPreferences sh;

    TextView dname,dph,did,dob,daddress,dgender,demail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peofile);
        dname=findViewById(R.id.rdname1);
        did=findViewById(R.id.docyou31);
        dph=findViewById(R.id.dw1);
       // log=findViewById(R.id.log1);
        demail=findViewById(R.id.demail1);
//        logout= Objects.requireNonNull(getActivity()).getSharedPreferences("Official",MODE_PRIVATE);
        dob=findViewById(R.id.dob1);
        daddress=findViewById(R.id.daddress1);
        dgender=findViewById(R.id.dgender1);

        sh= Objects.requireNonNull(getApplicationContext()).getSharedPreferences("data",MODE_PRIVATE);
        String Item=sh.getString("phone",null);

        String ii=   sh.getString("id",null);
        String nn=  sh.getString("name",null);
        String ee=    sh.getString("email",null);
        String add=     sh.getString("address",null);
        String ex=    sh.getString("gender",null);
        String ty=   sh.getString("dob",null);


        dph.setText(Item);
        did.setText(nn);
        dname.setText(ii);
        demail.setText(ee);
        daddress.setText(add);
        dgender.setText(ex);
        dob.setText(ty);
    }
}
