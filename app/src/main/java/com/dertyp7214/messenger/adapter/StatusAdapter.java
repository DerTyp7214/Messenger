/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dertyp7214.messenger.R;
import com.dertyp7214.messenger.ThemeManager;
import com.dertyp7214.messenger.helpers.Status;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {

    private List<Status> itemList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView image;

        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.profileImage);
        }
    }


    public StatusAdapter(List<Status> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.status, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Status listItem = itemList.get(position);
        final ThemeManager themeManager = ThemeManager.instance(context);

        holder.image.setImageBitmap(listItem.getImage());
        holder.image.setBorderColor(listItem.isSeen() ? Color.LTGRAY : context.getResources().getColor(R.color.colorAccent));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}