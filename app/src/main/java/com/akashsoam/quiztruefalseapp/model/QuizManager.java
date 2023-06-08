package com.akashsoam.quiztruefalseapp.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.akashsoam.quiztruefalseapp.MyApplication;
import com.akashsoam.quiztruefalseapp.R;
import com.akashsoam.quiztruefalseapp.VolleySingleton;
import com.akashsoam.quiztruefalseapp.controller.CardStackAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private RequestQueue mRequestQueue;
    private String url;
    Context mContext;

    public QuizManager(Context context) {
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        mContext = context;
        url = "https://opentdb.com/api.php?amount=20&category=31&type=boolean";


    }

    public void getQuizQuestions(Activity activity) {
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        JsonObjectRequest animeJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ANIMES", response + "");
                //see the json api file on browser, we need to access the array first
                try {
                    JSONArray results = response.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject questionJsonObject = results.getJSONObject(i);
                        String questionText = questionJsonObject.getString("question");
                        boolean answer = questionJsonObject.getBoolean("correct_answer");
                        QuizQuestion myQuestion = new QuizQuestion(questionText, answer);
                        quizQuestions.add(myQuestion);
                    }

                    CardStackView mCardStackView = activity.findViewById(R.id.myCardStackView);
                    mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    mCardStackView.setAdapter(new CardStackAdapter(mContext, quizQuestions));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERRORTAG", error.getMessage());
                Toast.makeText(MyApplication.getAppContext(), "error occurred receiving questions from the server", Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(animeJsonObjectRequest);
//        return quizQuestions;
    }
}
