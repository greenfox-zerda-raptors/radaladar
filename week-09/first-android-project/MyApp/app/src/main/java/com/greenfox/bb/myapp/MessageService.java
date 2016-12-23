package com.greenfox.bb.myapp;

/**
 * Created by BB on 2016-12-23.
 */

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface MessageService {
    @GET("/messages")
    Call<List<Message>> getMessageCall();
    @POST("/messages")
    Call<ResponseBody> postMessageCall(@Body MessageWrapper mw);
}
