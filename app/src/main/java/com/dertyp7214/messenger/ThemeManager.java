/*
 * Copyright (c) 2018.
 * Created by Josua Lengwenath
 */

package com.dertyp7214.messenger;

import android.content.Context;

public class ThemeManager {

    private Context context;
    private static ThemeManager themeManager;

    private ThemeManager(Context context){
        themeManager = this;
        this.context=context;
    }

    public static ThemeManager instance(Context context){
        if(themeManager==null)
            new ThemeManager(context);
        return themeManager;
    }

    public int getNavigationBarColor(){
        return context.getResources().getColor(R.color.colorPrimaryDark);
    }

}
