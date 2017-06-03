package com.example.saurabh.moviediary.screen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.saurabh.moviediary.App;
import com.example.saurabh.moviediary.R;
import com.example.saurabh.moviediary.data.Post;
import com.example.saurabh.moviediary.util.RestApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity
{

    @Inject
    Retrofit retrofit;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getNetComponent().inject(this);

        //Create textview and findViewByID
        textView = (TextView) findViewById(R.id.text);
        //Create a retrofit call object
        Call<List<Post>> posts = retrofit.create(RestApi.class).getPosts();

        //Enque the call
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //Set the response to the textview
                textView.setText(response.body().get(0).getBody());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //Set the error to the textview
                textView.setText(t.toString());
            }
        });

    }
}
