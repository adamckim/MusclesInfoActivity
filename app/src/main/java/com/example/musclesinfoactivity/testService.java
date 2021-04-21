package com.example.musclesinfoactivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface testService {

    @GET("test/random")
    Call<test> getrandomtest();



    //@GET("test")
    //Call<List<test>> getalltest();

    // @POST("test")

}
