/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger.helpers;

import android.graphics.drawable.Drawable;

public class Chat {

    private String time, lastMessage, contactName;
    private Drawable profileImage;

    public Chat(String time, String lastMessage, String contactName, Drawable profileImage){
        this.time=time;
        this.lastMessage=lastMessage;
        this.contactName=contactName;
        this.profileImage=profileImage;
    }

    public String getTime(){
        return this.time;
    }

    public String getLastMessage(){
        return this.lastMessage;
    }

    public String getContactName(){
        return this.contactName;
    }

    public Drawable getProfileImage(){
        return this.profileImage;
    }
}
