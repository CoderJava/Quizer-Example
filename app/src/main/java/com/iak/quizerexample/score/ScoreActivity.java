package com.iak.quizerexample.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iak.quizerexample.R;
import com.iak.quizerexample.question.Question1Activity;

public class ScoreActivity extends AppCompatActivity {

    /* views */
    private TextView textViewValueScoreActivityScore;
    private TextView textViewValueUsernameActivityScore;
    private Button buttonTryAgainActivityScore;

    /* variable */
    private String username;
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        totalRightAnswer = 0;
        totalWrongAnswer = 0;
        initViews(getIntent().getExtras());
        initListener();
    }

    private void initViews(Bundle savedInstanceState) {
        textViewValueScoreActivityScore = (TextView) findViewById(R.id.text_view_value_score_activity_score);
        textViewValueUsernameActivityScore = (TextView) findViewById(R.id.text_view_value_username_activity_score);
        buttonTryAgainActivityScore = (Button) findViewById(R.id.button_try_again_activity_score);

        /* get value username and set it */
        username = savedInstanceState.getString("username");
        textViewValueUsernameActivityScore.setText(username);

        /* get total right answer and wrong answer */
        totalRightAnswer = savedInstanceState.getInt("totalRightAnswer");
        totalWrongAnswer = savedInstanceState.getInt("totalWrongAnswer");
        Log.d(TAG, "totalRightAnswer: " + totalRightAnswer);
        Log.d(TAG, "totalWrongAnswer: " + totalWrongAnswer);

        /* calculate score */
        double score = ((double) totalRightAnswer / (totalRightAnswer + totalWrongAnswer)) * 100;
        int iScore = (int) Math.round(score);
        String strScore = String.valueOf(iScore);
        textViewValueScoreActivityScore.setText(strScore);
    }

    private void initListener() {
        buttonTryAgainActivityScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuestion1Activity = new Intent(ScoreActivity.this, Question1Activity.class);
                intentQuestion1Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intentQuestion1Activity.putExtra("username", username);
                startActivity(intentQuestion1Activity);
            }
        });
    }
}
