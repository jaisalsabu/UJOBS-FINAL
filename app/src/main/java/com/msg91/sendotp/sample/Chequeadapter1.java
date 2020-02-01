package com.msg91.sendotp.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Chequeadapter1 extends RecyclerView.Adapter<Chequeadapter1.ProductViewHolder> {

    private Context mCtx;
    private List<Cheque1> productList;

    public Chequeadapter1(Context mCtx, List<Cheque1> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_event, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque1 cheque;   cheque = productList.get(position);


                 holder.tid.setText(cheque.getImage());
                 holder.tname.setText(cheque.getUser());
                 holder.tph.setText(cheque.getStatus());
                 holder.temail.setText(cheque.getDes());
                 holder.taddress.setText(cheque.getPrize());
                 holder.tnos.setText(cheque.getPrize1());
                 holder.tprice.setText(cheque.getPrize2());
                 holder.tproductname.setText(cheque.getPrize3());
                 holder.tpproductdetailst.setText(cheque.getPrize4());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView tid,tname,tph,temail,taddress,tnos,tprice,tproductname,tpproductdetailst;

        public ProductViewHolder(View itemView) {
            super(itemView);




            tid=itemView.findViewById(R.id.tid);
            tname=itemView.findViewById(R.id.pnn);
            tph=itemView.findViewById(R.id.pph3);
            temail=itemView.findViewById(R.id.pemail);
            taddress=itemView.findViewById(R.id.padd);
            tnos=itemView.findViewById(R.id.noss);
            tprice=itemView.findViewById(R.id.pri);
            tproductname=itemView.findViewById(R.id.prnm);
            tpproductdetailst=itemView.findViewById(R.id.prdt);





        }

    }



}