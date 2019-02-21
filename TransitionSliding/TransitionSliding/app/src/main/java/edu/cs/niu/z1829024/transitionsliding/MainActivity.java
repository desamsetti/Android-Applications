package edu.cs.niu.z1829024.transitionsliding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button answerBtn = (Button)findViewById(R.id.answerButton);
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent answerIntent = new Intent(MainActivity.this, AnswerActivity.class);

                startActivity(answerIntent);
                overridePendingTransition(R.anim.answer_on,R.anim.question_off);

            }
        });

    }//end onCreate
}//end MainActivity
