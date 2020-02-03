package com.msg91.sendotp.sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Chequeadapter extends RecyclerView.Adapter<Chequeadapter.ProductViewHolder> {
    Intent i;
    private Context mCtx;
    private List<Cheque> productList;

    public Chequeadapter(Context mCtx, List<Cheque> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque cheque;   cheque = productList.get(position);

        //loading the image
holder.blog.setText(cheque.getComname());
        Picasso.get().load(cheque.getImage()).into(holder.date);
holder.datem.setText(cheque.getNoofvacc());
holder.txtt.setText(cheque.getPos());
holder.tram.setText(cheque.getExperience());

holder.purchase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent i = new Intent(mCtx, Purchase.class);
        i.putExtra("comname", cheque.getComname());
        i.putExtra("image", cheque.getImage());
        i.putExtra("contact",cheque.getContact());
        mCtx.startActivity(i);
    }
});

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView text,txtt,datem,blog,tram;
        ImageView date;
        Button purchase;
        public ProductViewHolder(View itemView) {
            super(itemView);




            txtt=itemView.findViewById(R.id.pph2);
            date=itemView.findViewById(R.id.t_name1);
            datem=itemView.findViewById(R.id.pph1);
            blog=itemView.findViewById(R.id.t_discription1);
            tram=itemView.findViewById(R.id.pph62);
            purchase=itemView.findViewById(R.id.purchase);


        }

    }



}