package com.dertyp7214.messenger;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.dertyp7214.messenger.adapter.ChatsAdapter;
import com.dertyp7214.messenger.adapter.StatusAdapter;
import com.dertyp7214.messenger.helpers.Chat;
import com.dertyp7214.messenger.helpers.Status;
import com.dertyp7214.messenger.helpers.TelegramHelper;

import org.telegram.api.chat.TLAbsChat;
import org.telegram.api.chat.TLChat;
import org.telegram.api.dialog.TLDialog;
import org.telegram.tl.TLVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView statusRecyclerView, contactsRecyclerView;
    private Toolbar toolbar;
    private StatusAdapter statusAdapter;
    private ChatsAdapter chatAdapter;
    private List<Status> statusList = new ArrayList<>();
    private List<Chat> chatList = new ArrayList<>();
    private TelegramHelper telegramHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);

        setSupportActionBar(toolbar);

        statusAdapter = new StatusAdapter(statusList, this);

        statusRecyclerView = findViewById(R.id.rcStatus);
        statusRecyclerView.setHasFixedSize(true);
        statusRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        statusRecyclerView.setItemAnimator(new DefaultItemAnimator());
        statusRecyclerView.setAdapter(statusAdapter);

        chatAdapter = new ChatsAdapter(chatList, this);

        contactsRecyclerView = findViewById(R.id.rcChats);
        contactsRecyclerView.setHasFixedSize(true);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        contactsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        contactsRecyclerView.setAdapter(chatAdapter);

        telegramHelper = TelegramHelper.getInstance(this);

        setColors();

        new Thread(() -> {
            getStatusList();
            getChatList();
        }).start();

    }

    private void setColors(){
        int color = ThemeManager.instance(this).getNavigationBarColor();
        ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), getWindow().getNavigationBarColor(), color);
        animator.setDuration(250);
        animator.addUpdateListener(animation -> {
            getWindow().setNavigationBarColor((int) animation.getAnimatedValue());
            if(!Utils.isColorDark((int) animation.getAnimatedValue()) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                toolbar.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
            }
        });
        animator.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void getStatusList(){
        statusList.add(new Status("Peter", Utils.getImageFromUrl(this,"https://jboyecom.files.wordpress.com/2017/04/profile-icon-9.png?w=512"), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), true));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), true));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), true));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        statusList.add(new Status("Peter", Utils.createImage(this,80, 80, Color.GREEN), false));
        runOnUiThread(() -> statusAdapter.notifyDataSetChanged());
    }

    private void getChatList(){
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        chatList.add(new Chat("00:00", "Hallo", "Peter", Utils.createImage(this,80, 80, Color.GREEN)));
        runOnUiThread(() -> chatAdapter.notifyDataSetChanged());
    }
}
