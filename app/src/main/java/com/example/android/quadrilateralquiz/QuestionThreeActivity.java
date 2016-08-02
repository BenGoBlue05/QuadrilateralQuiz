package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class QuestionThreeActivity extends AppCompatActivity {

    private int[] mScoreArrayQuestionThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        mScoreArrayQuestionThree = getIntent().getIntArrayExtra("twoToThree");

        Button nextButton = (Button) findViewById(R.id.q3_next_button);
        Button lastButton = (Button) findViewById(R.id.q3_last_button);

        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent nextIntent = new Intent(
                                getApplicationContext(), QuestionFourActivity.class
                        );
                        mScoreArrayQuestionThree[2] = scoreQuestion3();
                        nextIntent.putExtra("threeToFour", mScoreArrayQuestionThree);
                        startActivity(nextIntent);
                    }
                }
        );

        lastButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lastIntent = new Intent(
                                getApplicationContext(), QuestionTwoActivity.class);
                        startActivity(lastIntent);
                    }
                }
        );
    }

    private boolean isCorrect() {
        EditText userInputBox = (EditText) findViewById(R.id.q3_user_input);
        String userInputString = userInputBox.getText().toString();
        return userInputString.equals("360");
    }

    private int scoreQuestion3() {
        if (isCorrect()) {
            return 1;
        }
        return 0;
    }


}