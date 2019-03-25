package edu.niu.cs.z1829024.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*
Name : Harshith Desamsetti
Z ID : Z1829024
Graduate Project
This project contains of a Login activity, Register activity by using SQlite database. Then the screen displays 5 buttons
which are all the Graduate student project ideas, implemented as an activity each. The first one is a Math tutor activity which
displays additions, multiplications, divisions, subtractions. The second one is a Mad Libs activity which asks for parts of speech
on selecting a story and then displays the story by filling the parts of speech. The third one is a Grade calculator for both CSCI 240 and
CSCI 241 based on the score of quizzes, assignments and exams. The fourth one is a CSCI 240 quizzes activity which consists one quiz
and then displays the score and number of wrong answers. The fifth one is a ROCK PAPER SCISSORS activity which uses random number
generator to display either rock, paper or scissor and lets the user select one among them and displays the output.
 */
public class Screen extends AppCompatActivity {
    Button mathTutor, rockPaperScissors,gradeCalculator,csci240quizzes, madLibs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        mathTutor = (Button)findViewById(R.id.mathTutorButton);
        rockPaperScissors = (Button)findViewById(R.id.rockPaperScissorsButton);
        gradeCalculator = (Button)findViewById(R.id.gradeCalculator);
        csci240quizzes = (Button)findViewById(R.id.csci240quizzes);
        madLibs = (Button)findViewById(R.id.madLibs);

        mathTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Screen.this,MainScreen.class));
            }
        });


        rockPaperScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Screen.this,RockPaperScissors.class));
            }
        });

        gradeCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Screen.this,GradeCalculator.class));
            }
        });

        csci240quizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Screen.this,CSCI240quizzes.class));
            }
        });

        madLibs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Screen.this,MadLibs.class));
            }
        });

    }
}
