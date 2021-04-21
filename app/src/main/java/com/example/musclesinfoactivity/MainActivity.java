package com.example.musclesinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mtv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtv1 = findViewById(R.id.tv1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://wger.de/api/v2/muscle/?format=json")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        testService service = retrofit.create(testService.class);

        Call<test> testCall = service.getrandomtest();

        testCall.enqueue(new Callback<test>() {
            @Override
            public void onResponse(Call<test> call, Response<test> response) {
                test Test = response.body();
                List<Result> resultsList =response.body().getResults();
                System.out.println("api working");
              //  mtv1.setText(resultsList);



            }

            @Override
            public void onFailure(Call<test> call, Throwable t) {


            }


        });


    }
}