package edu.cs.niu.z1829024.weightcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    //Instance Variables
    private ShippingItem shippingItem;

    private EditText weightET;
    private TextView baseCostTV,addedCostTV,totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create the shipping item
        shippingItem = new ShippingItem();


        //Connect the variables to the items on the screen
        weightET = (EditText)findViewById(R.id.ouncesEditText);


        baseCostTV = (TextView)findViewById(R.id.baseTextView);
        addedCostTV = (TextView)findViewById(R.id.addedTextView);
        totalCostTV = (TextView)findViewById(R.id.totalTextView);
        //Connect a TextWatcher to the EditText field
        //this will be a named TextWatcher

        weightET.addTextChangedListener(weightTextWatcher );




    }//End of onCreate

    //The TextWatcher
    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int beforeLen, int charCnt)
        {
            try
            {
                shippingItem.setWeight(Integer.parseInt(charSequence.toString()));
            }
            catch(NumberFormatException nfe)
            {
                shippingItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    private void displayShipping()
    {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        baseCostTV.setText("$" + decimalFormat.format(shippingItem.getBaseCost()));
        addedCostTV.setText("$" + decimalFormat.format(shippingItem.getAddedCost()));
        totalCostTV.setText("$" + decimalFormat.format(shippingItem.getTotalCost()));
    }//End of displayShipping()

}//End of MainActivity
