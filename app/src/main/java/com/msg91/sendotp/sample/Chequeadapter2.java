package com.msg91.sendotp.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Chequeadapter2 extends RecyclerView.Adapter<Chequeadapter2.ProductViewHolder> {

    private Context mCtx;
    private List<Cheque2> productList;

    public Chequeadapter2(Context mCtx, List<Cheque2> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_event1, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque2 cheque;   cheque = productList.get(position);


                 holder.tid.setText(cheque.getImage());
                 holder.tname.setText(cheque.getUser());
                 holder.tph.setText(cheque.getStatus());
                 holder.temail.setText(cheque.getPrize());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView tid,tname,tph,temail;

        public ProductViewHolder(View itemView) {
            super(itemView);




            tid=itemView.findViewById(R.id.tid1);
            tname=itemView.findViewById(R.id.pnn1);
            tph=itemView.findViewById(R.id.pph31);
            temail=itemView.findViewById(R.id.padd1);






        }

    }



}