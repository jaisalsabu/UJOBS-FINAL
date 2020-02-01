package com.msg91.sendotp.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_home extends AppCompatActivity {
Button phycologist_btn,terapy_btn,event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        phycologist_btn=findViewById(R.id.remove_btn);
        terapy_btn=findViewById(R.id.terapy_btn);
        terapy_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent j= new Intent(getApplicationContext(),Class_time_Admin.class);
        startActivity(j);
          }
            });
        phycologist_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(Admin_home.this,"varutaaaa ippo",Toast.LENGTH_LONG).show();
          }
            });

    }

}

