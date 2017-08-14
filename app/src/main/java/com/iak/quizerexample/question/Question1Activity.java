package com.iak.quizerexample.question;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iak.quizerexample.R;

public class Question1Activity extends AppCompatActivity {

    /* views */
    private TextView textViewValueUsernameQuestion1Activity;
    private TextView textViewValueQuestion1Activity;
    private RadioGroup radioGroupAnswerQuestion1Activity;
    private RadioButton radioButtonAnswer1Question1Activity;
    private RadioButton radioButtonAnswer2Question1Activity;
    private RadioButton radioButtonAnswer3Question1Activity;
    private RadioButton radioButtonAnswer4Question1Activity;
    private Button buttonSubmitAnswerQuestion1Activity;

    /* variable */
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        totalRightAnswer = 0;
        totalWrongAnswer = 0;
        initViews(getIntent().getExtras());
        initListener();
    }

    private void initListener() {
        buttonSubmitAnswerQuestion1Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo: do something when button submit clicked
                boolean isSelectedOne = false;
                switch (radioGroupAnswerQuestion1Activity.getCheckedRadioButtonId()) {
                    case R.id.radio_button_answer_1_activity_question1:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer = totalWrongAnswer + 1;
                        break;
                    case R.id.radio_button_answer_2_activity_question1:
                        // todo: do something for right answer
                        isSelectedOne = true;
                        totalRightAnswer += 1;
                        break;
                    case R.id.radio_button_answer_3_activity_question1:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer++;
                        break;
                    case R.id.radio_button_answer_4_activity_question1:
                        // todo: do something for wrong answer
                        isSelectedOne = true;
                        totalWrongAnswer += 1;
                        break;
                }

                if (isSelectedOne) {
                    /* valid data and next question */
                    Intent intentQuestion2Activity = new Intent(Question1Activity.this, Question2Activity.class);
                    intentQuestion2Activity.putExtra("username", username);
                    intentQuestion2Activity.putExtra("totalRightAnswer", totalRightAnswer);
                    intentQuestion2Activity.putExtra("totalWrongAnswer", totalWrongAnswer);
                    startActivity(intentQuestion2Activity);
                } else {
                    /* invalid data and show message to user */
                    Toast.makeText(Question1Activity.this, R.string.invalid_data_message, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void initViews(Bundle savedInstanceState) {
        /* initialize views xml */
        textViewValueUsernameQuestion1Activity = (TextView) findViewById(R.id.text_view_value_username_activity_question1);
        textViewValueQuestion1Activity = (TextView) findViewById(R.id.text_view_value_question_activity_question1);
        radioGroupAnswerQuestion1Activity = (RadioGroup) findViewById(R.id.radio_group_answer_question_activity_question1);
        radioButtonAnswer1Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_1_activity_question1);
        radioButtonAnswer2Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_2_activity_question1);
        radioButtonAnswer3Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_3_activity_question1);
        radioButtonAnswer4Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_4_activity_question1);
        buttonSubmitAnswerQuestion1Activity = (Button) findViewById(R.id.button_submit_activity_question1);

        /* get value username from intent and set it */
        username = savedInstanceState.getString("username");
        textViewValueUsernameQuestion1Activity.setText(username);

        /* set text for question */
        String question = "Sebutkan kepanjangan dari Android N?";
        textViewValueQuestion1Activity.setText(question);

        /* set text for answer */
        radioButtonAnswer1Question1Activity.setText("Nano");
        radioButtonAnswer2Question1Activity.setText("Nougat");
        radioButtonAnswer3Question1Activity.setText("Nacho");
        radioButtonAnswer4Question1Activity.setText("Neo");

    }
}
