package com.vineet.orderfood.ViewHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vineet.orderfood.Interface.ItemClickListner;
import com.vineet.orderfood.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;

    private ItemClickListner itemClickListner;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(this);

    }

    public void setTitle(String Name){
        TextView txtMenuName = (TextView)mView.findViewById(R.id.menu_name);
        txtMenuName.setText(Name);
    }
    public void setImage(Context cnt, String Image){
        ImageView imgView = (ImageView)mView.findViewById(R.id.menu_image);
        Picasso.get().load(Image).into(imgView);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v, getAdapterPosition(),false);
    }
}
