package edu.cs.niu.z1829024.calculateshapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EllipseActivity extends AppCompatActivity {
EditText majorET,minorET;
double major,minor,area;
Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse);
        majorET = (EditText)findViewById(R.id.majorEditText);
        minorET = (EditText)findViewById(R.id.minorEditText);
    }

    public void goBack(View view)
    {

        major = Double.parseDouble(majorET.getText().toString());
        minor = Double.parseDouble(minorET.getText().toString());
        area = 3.14159*major*minor;
        Intent intent = null;
        intent.putExtra("nameID",area);
        intent= new Intent(EllipseActivity.this,MainActivity.class);
        //Put the name into the intent



    }
}
