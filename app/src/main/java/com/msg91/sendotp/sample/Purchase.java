package com.msg91.sendotp.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Purchase extends AppCompatActivity {
TextView pname;
String employer,Contact;
ImageView pname4;
Intent i;
ImageButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
         pname=findViewById(R.id.pname);
         bt=findViewById(R.id.p_btn);
        pname4=findViewById(R.id.pname4);
         i=getIntent();
         employer=i.getStringExtra("comname");
         Contact=i.getStringExtra("contact");
         pname.setText(i.getStringExtra("comname"));
        Picasso.get().load(i.getStringExtra("image")).into(pname4);

bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+i.getStringExtra("contact")));
        Toast.makeText(Purchase.this,"Calling  "+employer,Toast.LENGTH_LONG).show();
        startActivity(i);
    }
});
    }
}
