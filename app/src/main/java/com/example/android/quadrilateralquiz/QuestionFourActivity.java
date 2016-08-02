package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class QuestionFourActivity extends AppCompatActivity {

    private int[] mScoreArrayQuestionFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        mScoreArrayQuestionFour = getIntent().getIntArrayExtra("threeToFour");

        Button nextButton = (Button) findViewById(R.id.q4_next_button);
        Button lasttButton = (Button) findViewById(R.id.q4_last_button);

        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent nextIntent = new Intent(
                                getApplicationContext(), QuestionFiveActivity.class);
                        mScoreArrayQuestionFour[3] = scoreQuestionFour();
                        nextIntent.putExtra("fourToFive", mScoreArrayQuestionFour);
                        startActivity(nextIntent);
                    }
                }
        );

        lasttButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lastIntent = new Intent(
                                getApplicationContext(), QuestionThreeActivity.class
                        );
                        startActivity(lastIntent);
                    }
                });

    }

    private boolean isCorrect() {
        CheckBox complementaryCheckBox = (CheckBox) findViewById(R.id.complementary_check_box);
        CheckBox congruentCheckBox = (CheckBox) findViewById(R.id.congruent_check_box);
        CheckBox supplementaryCheckBox = (CheckBox) findViewById(R.id.supplementary_check_box);
        CheckBox noneCheckBox = (CheckBox) findViewById(R.id.none_check_box);

        return !complementaryCheckBox.isChecked() &&
                !congruentCheckBox.isChecked() &&
                supplementaryCheckBox.isChecked() &&
                !noneCheckBox.isChecked();
    }

    private int scoreQuestionFour() {
        if (isCorrect()) {
            return 1;
        }
        return 0;
    }
}
