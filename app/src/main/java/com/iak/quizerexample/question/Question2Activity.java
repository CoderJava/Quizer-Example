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

public class Question2Activity extends AppCompatActivity {

    /* views */
    private TextView textViewValueUsernameQuestion2Activity;
    private TextView textViewValueQuestion2Activity;
    private RadioGroup radioGroupAnswerQuestion2Activity;
    private RadioButton radioButtonAnswer1Question2Activity;
    private RadioButton radioButtonAnswer2Question2Activity;
    private RadioButton radioButtonAnswer3Question2Activity;
    private RadioButton radioButtonAnswer4Question2Activity;
    private Button buttonSubmitAnswerQuestion2Activity;

    /* variable */
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private String username;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        context = this;
        totalRightAnswer = 0;
        totalWrongAnswer = 0;
        initViews(getIntent().getExtras());
        initListener();
    }

    private void initViews(Bundle savedInstanceState) {
        /* initialize views xml */
        textViewValueUsernameQuestion2Activity = (TextView) findViewById(R.id.text_view_value_username_activity_question2);
        textViewValueQuestion2Activity = (TextView) findViewById(R.id.text_view_value_question_activity_question2);
        radioGroupAnswerQuestion2Activity = (RadioGroup) findViewById(R.id.radio_group_answer_question_activity_question2);
        radioButtonAnswer1Question2Activity = (RadioButton) findViewById(R.id.radio_button_answer_1_activity_question2);
        radioButtonAnswer2Question2Activity = (RadioButton) findViewById(R.id.radio_button_answer_2_activity_question2);
        radioButtonAnswer3Question2Activity = (RadioButton) findViewById(R.id.radio_button_answer_3_activity_question2);
        radioButtonAnswer4Question2Activity = (RadioButton) findViewById(R.id.radio_button_answer_4_activity_question2);
        buttonSubmitAnswerQuestion2Activity = (Button) findViewById(R.id.button_submit_activity_question2);

        /* get value username from intent and set it */
        username = savedInstanceState.getString("username");
        textViewValueUsernameQuestion2Activity.setText(username);

        /* get total right answer and wrong answer */
        totalRightAnswer = savedInstanceState.getInt("totalRightAnswer");
        totalWrongAnswer = savedInstanceState.getInt("totalWrongAnswer");

        /* set text for question */
        String question = "Bahasa pemrograman apakah yang dipakai untuk membangun aplikasi Android?";
        textViewValueQuestion2Activity.setText(question);

        /* set text for answer */
        radioButtonAnswer1Question2Activity.setText("Ruby");
        radioButtonAnswer1Question2Activity.setText("Python");
        radioButtonAnswer3Question2Activity.setText("ASP.Net");
        radioButtonAnswer4Question2Activity.setText("Java");
    }

    private void initListener() {
        buttonSubmitAnswerQuestion2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo: do something when button submit clicked
                boolean isSelectedOne = false;
                switch (radioGroupAnswerQuestion2Activity.getCheckedRadioButtonId()) {
                    case R.id.radio_button_answer_1_activity_question2:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                    case R.id.radio_button_answer_2_activity_question2:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                    case R.id.radio_button_answer_3_activity_question2:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                    case R.id.radio_button_answer_4_activity_question2:
                        // todo: do something for right answer
                        isSelectedOne = true;
                        totalRightAnswer += 1;
                        break;
                }

                if (isSelectedOne) {
                    /* valid data and next question */
                    Intent intentQuestion3Activity = new Intent(context, Question3Activity.class);
                    intentQuestion3Activity.putExtra("username", username);
                    intentQuestion3Activity.putExtra("totalRightAnswer", totalRightAnswer);
                    intentQuestion3Activity.putExtra("totalWrongAnswer", totalWrongAnswer);
                    startActivity(intentQuestion3Activity);
                } else {
                    /* invalid data and show message to user */
                    Toast.makeText(context, R.string.invalid_data_message, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
