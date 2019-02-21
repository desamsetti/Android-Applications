package edu.cs.niu.z1829024.async1;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button downloadBtn;
    private ProgressBar downloadPB;
    private TextView downloadTV,callbackTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBtn= findViewById(R.id.downloadButton);
        downloadPB = findViewById(R.id.downloadProgressBar);
        downloadTV = findViewById(R.id.downloadTextView);
        callbackTV = findViewById(R.id.callbackTextView);
    }//End of onCreate


    public void startDownload(View view)
    {
        //disable the download button
        downloadBtn.setEnabled(false);


        //Create an downloadAsyncTask object
        DownloaAsyncTask task = new DownloaAsyncTask();

        //Start the asynctask
        task.execute();

    }//End of startDownload

    public void doReset(View view)
    {
    //Reset the callback textview back to its initial state
        callbackTV.setText(R.string.callbacks_label);

        //Reset the progress bar
        downloadPB.setProgress(0);

        //Reset the download textview
        downloadTV.setText(R.string.download_start_label);

        //Unlock the screen orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);


    }//End of doReset


    //Inner AsyncTask class
    private class DownloaAsyncTask extends AsyncTask<Void, Integer, Void>
    {
        int progressStatus;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Append a message to the current message in the callback textview
            callbackTV.setText( callbackTV.getText() + "\n\nLock the screen orientation");

            //Lock the screen orientation
            int currentOrientation = getResources().getConfiguration().orientation;


            if(currentOrientation == Configuration.ORIENTATION_PORTRAIT)
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            else
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            //Append the next message
            callbackTV.setText(callbackTV.getText()+"\nInvoke onPreExecute()");

            //Initialize the progress status to 0
            progressStatus = 0;

            //get the starting message for the download textview
            downloadTV.setText(R.string.download_start_label);



            //Append the final messages for onPreExecute
            callbackTV.setText(callbackTV.getText()+  "\nEnd of onPreExecute");
            callbackTV.setText(callbackTV.getText()+  "\nInvoke doInBackground");
            callbackTV.setText(callbackTV.getText()+ "\nPerforming background work...");
        }//End of OnPreExecute

        @Override
        protected Void doInBackground(Void... voids)
        {
            //Simulate the download
            while(progressStatus<100) {
                progressStatus += 2;
                //Update the progress of the progress bar
                publishProgress(progressStatus);

                //Pause to make it seem like it is downloading something
                SystemClock.sleep(300);
            }
                return null;
        }//End of doInBackground


        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);

            //Update the progress bar
            downloadPB.setProgress(values[0]);

            //Update the download textview
            downloadTV.setText("downloading "+ values[0] + "%");
        }//End of onProgressUpdate


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //Append more messages to callback textview
            callbackTV.setText(callbackTV.getText() + "\nCompleted doInBackground");
            callbackTV.setText(callbackTV.getText() + "\nInvoke onPostExecute()");

            //Update download textview
            downloadTV.setText("Download complete");


            //Enable the download button
            downloadBtn.setEnabled(true);
        }//End of onPostExecute
    }//End of DonwloadAsyncTask









}//End of MainActivity
