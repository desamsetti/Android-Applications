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

public class story1 extends AppCompatActivity {

    EditText adjective1,adjective2,adjective3,noun1,noun2,noun3,adverb,verb;
    Button submitButton;
    TextView story1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
        adjective1 = (EditText) findViewById(R.id.adjective1);
        adjective2 = (EditText)findViewById(R.id.adjective2);
        adjective3 = (EditText)findViewById(R.id.adjective3);
        noun1 = (EditText) findViewById(R.id.noun1);
        noun2 = (EditText) findViewById(R.id.noun2);
        noun3 = (EditText) findViewById(R.id.noun3);
        adverb = (EditText)findViewById(R.id.adverb1);
        verb = (EditText)findViewById(R.id.verb1);

        story1 = (TextView)findViewById(R.id.display);

        submitButton = (Button)findViewById(R.id.storyButton1);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adj1 = adjective1.getText().toString();
                String adj2 = adjective2.getText().toString();
                String adj3 = adjective3.getText().toString();
                String noun1Text = noun1.getText().toString();
                String noun2Text = noun2.getText().toString();
                String noun3Text = noun3.getText().toString();
                String verbText = verb.getText().toString();
                String adverbText = adverb.getText().toString();

                story1.setText("Today I went to the zoo. I saw a "+adj1+ "\n" +
                        noun1Text+" jumping up and down in its tree. He\n" +
                        verbText+" "+adverbText+ " through\n" +
                        "the large tunnel that led to its "+adj2+"\n" +
                        noun2Text +". I got some peanuts and passed them\n" +
                        "through the cage to a gigantic gray "+noun3Text+"\n" +
                        "towering above my head. Feeding that animal made me\n" +
                        "hungry. I went to get a "+ adj3+" scoop of ice cream. It filled my stomach.\n\n");
            }
        });




    }
}
