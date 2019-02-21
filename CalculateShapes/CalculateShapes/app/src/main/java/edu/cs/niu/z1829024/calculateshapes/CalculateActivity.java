package edu.cs.niu.z1829024.calculateshapes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {
    EditText edit;
    EditText base;
    EditText height;
    EditText major1;
    EditText minor1;
    double major;
    double minor;
    double areaval;
    Button calBtn;
    String catchString;
    TextView displayTV;
    double radius;
    double baseVal,heightVal;
    double area=0;
    static final double PI = 3.14159;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        edit = (EditText)findViewById(R.id.radiusEditText);
        base = (EditText)findViewById(R.id.radiusEditText);
        height = (EditText)findViewById(R.id.radiusEditText);
        major1 = (EditText)findViewById(R.id.majorEdit);
        minor1 = (EditText)findViewById(R.id.minorEdit);
        calBtn = (Button)findViewById(R.id.backButton);
        displayTV = (TextView)findViewById(R.id.display);

        Intent intent = getIntent();
        catchString = intent.getStringExtra("nameID");
        displayTV.setText(catchString + " Area");


        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                areaval = area();
                Intent intent;
                intent = getIntent();
                //Put the name into the intent
                intent.putExtra("nameID",areaval);
                finish();
            }













        });








    }






    public double area()
    {
        if(catchString=="Triangle")
        {
            //radius  =  Double.parseDouble(edit.getText().toString());
            baseVal  =  Double.parseDouble(base.getText().toString());
            heightVal  =  Double.parseDouble(height.getText().toString());
            area = 0.5*baseVal*heightVal;

        }
        else if(catchString=="Circle")
        {
            radius  =  Double.parseDouble(edit.getText().toString());
            area = PI*radius*radius;
        }
        else
        {
            major = Double.parseDouble(major1.getText().toString());
            minor = Double.parseDouble(minor1.getText().toString());
            area = PI*major*minor;
        }
        return area;
    }









}
