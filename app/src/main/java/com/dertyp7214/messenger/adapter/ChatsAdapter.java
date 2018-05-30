/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dertyp7214.messenger.R;
import com.dertyp7214.messenger.helpers.Chat;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {

    private List<Chat> chatList;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ViewHolder viewHolder = holder;
        final Chat chat = chatList.get(position);
        viewHolder.time.setText(chat.getTime());
        viewHolder.lastMessage.setText(chat.getLastMessage());
        viewHolder.contact.setText(chat.getContactName());
        viewHolder.imageView.setImageDrawable(chat.getProfileImage());
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public ChatsAdapter(List<Chat> chats, Context context){
        this.chatList=chats;
        this.context=context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView imageView;
        public TextView contact, lastMessage, time;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profileImage);
            contact = itemView.findViewById(R.id.txtContact);
            lastMessage = itemView.findViewById(R.id.txtLastMessage);
            time = itemView.findViewById(R.id.txtTime);
        }
    }

}
