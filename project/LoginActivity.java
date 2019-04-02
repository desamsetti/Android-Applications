package edu.niu.cs.z1829024.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
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
public class LoginActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    private EditText emailET,passwordET;
    private Button loginBtn;
    private TextView signUpTextView;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        emailET = (EditText)findViewById(R.id.etEmail);
        passwordET = (EditText)findViewById(R.id.etPassword);
        loginBtn = (Button)findViewById(R.id.loginButton);
        signUpTextView = (TextView)findViewById(R.id.tvSignUp);

        db = openHelper.getReadableDatabase();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String emailStr = emailET.getText().toString();
                String passwordStr = passwordET.getText().toString();
                String sqlCheck = "";

                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.EMAIL + " =? AND " + DatabaseHelper.PASSWORD + "=?", new String[]{emailStr, passwordStr});



                if(cursor!=null)
                {
                    if(cursor.getCount()>0) {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,Screen.class));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }

                }

            }



        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUp.class));
            }
        });
    }
}
