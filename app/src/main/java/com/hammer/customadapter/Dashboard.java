package com.hammer.customadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by Harshal on 11/14/2017.
 */

public class Dashboard extends ListActivity {

    private ArrayList<Registrationmodel> a=new ArrayList<Registrationmodel>();
    private Runnable wv;
    private Cadapter ca;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.dashboard);
        ca = new Cadapter(Dashboard.this, R.layout.cadapter,a);
        setListAdapter(ca);
        wv = new Runnable(){
            public void run(){
                handler.sendEmptyMessage(0);
            }
        };



    }

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            // create some objects
            // here is where you could also request data from a server
            // and then create objects from that data.
            a.add(new Registrationmodel("MyItemName", "This is item #1", 0));
            a.add(new Registrationmodel("MyItemName #2", "This is item #2", 0));

            ca = new Cadapter(Dashboard.this, R.layout.cadapter, a);

            // display the list.
            setListAdapter(ca);
        }
    };
}
