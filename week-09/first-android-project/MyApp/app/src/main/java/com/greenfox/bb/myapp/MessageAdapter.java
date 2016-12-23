package com.greenfox.bb.myapp;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by BB on 2016-12-23.
 */

public class MessageAdapter extends ArrayAdapter<Message> {

    public MessageAdapter(Context context){
        super(context, R.layout.message);
    }
}
