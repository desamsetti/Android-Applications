package edu.niu.cs.z1829024.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class RockPaperScissors extends AppCompatActivity {

    Button rock,paper,scissors;
    ImageView cpuImageView,meImageView;
    String cpuChoice, myChoice,output;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        cpuImageView = (ImageView) findViewById(R.id.cpu);
        meImageView = (ImageView) findViewById(R.id.me);

        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "rock";
                meImageView.setImageResource(R.drawable.rock);
                Calculate();
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "paper";
                meImageView.setImageResource(R.drawable.paper);
                Calculate();
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "scissors";
                meImageView.setImageResource(R.drawable.scissors);
                Calculate();
            }
        });
    }



    public void Calculate()
    {
        int cpu = r.nextInt(3);
        if(cpu==0)
        {
            cpuChoice="rock";
            cpuImageView.setImageResource(R.drawable.rock);
        }
        else if(cpu==1)
        {
            cpuChoice="paper";
            cpuImageView.setImageResource(R.drawable.paper);
        }
        else if(cpu==2)
        {
            cpuChoice="scissors";
            cpuImageView.setImageResource(R.drawable.scissors);
        }



        if(myChoice.equals("rock") && cpuChoice.equals("paper"))
        {
            output = "You lose";
        }
        else if(myChoice.equals("rock") && cpuChoice.equals("scissors"))
        {
            output = "You win";
        }
        else if(myChoice.equals("paper") && cpuChoice.equals("rock"))
        {
            output = "You win";
        }
        else if(myChoice.equals("paper") && cpuChoice.equals("scissors"))
        {
            output = "You lose";
        }
        else if(myChoice.equals("scissors") && cpuChoice.equals("rock"))
        {
            output = "You lose";
        }
        else if(myChoice.equals("scissors") && cpuChoice.equals("paper"))
        {
            output = "You win";
        }
        else if(myChoice.equals("scissors") && cpuChoice.equals("scissors"))
        {
            output = "Draw";
        }
        else if(myChoice.equals("paper") && cpuChoice.equals("paper"))
        {
            output = "Draw";
        }
        else if(myChoice.equals("rock") && cpuChoice.equals("rock"))
        {
            output = "Draw";
        }

        Toast.makeText(RockPaperScissors.this,output,Toast.LENGTH_SHORT).show();

    }



}
