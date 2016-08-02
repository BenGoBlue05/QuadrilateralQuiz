package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumber = 1;
                setQuestionScreen(questionNumber);
            }
        });
    }
    public void setQuestionScreen(int question){
        Intent intent;
        switch (question){
            case 1:
                intent = new Intent(getApplicationContext(),QuestionOneActivity.class);
                break;
            case 2:
                intent = new Intent(getApplicationContext(),QuestionTwoActivity.class);
                break;
            case 3:
                intent = new Intent(getApplicationContext(),QuestionThreeActivity.class);
                break;
            case 4:
                intent = new Intent(getApplicationContext(),QuestionFourActivity.class);
                break;
            case 5:
                intent = new Intent(getApplicationContext(),QuestionFiveActivity.class);
                break;
            case 6:
                intent = new Intent(getApplicationContext(),EndActivity.class);
                break;
            default:
                intent = new Intent(getApplicationContext(),MainActivity.class);
        }
        startActivity(intent);
    }
}
