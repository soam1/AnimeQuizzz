package com.akashsoam.quiztruefalseapp.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akashsoam.quiztruefalseapp.R;
import com.akashsoam.quiztruefalseapp.view.AnimeViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<AnimeViewHolder> {
    private Context mContext;
    private List<String> mAnimeNames;
    private LayoutInflater mLayoutInflater;

    public CardStackAdapter(Context context, List<String> animeNames) {
        this.mContext = context;
        this.mAnimeNames = animeNames;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.anime_view, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.getTxtAnimeQuestion().setText(mAnimeNames.get(position));
        holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"False is tapped", Toast.LENGTH_SHORT).show();
            }
        });
        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"True is tapped", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAnimeNames.size();
    }
}
