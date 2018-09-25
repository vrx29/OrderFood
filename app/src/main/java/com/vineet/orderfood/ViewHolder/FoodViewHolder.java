package com.vineet.orderfood.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vineet.orderfood.Interface.ItemClickListner;
import com.vineet.orderfood.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    View mView;

    private ItemClickListner itemClickListner;

    public FoodViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(this);
    }

    public void setName(String Name){
        TextView food_name = (TextView)mView.findViewById(R.id.food_name);
        food_name.setText(Name);
    }
    public void setImage(Context cnt, String Image){
        ImageView food_image = (ImageView)mView.findViewById(R.id.food_image);
        Picasso.get().load(Image).into(food_image);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v, getAdapterPosition(),false);
    }
}
