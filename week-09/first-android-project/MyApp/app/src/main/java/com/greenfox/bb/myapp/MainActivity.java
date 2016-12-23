package com.greenfox.bb.myapp;

import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<Message> messages;
    MessageAdapter adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messages = new ArrayList<>();
        adapter = new MessageAdapter(this);
        listView = (ListView)findViewById(R.id.viewMessages);
        editText = (EditText)findViewById(R.id.editText);
        messages.add(new Message("a","11:00","cccc" ));
        messages.add(new Message("b","10:57","bbbb" ));
        messages.add(new Message("a","10:56","aaaa" ));
        adapter.addAll(messages);
        listView.setAdapter(adapter);
    }

    protected void sendMessage(View v){
        String text = editText.getText().toString();
        adapter.insert(new Message("a","hh:mm", text),0);
    }
}
