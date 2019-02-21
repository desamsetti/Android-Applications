package edu.cs.niu.z1829024.countingthread;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private TextView countTV;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTV = (TextView)findViewById(R.id.countTextView);

        counter = 0;


        //Create the thread
        Thread thread = new Thread( countNumbers ); //Not anonymous

        //Start the execution of the thread
        thread.start();




    }//End of OnCreate

    @Override
    protected void onStart()
    {
        super.onStart();
        counter = 0;
    }//End onStart



    //Runnable
    private Runnable countNumbers = new Runnable()
    {
        private static final int DELAY = 1000;

        @Override
        public void run()
        {
         while(true)
         {
             threadHandler.sendEmptyMessage(0);
             counter++;

             try{
                 Thread.sleep(DELAY);
             }
             catch(InterruptedException e)
             {
                 e.print
             }


         }//End While
        }
    };//End of countNumber runnable


}//End of MainActivity
