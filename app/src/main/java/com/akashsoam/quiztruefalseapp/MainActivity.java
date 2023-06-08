package com.akashsoam.quiztruefalseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.akashsoam.quiztruefalseapp.controller.CardStackAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    adding cardstack view from git repo https://github.com/yuyakaido/CardStackView

    private RequestQueue mRequestQueue;
    private String url;
    private CardStackView mCardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardStackView = findViewById(R.id.myCardStackView);
        mCardStackView.setLayoutManager(new CardStackLayoutManager(this));

        ArrayList<String> testAnimes = new ArrayList<>();
        testAnimes.add("Question no1");
        testAnimes.add("Question no2");
        testAnimes.add("Question no3");
        testAnimes.add("Question no4");


        mCardStackView.setAdapter(new CardStackAdapter(getApplicationContext(), testAnimes));

        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        url = "https://opentdb.com/api.php?amount=20&category=31&type=boolean";
        JsonObjectRequest animeJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("TAG", response + "");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERRORTAG", error.getMessage());
            }
        });
        mRequestQueue.add(animeJsonObjectRequest);
    }
}