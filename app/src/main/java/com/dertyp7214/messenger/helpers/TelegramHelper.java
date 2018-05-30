package com.dertyp7214.messenger.helpers;

import android.content.Context;

import org.telegram.api.contact.TLContact;
import org.telegram.api.dialog.TLDialog;
import org.telegram.tl.TLVector;

public class TelegramHelper {

    private static TelegramHelper instance;

    private final Context context;

    private TelegramHelper(Context context){
        this.context=context;
        instance=this;
    }

    public static TelegramHelper getInstance(Context context){
        if(instance==null)
            new TelegramHelper(context);
        return instance;
    }

    public static TLVector<TLContact> getContacts(){
        return new org.telegram.api.contacts.TLContacts().getContacts();
    }

    public static TLVector<TLDialog> getChats(){
        return new org.telegram.api.messages.TLMessagesPeerDialogs().getDialogs();
    }

}
