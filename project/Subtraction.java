package edu.niu.cs.z1829024.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;
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
public class Subtraction extends AppCompatActivity {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEditText;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArrayList;
    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionCountLabel = (TextView) findViewById(R.id.noQuestion);
        questionLabel = (TextView) findViewById(R.id.question);
        scoreLabel = (TextView) findViewById(R.id.score);

        answerEditText = (EditText) findViewById(R.id.answer);
        answerEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        submitButton = (Button) findViewById(R.id.submit);

        progressBar = (ProgressBar) findViewById(R.id.progress);

        questionModelArrayList = new ArrayList<>();
        setupQuestion();
        setData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    public void setupQuestion() {

        Random rand = new Random();
        for(int i=0;i<10;i++) {
            int n1 = rand.nextInt(50) + 1;
            int n2 = rand.nextInt(50) + 1;
            int n3 = n1 - n2;
            String x = String.valueOf(n3);

            questionModelArrayList.add(new QuestionModel("What is " + n1 + "-" + n2 + "?", x));
        }

        /*questionModelArrayList.add(new QuestionModel("What is 4+5?", "9"));
        questionModelArrayList.add(new QuestionModel("What is 12+14?", "26"));
        questionModelArrayList.add(new QuestionModel("What is 15+16?", "31"));
        questionModelArrayList.add(new QuestionModel("What is 20+30?", "50"));*/

    }


    public void setData() {
        if (questionModelArrayList.size() > currentPosition) {
            questionLabel.setText(questionModelArrayList.get(currentPosition).getQuestionString());
            questionCountLabel.setText("Question No : " + (currentPosition + 1));
            scoreLabel.setText("Score : " + numberOfCorrectAnswer + "/" + questionModelArrayList.size());
        } else {
            new SweetAlertDialog(Subtraction.this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You have successfully completed the quiz")
                    .setContentText("Your Score is : "+numberOfCorrectAnswer+"/"+questionModelArrayList.size())
                    .setConfirmText("Restart")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            currentPosition = 0;
                            numberOfCorrectAnswer = 0;
                            progressBar.setProgress(0);
                            setData();
                        }
                    })
                    .setCancelText("Close")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            finish();
                        }
                    }).show();
        }
    }

    public void checkAnswer() {
        String answerString = answerEditText.getText().toString().trim();

        if (answerString.equalsIgnoreCase(questionModelArrayList.get(currentPosition).getAnswer())) {
            numberOfCorrectAnswer++;


            new SweetAlertDialog(Subtraction.this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good Job")
                    .setContentText("Right Answer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;
                            setData();
                            answerEditText.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    }).show();


        } else {

            new SweetAlertDialog(Subtraction.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    .setContentText("The Right Answer is : "+questionModelArrayList.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                            currentPosition++;
                            setData();
                            answerEditText.setText("");
                        }
                    }).show();





        }
        int x = ((currentPosition + 1) * 100) / questionModelArrayList.size();
        progressBar.setProgress(x);



    }
}