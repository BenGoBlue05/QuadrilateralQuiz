package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class QuestionFiveActivity extends AppCompatActivity {
    private int[] mScoreArrayQuestionFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        mScoreArrayQuestionFive = getIntent().getIntArrayExtra("fourToFive");

        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button lastButton = (Button) findViewById(R.id.q5_last_button);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent endActivityIntent = new Intent(
                                getApplicationContext(), EndActivity.class
                        );
                        mScoreArrayQuestionFive[4] = scoreQuestion5();
                        endActivityIntent.putExtra("Finish", mScoreArrayQuestionFive);
                        startActivity(endActivityIntent);
                    }
                }
        );

        lastButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lastIntent = new Intent(
                                getApplicationContext(),QuestionFourActivity.class);
                        startActivity(lastIntent);

                    }
                }
        );
    }

    private boolean isCorrect(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q5_radio_group);
        return radioGroup.getCheckedRadioButtonId() == R.id.q5_true;
    }

    private int scoreQuestion5(){
        if (isCorrect()){
            return 1;
        }
        return 0;
    }


}