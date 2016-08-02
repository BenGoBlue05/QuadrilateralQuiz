package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class QuestionTwoActivity extends AppCompatActivity {

    private int[] mScoreArrayQuestionTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        mScoreArrayQuestionTwo = getIntent().getIntArrayExtra("oneToTwo");

        Button nextButton = (Button) findViewById(R.id.q2_next_button);
        Button lastButton = (Button) findViewById(R.id.q2_last_button);

        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent nextIntent = new Intent(
                                getApplicationContext(), QuestionThreeActivity.class
                        );
                        mScoreArrayQuestionTwo[1] = scoreQuestion2();
                        nextIntent.putExtra("twoToThree", mScoreArrayQuestionTwo);
                        startActivity(nextIntent);
                    }
                }
        );

        lastButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lastIntent = new Intent(
                                getApplicationContext(),QuestionOneActivity.class);
                        startActivity(lastIntent);
                    }
                }
        );
    }

    private boolean isCorrect(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q2_radio_group);
        return radioGroup.getCheckedRadioButtonId() == R.id.q2_false;
    }

    private int scoreQuestion2(){
        if (isCorrect()){
            return 1;
        }
        return 0;
    }


}