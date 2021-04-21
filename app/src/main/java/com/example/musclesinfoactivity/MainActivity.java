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

      //String data = "{\"count\":15,\"next\":null,\"previous\":null,\"results\":[{\"id\":2,\"name\":\"Anterior deltoid\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-2.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-2.svg\"},{\"id\":1,\"name\":\"Biceps brachii\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-1.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-1.svg\"},{\"id\":11,\"name\":\"Biceps femoris\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-11.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-11.svg\"},{\"id\":13,\"name\":\"Brachialis\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-13.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-13.svg\"},{\"id\":7,\"name\":\"Gastrocnemius\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-7.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-7.svg\"},{\"id\":8,\"name\":\"Gluteus maximus\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-8.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-8.svg\"},{\"id\":12,\"name\":\"Latissimus dorsi\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-12.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-12.svg\"},{\"id\":14,\"name\":\"Obliquus externus abdominis\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-14.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-14.svg\"},{\"id\":4,\"name\":\"Pectoralis major\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-4.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-4.svg\"},{\"id\":10,\"name\":\"Quadriceps femoris\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-10.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-10.svg\"},{\"id\":6,\"name\":\"Rectus abdominis\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-6.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-6.svg\"},{\"id\":3,\"name\":\"Serratus anterior\",\"is_front\":true,\"image_url_main\":\"/static/images/muscles/main/muscle-3.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-3.svg\"},{\"id\":15,\"name\":\"Soleus\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-15.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-15.svg\"},{\"id\":9,\"name\":\"Trapezius\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-9.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-9.svg\"},{\"id\":5,\"name\":\"Triceps brachii\",\"is_front\":false,\"image_url_main\":\"/static/images/muscles/main/muscle-5.svg\",\"image_url_secondary\":\"/static/images/muscles/secondary/muscle-5.svg\"}]}";
        //Gson gson = new Gson();
        //test muscle = gson.fromJson(data, test.class);
        //Log.d(TAG, String.valueOf(muscle.getResults()));


    }
}