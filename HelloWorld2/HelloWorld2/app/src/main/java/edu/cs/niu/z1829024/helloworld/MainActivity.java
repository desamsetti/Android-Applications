package edu.cs.niu.z1829024.helloworld;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity // have to import activity
{
    //define the instance variables
    private TextView messageTV;

    private Button switchBtn;

    private boolean isHello;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //connect the instance variables with the items in the XML file
        //assume that the ids for the
        //TextView: messageTextView
        //Button:   switchButton

        messageTV = (TextView) findViewById( R.id.messageTextView );

        switchBtn = (Button) findViewById( R.id.switchButton );

        //initialize boolean variable to true

        isHello = true;

        //handle a button click

        switchBtn.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                if( isHello )
                {
                    //change the message to goobye

                    messageTV.setText( R.string.goodbyestring );

                    //update the boolean variable
                    isHello = false;
                }
                else
                {
                    messageTV.setText( R.string.app_name );
                    isHello = true;
                }
            }//end of onClick
        });
    }//end of onCreate
}//end of MainActivity