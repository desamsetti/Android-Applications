package edu.cs.niu.z1829024.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
EditText num1ET, num2ET;
TextView resultTV;

Button addBtn, clearBtn,subBtn,mulBtn,divBtn;
Integer num1,num2,result;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the instance variables with the objects on the interface
        num1ET = (EditText)findViewById(R.id.num1EditText);
        num2ET = (EditText)findViewById(R.id.num2EditText);

        resultTV = (TextView)findViewById(R.id.resultTextView);


        addBtn = (Button)findViewById(R.id.addButton);
        clearBtn = (Button)findViewById(R.id.clearButton);
        subBtn = (Button)findViewById(R.id.subButton);
        mulBtn = (Button)findViewById(R.id.mulButton);
        divBtn = (Button)findViewById(R.id.divButton);

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Check to make sure there is data in the EditText fields
                if (num1ET.getText().toString().matches("") ||
                num2ET.getText().toString().matches(""))
                {
                    Toast.makeText(view.getContext(), "You cannot have an empty field", Toast.LENGTH_LONG).show();
                    return;
                }//end if
                //Get the data from the EditText fields
                num1 = Integer.parseInt(num1ET.getText().toString());
                num2 = Integer.parseInt(num2ET.getText().toString());
                //Calculate the sum
                result = num1 + num2;
                //Display the result in the TextView
                resultTV.setText(result.toString());
            }//end of OnClick
        });

        subBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Check to make sure there is data in the EditText fields
                if (num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches(""))
                {
                    Toast.makeText(view.getContext(), "You cannot have an empty field", Toast.LENGTH_LONG).show();
                    return;
                }//end if
                //Get the data from the EditText fields
                num1 = Integer.parseInt(num1ET.getText().toString());
                num2 = Integer.parseInt(num2ET.getText().toString());
                //Calculate the subtraction
                result = num1 - num2;
                //Display the result in the TextView
                resultTV.setText(result.toString());
            }//end of OnClick
        });
        mulBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Check to make sure there is data in the EditText fields
                if (num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches(""))
                {
                    Toast.makeText(view.getContext(), "You cannot have an empty field", Toast.LENGTH_LONG).show();
                    return;
                }//end if
                //Get the data from the EditText fields
                num1 = Integer.parseInt(num1ET.getText().toString());
                num2 = Integer.parseInt(num2ET.getText().toString());
                //Calculate the multiplication
                result = num1 * num2;
                //Display the result in the TextView
                resultTV.setText(result.toString());
            }//end of OnClick
        });
        divBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Check to make sure there is data in the EditText fields
                if (num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches(""))
                {
                    Toast.makeText(view.getContext(), "You cannot have an empty field", Toast.LENGTH_LONG).show();
                    return;
                }//end if
                //Get the data from the EditText fields
                num1 = Integer.parseInt(num1ET.getText().toString());
                num2 = Integer.parseInt(num2ET.getText().toString());
                //Calculate the division
                result = num1 / num2;
                //Display the result in the TextView
                resultTV.setText(result.toString());
            }//end of OnClick
        });
        clearBtn.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            num1ET.setText("");
                                            num2ET.setText("");
                                            resultTV.setText("");
                                        }
                                    }

        );




    }//end of onCreate
}//end of Main activity
