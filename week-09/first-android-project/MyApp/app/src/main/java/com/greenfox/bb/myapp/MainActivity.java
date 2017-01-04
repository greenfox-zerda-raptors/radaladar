package com.greenfox.bb.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Message> messages;
    MessageAdapter adapter;
    ListView listView;
    EditText editText;
    MessageService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messages = new ArrayList<>();
        adapter = new MessageAdapter(this);
        listView = (ListView)findViewById(R.id.viewMessages);
        editText = (EditText)findViewById(R.id.editText);
        listView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zerda-raptor.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MessageService.class);
        refreshMessages();
    }

    protected void sendMessage(View v){
        String text = editText.getText().toString();
        service.postMessageCall(new MessageWrapper(new Message("BB",text))).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
        refreshMessages();
    }

    protected void refresh(View v){
        refreshMessages();
    }

    protected void refreshMessages() {
        service.getMessageCall().enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                adapter.clear();
                adapter.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
