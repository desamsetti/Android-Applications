package edu.niu.cs.z1829024.project;

/**
 * Created by Harshith Desamsetti on 06-05-2018.
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
public class Questions {

    public String Questions1[] =
            {
                    "Most lines in a C++ program end with a",
                    " main() marks the beginning of a C++ program. What C++ reserved word precedes it?",
                    "What is the correct way to declare an integer variable named \"score\"?",
                    " Given the following declaration:",
                    "According to the lecture notes, the two main conceptual components of a program are _____ and _____.",
                    "Given the following:\n" +
                            "\n" +
                            "  double price = 30.00;\n" +
                            "  double tax   = 1.80;\n" +
                            "  double sum;\n" +
                            "\n" +
                            "  sum = price + tax;",
                    "When you write an illegal C++ statement and try to compile and run the program, you will get a",
                    "What is the value (in C++) of the expression 4 / 2 * 2?",
                    " What is the value (in C++) of the expression 3/2?",
                    "Which data type has the largest range?",
                    "About how many decimal places of accuracy does a float have?",
                    "Modify (rewrite) the following instruction so that the subtraction is evaluated first:"

            };


    public String Answers[][] = {
            {": colon ", "; (semi-colon)","} (closing brace)",") (closing parenthesis)"},
            {"#include","using","void","int"},
            {"int score","int score;","score: integer","integer score;"},
            {"garbage","1","2","3"},
            {"header and body","int main","# include","void main"},
            {"add and assign","multiplies","divides","adds"},
            {"compile error","run time error","logic error","machine crash"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"int","float","double","it depends on the input value"},
            {"31","12","6","4"},
            {"a*b/(c-d)","c-d/a*b","a*b*c-b","a*b"}

            };

    private String correctAnswers[] = {"; (semi-colon)","int","int score;",
            "garbage","header and body","add and assign","compile error","1","1","double","31","a*b/(c-d)"};


    public String getQuestion(int a)
    {
        String question = Questions1[a];
        return question;
    }


    public String getChoice1(int a)
    {
        String choice = Answers[a][0];
        return choice;
    }

    public String getChoice2(int a)
    {
        String choice = Answers[a][1];
        return choice;
    }
    public String getChoice3(int a)
    {
        String choice = Answers[a][2];
        return choice;
    }
    public String getChoice4(int a)
    {
        String choice = Answers[a][3];
        return choice;
    }


    public String getCorrectAnswer(int a)
    {
        String answer = correctAnswers[a];
        return answer;
    }



}