package com.iak.quizerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iak.quizerexample.question.Question1Activity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsernameMainActivity;
    private Button buttonSubmitMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsernameMainActivity = (EditText) findViewById(R.id.edit_text_username_activity_main);
        buttonSubmitMainActivity = (Button) findViewById(R.id.button_submit_activity_main);

        buttonSubmitMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsernameMainActivity.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(MainActivity.this, "Please fill your name!", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Intent intentQuestion1Activity = new Intent(MainActivity.this, Question1Activity.class);
                    intentQuestion1Activity.putExtra("username", username);
                    startActivity(intentQuestion1Activity);
                }
            }
        });
    }
}
