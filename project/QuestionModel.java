package edu.niu.cs.z1829024.project;

/**
 * Created by Harshith Desamsetti on 13-04-2018.
 */
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
public class QuestionModel {
    private String QuestionString;
    private String Answer;

    public QuestionModel(String questionString, String answer) {
        QuestionString = questionString;
        Answer = answer;
    }

    public String getQuestionString() {
        return QuestionString;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setQuestionString(String questionString) {
        QuestionString = questionString;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
