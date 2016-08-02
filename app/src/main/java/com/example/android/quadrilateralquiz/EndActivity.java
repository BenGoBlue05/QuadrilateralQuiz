package com.example.android.quadrilateralquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {

    int[] mFinalScoreArray;
    int mFinalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        Button tryAgainButton = (Button) findViewById(R.id.try_again_button);
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startScreenIntent = new Intent(
                        getApplicationContext(), MainActivity.class);
                startActivity(startScreenIntent);
            }
        });

        mFinalScoreArray = getIntent().getIntArrayExtra("Finish");

        for (int i: mFinalScoreArray){
            mFinalScore += i;
        }

        Toast.makeText(this,"You got " + mFinalScore + " answers right",
                Toast.LENGTH_LONG ).show();

        TextView scoreTextView = (TextView) findViewById(R.id.final_score_text_view);
        String finalScoreString = "" + mFinalScore + "/5";
        scoreTextView.setText(finalScoreString);
    }
}
