package edu.cs.niu.z1829024.async2;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Z1829024 on 4/25/2018.
 */

public class TestTask extends AsyncTask<Integer, Void, String >
{
    private MainActivity activity;


    public TestTask(MainActivity fromActivity)
    {
        activity = fromActivity;
        Log.w("MainActivity", "Inside TestTask Constructor");
    }//End of constructor


    @Override
    protected String doInBackground(Integer... integers)
    {
        Log.w("MainActivity","Inside doInBackground");

        return "Your favorite number is " + integers[0] + "\nchanged using an asynctask";
    }//End doInBackground


    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Log.w("MainActivity","Inside onPostExecute");
        activity.updateView(s);
    }//End of onPostExecute
}//End TestTask

