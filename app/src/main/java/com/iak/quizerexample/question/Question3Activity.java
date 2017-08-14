package com.iak.quizerexample.question;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iak.quizerexample.R;
import com.iak.quizerexample.score.ScoreActivity;

public class Question3Activity extends AppCompatActivity {

    /* views */
    private TextView textViewValueUsernameQuestion3Activity;
    private TextView textViewValueQuestion3Activity;
    private RadioGroup radioGroupAnswerQuestion3Activity;
    private RadioButton radioButtonAnswer1Question3Activity;
    private RadioButton radioButtonAnswer2Question3Activity;
    private RadioButton radioButtonAnswer3Question3Activity;
    private RadioButton radioButtonAnswer4Question3Activity;
    private Button buttonSubmitAnswerQuestion3Activity;

    /* variable */
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private String username;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        context = this;
        totalRightAnswer = 0;
        totalWrongAnswer = 0;
        initViews(getIntent().getExtras());
        initListener();
    }

    private void initViews(Bundle savedInstanceState) {
        /* initialize views xml */
        textViewValueUsernameQuestion3Activity = (TextView) findViewById(R.id.text_view_value_username_activity_question3);
        textViewValueQuestion3Activity = (TextView) findViewById(R.id.text_view_value_question_activity_question3);
        radioGroupAnswerQuestion3Activity = (RadioGroup) findViewById(R.id.radio_group_answer_question_activity_question3);
        radioButtonAnswer1Question3Activity = (RadioButton) findViewById(R.id.radio_button_answer1_activity_question3);
        radioButtonAnswer2Question3Activity = (RadioButton) findViewById(R.id.radio_button_answer2_activity_question3);
        radioButtonAnswer3Question3Activity = (RadioButton) findViewById(R.id.radio_button_answer3_activity_question3);
        radioButtonAnswer4Question3Activity = (RadioButton) findViewById(R.id.radio_button_answer4_activity_question3);
        buttonSubmitAnswerQuestion3Activity = (Button) findViewById(R.id.button_submit_activity_question3);

        /* get value username from intent and set it */
        username = savedInstanceState.getString("username");
        textViewValueUsernameQuestion3Activity.setText(username);

        /* get total right answer and wrong answer */
        totalRightAnswer = savedInstanceState.getInt("totalRightAnswer");
        totalWrongAnswer = savedInstanceState.getInt("totalWrongAnswer");

        /* set text for question */
        String question = "Hal-hal apa sajakah yang perlu di install untuk menggunakan aplikasi Android Studio, kecuali?";
        textViewValueQuestion3Activity.setText(question);

        /* set text for answer */
        radioButtonAnswer1Question3Activity.setText("JDK");
        radioButtonAnswer2Question3Activity.setText("SDK");
        radioButtonAnswer3Question3Activity.setText("Android Studio");
        radioButtonAnswer4Question3Activity.setText("Notepad++");
    }

    private void initListener() {
        buttonSubmitAnswerQuestion3Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo: do something when button submit clicked
                boolean isSelectedOne = false;
                switch (radioGroupAnswerQuestion3Activity.getCheckedRadioButtonId()) {
                    case R.id.radio_button_answer1_activity_question3:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                    case R.id.radio_button_answer2_activity_question3:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                    case R.id.radio_button_answer3_activity_question3:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                    case R.id.radio_button_answer4_activity_question3:
                        // todo: do something for right answer
                        isSelectedOne = true;
                        totalRightAnswer += 1;
                        break;
                }

                if (isSelectedOne) {
                    /* valid data and show score */
                    Intent intentScoreActivity = new Intent(context, ScoreActivity.class);
                    intentScoreActivity.putExtra("username", username);
                    intentScoreActivity.putExtra("totalRightAnswer", totalRightAnswer);
                    intentScoreActivity.putExtra("totalWrongAnswer", totalWrongAnswer);
                    startActivity(intentScoreActivity);
                } else {
                    /* invalid data and show message to user */
                    Toast.makeText(context, R.string.invalid_data_message, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
