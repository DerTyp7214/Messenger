/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger.helpers;

import android.graphics.Bitmap;

public class Chat {

    private String time, lastMessage, contactName;
    private Bitmap profileImage;

    public Chat(String time, String lastMessage, String contactName, Bitmap profileImage){
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

    public Bitmap getProfileImage(){
        return this.profileImage;
    }
}
