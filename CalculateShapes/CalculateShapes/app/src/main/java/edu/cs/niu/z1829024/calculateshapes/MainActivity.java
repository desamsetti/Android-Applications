package edu.cs.niu.z1829024.calculateshapes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup shapeGrp;
    Button calculateBtn;
    TextView displayValue;
    String selection = "";
    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapeGrp = (RadioGroup)findViewById(R.id.shapeRadioGroup);;
        calculateBtn = (Button)findViewById(R.id.calculateButton);;
        displayValue = (TextView)findViewById(R.id.valueTextView);
        shapeGrp.setOnCheckedChangeListener(shapeListener);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CalculateActivity.class);
                intent.putExtra("nameID",selection.toString());

                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }


        private RadioGroup.OnCheckedChangeListener shapeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.Triangle:
                        selection = "Triangle";
                        Intent intent = new Intent(MainActivity.this,TriangleActivity.class);
                        startActivityForResult(intent,REQUEST_CODE);
                        break;
                    case R.id.Circle:
                        selection = "Circle";
                        Intent circleintent = new Intent(MainActivity.this,CircleActivity.class);
                        startActivityForResult(circleintent,REQUEST_CODE);
                        break;
                    case R.id.Ellipse:
                        selection = "Ellipse";
                        Intent ellipseintent = new Intent(MainActivity.this,EllipseActivity.class);
                        startActivityForResult(ellipseintent,REQUEST_CODE);
                        break;

                }
            }

    };








    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String returnedVal;

        if(resultCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            //get the info from the intent and put in String object
            returnedVal = data.getStringExtra("nameID");


            //put the info on the screen
            displayValue.setText("Your value is "+ returnedVal);
        }
    }







}
