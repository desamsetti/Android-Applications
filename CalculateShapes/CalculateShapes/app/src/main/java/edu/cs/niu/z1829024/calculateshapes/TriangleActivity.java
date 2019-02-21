package edu.cs.niu.z1829024.calculateshapes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TriangleActivity extends AppCompatActivity {
EditText baseET,heightET;
Button triangleBtn;
double base,height,area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        baseET = (EditText)findViewById(R.id.baseEditText);
        heightET = (EditText)findViewById(R.id.heightEditText);
        triangleBtn = (Button)findViewById(R.id.TriangleButton);
    }
    public void goBack(View view)
    {

        base = Double.parseDouble(baseET.getText().toString());
        height = Double.parseDouble(heightET.getText().toString());
        area = 0.5*base*height;
        Intent intent = null;
        intent.putExtra("nameID",area);
        intent= new Intent(TriangleActivity.this,MainActivity.class);
        //Put the name into the intent
        

        
    }
}
