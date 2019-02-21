package edu.cs.niu.z1829024.calculateshapes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CircleActivity extends AppCompatActivity {

    EditText circleET;
    Button circleBtn;
    double area;
    double radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        circleET = (EditText) findViewById(R.id.circleEditText);
        circleBtn = (Button) findViewById(R.id.circleButton);



    }
    public void goBack(View view)
    {

        radius = Double.parseDouble(circleET.getText().toString());
        area = 3.14159 * radius * radius;
        Intent intent = null;
        intent.putExtra("nameID",area);
        intent= new Intent(CircleActivity.this,MainActivity.class);
        //Put the name into the intent



    }
}
