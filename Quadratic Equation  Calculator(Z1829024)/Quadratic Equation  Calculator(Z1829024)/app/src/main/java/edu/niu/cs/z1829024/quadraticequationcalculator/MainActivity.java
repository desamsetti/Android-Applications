package edu.niu.cs.z1829024.quadraticequationcalculator;
/**
 *  Name : Harshith Desamsetti
 *  Z Id : Z1829024
 *  Assignment Number : 1
 *  Assignment Title : Quadratic Equation Calculator
 *  Due Date : 02/21/2018
 **/
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    //Instance Variables
    EditText aET,bET,cET;
    //EditText type variables

    TextView root1TV, root2TV;
    //TextView type variables

    Button calculate,clear;
    //Button type variables

    double a,b,c,d,x1,x2;
    //Double type variables




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connecting the variables to the interface

        aET = (EditText)findViewById(R.id.aEditText);
        bET = (EditText)findViewById(R.id.bEditText);
        cET = (EditText)findViewById(R.id.cEditText);

        root1TV = (TextView)findViewById(R.id.root1TextView);
        root2TV = (TextView)findViewById(R.id.root2TextView);

        calculate = (Button)findViewById(R.id.calculateButton);
        clear = (Button)findViewById(R.id.clearButton);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!aET.getText().toString().equals("") && !bET.getText().toString().equals("") && !cET.getText().toString().equals(""))
                {
                    a = Double.parseDouble(aET.getText().toString());
                    b = Double.parseDouble(bET.getText().toString());
                    c = Double.parseDouble(cET.getText().toString());
                    //Taking the input
                    d = Math.pow(b,2) - 4*a*c;
                    //Calculating the discriminant b*b - 4*a*c

                    if(d==0)
                    {
                        //If discriminant is equal to zero, then there is only one root
                        x1 = -b/(2*a);
                        root1TV.setText("Discriminant = "+d+"\nRoot 1  = "+x1);
                        root2TV.setText("\nRoot 2 = "+x1);
                        //Set the text to display the discriminant and root value

                    }
                    else if(d<0)
                    {
                        //If discriminant is less than zero, then the roots are imaginary.
                        root1TV.setText("Imaginary");
                        root2TV.setText("Imaginary");
                    //Set the text to display the discriminant and root value
                    }
                    else if(d>0)
                    {
                        //If the discriminant is greater than zero, then there are two roots.
                        x1 = (-b + Math.sqrt(d))/(2*a);
                        x2 = (-b - Math.sqrt(d))/(2*a);

                        root1TV.setText("Discriminant = "+d+"\nRoot 1 = "+x1);
                        root2TV.setText("\nRoot 2 = "+x2);
                    //Set the text to display the discriminant and root value
                    }




                }
            }
        });






        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aET.setText("");
                bET.setText("");
                cET.setText("");

                root1TV.setText("");
                root2TV.setText("");
                //Clear the display.

                }

        });
























    }
}
