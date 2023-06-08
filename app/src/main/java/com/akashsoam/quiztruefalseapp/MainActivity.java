package com.akashsoam.quiztruefalseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.akashsoam.quiztruefalseapp.controller.CardStackAdapter;
import com.akashsoam.quiztruefalseapp.model.QuizManager;
import com.akashsoam.quiztruefalseapp.model.QuizQuestion;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    adding cardstack view from git repo https://github.com/yuyakaido/CardStackView

    private QuizManager mQuizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizManager = new QuizManager(getApplicationContext());

        mQuizManager.getQuizQuestions(this);


//        ArrayList<String> testAnimes = new ArrayList<>();
//        testAnimes.add("Question no1");
//        testAnimes.add("Question no2");
//        testAnimes.add("Question no3");
//        testAnimes.add("Question no4");








    }
}