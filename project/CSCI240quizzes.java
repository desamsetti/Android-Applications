package edu.niu.cs.z1829024.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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
public class CSCI240quizzes extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;
    TextView score, question, wrongScore;
    private Questions mQuestions = new Questions();
    private String mAnswers;
    private int mScore = 0, wrongScore1 = 0;
    private int mQuestionsLength = mQuestions.Questions1.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csci240quizzes);

        r = new Random();

        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);

        score = (TextView)findViewById(R.id.score);
        question = (TextView)findViewById(R.id.question);
        wrongScore = (TextView)findViewById(R.id.wrongScore);

        score.setText("Score : "+mScore);
        wrongScore.setText("Wrong:" + wrongScore1);
        updateQuestion(r.nextInt(mQuestionsLength));


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1.getText() == mAnswers)
                {
                    mScore++;
                    score.setText("Score : "+mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                /*else
                {
                    gameOver();
                }*/
                else
                {
                    wrongScore1++;
                    wrongScore.setText("Wrong:" + wrongScore1);
                    Toast.makeText(CSCI240quizzes.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer2.getText() == mAnswers)
                {
                    mScore++;
                    score.setText("Score : "+mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else
                {
                    wrongScore1++;
                    wrongScore.setText("Wrong:" + wrongScore1);
                    Toast.makeText(CSCI240quizzes.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                }

            }
        });


        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText() == mAnswers)
                {
                    mScore++;
                    score.setText("Score : "+mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else
                {
                    wrongScore1++;
                    wrongScore.setText("Wrong:" + wrongScore1);
                    Toast.makeText(CSCI240quizzes.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                }

            }
        });


        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText() == mAnswers)
                {
                    mScore++;
                    score.setText("Score : "+mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else
                {
                    wrongScore1++;
                    wrongScore.setText("Wrong:" + wrongScore1);
                    Toast.makeText(CSCI240quizzes.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private void updateQuestion(int num)
    {
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswers = mQuestions.getCorrectAnswer(num);
    }

    public void gameOver()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CSCI240quizzes.this);
        alertDialogBuilder
                .setMessage("Game Over! Your Score is "+ mScore + " Points")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(),CSCI240quizzes.class));
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}