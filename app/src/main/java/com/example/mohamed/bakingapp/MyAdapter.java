package com.example.mohamed.bakingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static com.example.mohamed.bakingapp.R.id.imageView;

/**
 * Created by mohamed on 5/28/2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
   private Data[] data;
   Context context ;
    public MyAdapter(Data[] data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemlayoutview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recip_card, null);
        MyViewHolder holder = new MyViewHolder(itemlayoutview);

        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textview.setText(data[position].getRecipName());
        context = holder.imageview.getContext();
        Picasso.with(context)
                .load(data[position].getRecipImg())
                .resize(1500,1100)
                .into(holder.imageview);

    }

    @Override
    public int getItemCount() {
        return data.length ;
    }


   public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textview ;
        ImageView imageview ;

        public MyViewHolder(View itemView) {
            super(itemView);
            textview = (TextView)itemView.findViewById(R.id.textView);
            imageview = (ImageView)itemView.findViewById(imageView);
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
}

        }
}