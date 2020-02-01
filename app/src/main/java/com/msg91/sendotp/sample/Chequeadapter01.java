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

public class Chequeadapter01 extends RecyclerView.Adapter<Chequeadapter01.ProductViewHolder> {
    Intent i;
    private Context mCtx;
    private List<Cheque01> productLister;

    public Chequeadapter01(Context mCtx, List<Cheque01> productList) {
        this.mCtx = mCtx;
        this.productLister = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recyler, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque01 cheque;   cheque = productLister.get(position);

        //loading the image
        holder.blog0.setText(cheque.getComname());
        Picasso.get().load(cheque.getImage()).into(holder.date0);
        holder.datem0.setText(cheque.getNoofvacc());
        holder.txtt0.setText(cheque.getPos());
        holder.tram.setText(cheque.getExperience());

holder.purchase0.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent i = new Intent(mCtx, Purchase.class);

    /*    i.putExtra("image", cheque.getPrize());
        i.putExtra("name", cheque.getUser());
        i.putExtra("name1", cheque.getImage());
        i.putExtra("name2", cheque.getStatus()); */
        mCtx.startActivity(i);
    }
});
holder.remove.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent imn=new Intent(mCtx,emptycart.class);
        mCtx.startActivity(imn);
    }
});

    }

    @Override
    public int getItemCount() {
        return productLister.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView txtt0,datem0,blog0,tram;
        ImageView date0;
        Button purchase0,remove;
        public ProductViewHolder(View itemView) {
            super(itemView);




            txtt0=itemView.findViewById(R.id.pph20);
            date0=itemView.findViewById(R.id.t_name10);
            datem0=itemView.findViewById(R.id.pph120);
            blog0=itemView.findViewById(R.id.t_discription10);
            tram=itemView.findViewById(R.id.textView21);
            purchase0=itemView.findViewById(R.id.purchase0);
            remove=itemView.findViewById(R.id.purchase0f);


        }

    }



}