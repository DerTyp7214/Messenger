/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger.helpers;

import android.graphics.Bitmap;

public class Status {

    private String name;
    private Bitmap image;
    private boolean seen;

    public Status(String name, Bitmap image, boolean seen){
        this.name=name;
        this.image=image;
        this.seen=seen;
    }

    public String getName(){
        return this.name;
    }

    public Bitmap getImage(){
        return this.image;
    }

    public boolean isSeen(){
        return this.seen;
    }

    public void setSeen(boolean seen){
        this.seen=seen;
    }

}
