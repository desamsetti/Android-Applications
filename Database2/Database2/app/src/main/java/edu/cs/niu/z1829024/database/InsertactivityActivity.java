package edu.cs.niu.z1829024.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertactivityActivity extends AppCompatActivity
{
    private DatabaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        manager = new DatabaseManager(this);
        setContentView(R.layout.insertactivity);
    }//End of onCreate

    public void insertCandy(View view)
    {
        //Get the data from the EditText fields
        EditText nameET = findViewById(R.id.nameEditText),
                priceET = findViewById(R.id.priceEditText);

        String name = nameET.getText().toString(),
                price = priceET.getText().toString();

        //Add the information to the database
        try
        {
            double priceAmt = Double.parseDouble(price);

            //Create the candy object to insert into the database
            Candy candy = new Candy(0,name,priceAmt);

            //Add the candy to the database
            manager.insert(candy);

            Toast.makeText(this,"Candy added: " + name,Toast.LENGTH_SHORT).show();
        }
        catch(NumberFormatException nfe)
        {
            Toast.makeText(this,"Price error",Toast.LENGTH_SHORT).show();
        }

        //Test to make sure the info is actually in the database
        ArrayList<Candy> candies = manager.selectAll();

        for(Candy candy: candies)
        {
            Toast.makeText(this,"Candy: "+ candy.candyToString(),Toast.LENGTH_SHORT).show();
        }










        //Clear the EditText fields for the next addition
        nameET.setText("");
        priceET.setText("");

    }//End of insertCandy

    public void goBack(View view)
    {
        finish();
    }//End of goBack
}
