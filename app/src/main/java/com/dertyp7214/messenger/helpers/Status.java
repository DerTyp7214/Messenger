/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger.helpers;

import android.graphics.drawable.Drawable;

public class Status {

    private String name;
    private Drawable image;
    private boolean seen;

    public Status(String name, Drawable image, boolean seen){
        this.name=name;
        this.image=image;
        this.seen=seen;
    }

    public String getName(){
        return this.name;
    }

    public Drawable getImage(){
        return this.image;
    }

    public boolean isSeen(){
        return this.seen;
    }

    public void setSeen(boolean seen){
        this.seen=seen;
    }

}
