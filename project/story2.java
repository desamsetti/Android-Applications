package edu.niu.cs.z1829024.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
public class story2 extends AppCompatActivity {

    EditText adjective1,adjective2,adjective3,adjective4,adjective5,adjective6,adjective7,noun1,noun2,noun3,noun4,adverb,verb1,verb2,verb3,verb4;
    Button submitButton;
    TextView story1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story2);
        adjective1 = (EditText)findViewById(R.id.adjective1);
        adjective2 = (EditText)findViewById(R.id.adjective2);
        adjective3 = (EditText)findViewById(R.id.adjective3);
        adjective4 = (EditText)findViewById(R.id.adjective4);
        adjective5 = (EditText)findViewById(R.id.adjective5);
        adjective6 = (EditText)findViewById(R.id.adjective6);
        adjective7 = (EditText)findViewById(R.id.adjective7);
        noun1 = (EditText)findViewById(R.id.noun1);
        noun2 = (EditText)findViewById(R.id.noun2);
        noun3 = (EditText)findViewById(R.id.noun3);
        noun4 = (EditText)findViewById(R.id.noun4);
        verb1 = (EditText)findViewById(R.id.verb1);
        verb2 = (EditText)findViewById(R.id.verb2);
        verb3 = (EditText)findViewById(R.id.verb3);
        verb4 = (EditText)findViewById(R.id.verb4);

        story1 = (TextView)findViewById(R.id.display);

        submitButton = (Button)findViewById(R.id.storyButton1);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adj1 = adjective1.getText().toString();
                String adj2 = adjective2.getText().toString();
                String adj3 = adjective3.getText().toString();
                String adj4 = adjective4.getText().toString();
                String adj5 = adjective5.getText().toString();
                String adj6 = adjective6.getText().toString();
                String adj7 = adjective7.getText().toString();
                String noun1Text = noun1.getText().toString();
                String noun2Text = noun2.getText().toString();
                String noun3Text = noun3.getText().toString();
                String noun4Text = noun4.getText().toString();
                String verb1Text = verb1.getText().toString();
                String verb2Text = verb2.getText().toString();
                String verb3Text = verb3.getText().toString();
                String verb4Text = verb4.getText().toString();

                story1.setText("I walk through the color jungle. I take out my\n" +
                        adj1 +" canteen. There's a\n" +
                        adj2 + " parrot with a "+adj3+"\n" +
                        noun1Text+ "in his mouth right in front of me in the\n" +
                        adj4+ " trees! I gaze at his "+adj5 + " "+noun2Text+
                        ". A sudden sound awakes me from my\n" +
                        "daydream! A panther \"s\" "+verb1Text+" in front of my\n" +
                        "head! I "+ verb2Text + " his "+adj6+"\n" +
                        "breath. I remember I have a packet of "+noun3Text+"\n" +
                        "that makes go into a deep slumber! I "+ verb3Text+ " it\n" +
                        "away in front of the "+noun4Text+". Yes he's eating\n" +
                        "it! I "+verb4Text+" away through the\n" +
                        adj7+" jungle. ");
            }
        });




    }
}
