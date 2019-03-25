package edu.niu.cs.z1829024.project;


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
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    private EditText nameET, emailET, passwordET;
    private Button signUpBtn, loginBtn;

    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        openHelper = new DatabaseHelper(this);
        nameET = (EditText) findViewById(R.id.nameET);
        emailET = (EditText) findViewById(R.id.emailET);
        passwordET = (EditText) findViewById(R.id.passwordET);

        signUpBtn = (Button) findViewById(R.id.signUpButton);
        loginBtn = (Button)findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public void OnClick(View v) {

        db = openHelper.getWritableDatabase();
        String nameStr = nameET.getText().toString().trim();
        String emailStr = emailET.getText().toString().trim();
        String passwordStr = passwordET.getText().toString().trim();

        if (nameStr.equals("") || emailStr.equals("") || passwordStr.equals("")) {
            Toast.makeText(SignUp.this, "Please fill the details", Toast.LENGTH_SHORT).show();
        } else {

            insertData(nameStr, emailStr, passwordStr);
            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUp.this,LoginActivity.class));
        }


    }


    public void insertData(String name, String email, String password)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME,name);
        contentValues.put(DatabaseHelper.EMAIL,email);
        contentValues.put(DatabaseHelper.PASSWORD,password);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);


    }

}