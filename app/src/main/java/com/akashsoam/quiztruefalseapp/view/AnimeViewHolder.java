package com.akashsoam.quiztruefalseapp.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akashsoam.quiztruefalseapp.R;

public class AnimeViewHolder extends RecyclerView.ViewHolder {

    private TextView txtAnimeQuestion;
    private ImageButton imgButtonTrue;
    private ImageButton imgButtonFalse;

    public AnimeViewHolder(@NonNull View itemView) {
        super(itemView);

        txtAnimeQuestion = itemView.findViewById(R.id.anime_question_text);
        imgButtonTrue = itemView.findViewById(R.id.trueButton);
        imgButtonFalse = itemView.findViewById(R.id.falseButton);
    }

    public TextView getTxtAnimeQuestion() {
        return txtAnimeQuestion;
    }

//    public void setTxtAnimeQuestion(TextView txtAnimeQuestion) {
//        this.txtAnimeQuestion = txtAnimeQuestion;
//    }

    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }

//    public void setImgButtonTrue(ImageButton imgButtonTrue) {
//        this.imgButtonTrue = imgButtonTrue;
//    }

    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }

//    public void setImgButtonFalse(ImageButton imgButtonFalse) {
//        this.imgButtonFalse = imgButtonFalse;
//    }


}
