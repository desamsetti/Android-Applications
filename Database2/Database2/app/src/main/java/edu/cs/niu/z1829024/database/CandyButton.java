package edu.cs.niu.z1829024.database;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

/**
 * Created by Z1829024 on 4/23/2018.
 */

public class CandyButton extends AppCompatButton
{
    private Candy candy;


    public CandyButton(Context context, Candy newCandy)
    {
        super(context);
        candy = newCandy;
    }//End of Constructor


    public double getPrice()
    {
        return candy.getPrice();
    }//End getPrice


   //End of CandyButton
}
