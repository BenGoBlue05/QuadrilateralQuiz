package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class QuestionOneActivity extends AppCompatActivity {

    private int[] mScoreArrayQuestionOne = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        Button nextButton = (Button) findViewById(R.id.q1_next_button);

        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent nextIntent = new Intent(
                                getApplicationContext(), QuestionTwoActivity.class);
                        mScoreArrayQuestionOne[0] = scoreQuestionOne();
                        nextIntent.putExtra("oneToTwo", mScoreArrayQuestionOne);
                        startActivity(nextIntent);
                    }
                }
        );

    }

    private boolean isCorrect() {
        CheckBox parallelogramCheckBox = (CheckBox) findViewById(R.id.parallelogram_check_box);
        CheckBox polygonCheckBox = (CheckBox) findViewById(R.id.polygon_check_box);
        CheckBox rectangleCheckBox = (CheckBox) findViewById(R.id.rectangle_check_box);
        CheckBox rhombusCheckBox = (CheckBox) findViewById(R.id.rhombus_check_box);

        return parallelogramCheckBox.isChecked() &&
                polygonCheckBox.isChecked() &&
                rectangleCheckBox.isChecked() &&
                rhombusCheckBox.isChecked();
    }

    private int scoreQuestionOne() {
        if (isCorrect()) {
            return 1;
        }
        return 0;
    }
}