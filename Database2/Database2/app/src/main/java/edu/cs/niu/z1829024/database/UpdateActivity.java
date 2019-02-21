package edu.cs.niu.z1829024.database;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity
{
    DatabaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        manager = new DatabaseManager(this);


        updateView();




    }//End of onCreate



    public void updateView()
    {
        ArrayList<Candy> candies = manager.selectAll();


        if(candies.size()>0)
        {
            //Create a scrollview and a gridlayout to hold the info from database
            ScrollView scrollView = new ScrollView(this);


            GridLayout gridLayout = new GridLayout(this);

            //Set the # of rows and columns for the grid
            gridLayout.setRowCount(candies.size());
            gridLayout.setColumnCount(4);

            //Build the pieces to fill the grid
            TextView[] ids = new TextView[candies.size()];



            EditText [][] namesAndPrices = new EditText[candies.size()][2];

            Button[] buttons = new Button[candies.size()];


            //Create a button handler for the buttons
            ButtonHandler handler = new ButtonHandler();

            //get the width of the screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);

            int width = size.x;

            //Process the arraylist of Candy objects
            int sub = 0;

            for(Candy candy : candies)
            {
                //Create the textview for the candy id
                ids[sub] = new TextView(this);
                ids[sub].setGravity(Gravity.CENTER);
                ids[sub].setText(""+ candy.getId());

                //Create the edittexts with the name and price

                namesAndPrices[sub][0] = new EditText(this);
                namesAndPrices[sub][1] = new EditText(this);


                namesAndPrices[sub][0].setText(candy.getName());
                namesAndPrices[sub][1].setText("" + candy.getPrice());
                namesAndPrices[sub][1].setInputType(InputType.TYPE_CLASS_NUMBER);

                namesAndPrices[sub][0].setId(10 * candy.getId());
                namesAndPrices[sub][1].setId(10 * candy.getId() + 1);

                //Create the button
                buttons[sub] = new Button(this);
                buttons[sub].setText("Update");
                buttons[sub].setId(candy.getId());

                //Associate the buttonhandler with the button
                buttons[sub].setOnClickListener(handler);

                //Add the 4 pieces to the gridlayout
                gridLayout.addView(ids[sub], (int)(width*.1), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(namesAndPrices[sub][0],(int)(width*.4),ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(namesAndPrices[sub][1],(int)(width* .15),ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(buttons[sub],(int)(width * .35), ViewGroup.LayoutParams.WRAP_CONTENT);

                //Increment the subscript
                sub++;
            }//End for

        //Add the gridlayout to the scrollview
            scrollView.addView(gridLayout);

            //display the scrollView
            setContentView(scrollView);
        }//End if

    }//End of updateView

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            int candyId = view.getId();


            EditText nameET = findViewById(10 * candyId),
                    priceET = findViewById(10 * candyId + 1);

            //Get the info from the EditText fields
            String name = nameET.getText().toString(),
                    price = priceET.getText().toString();


            try
            {
                double candyPrice = Double.parseDouble(price);


                manager.updateById(candyId, name, candyPrice);


                Toast.makeText(UpdateActivity.this,"Updated : "+name,Toast.LENGTH_SHORT).show();


                updateView();

            }
            catch(NumberFormatException nfe)
            {
                Toast.makeText(UpdateActivity.this,"Price error",Toast.LENGTH_SHORT).show();
            }
        }//End of OnClick
    }//End of ButtonHandler


}//End of UpdateActivity
