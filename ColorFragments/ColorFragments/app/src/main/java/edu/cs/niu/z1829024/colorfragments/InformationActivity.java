package edu.cs.niu.z1829024.colorfragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        //Check for the device being in landscape orientation
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            finish();
            return;
        }
        //In portrait orientation

        //Get the layout for the InfoFragment onto the screen
        setContentView(R.layout.fragment_info);

        //Get the intent
        Intent intent = getIntent();
        String shadeInfo = intent.getStringExtra("Information");

        TextView infoTV = (TextView)findViewById(R.id.colorInfoTextView);
        infoTV.setText(shadeInfo);

        Button backBtn = (Button)findViewById(R.id.backButton);

        backBtn.setVisibility(View.VISIBLE);
    }//End of onCreate


    public void goBack(View view)
    {
        finish();
        //Change the button's visibility to invisible
        view.setVisibility(View.INVISIBLE);
    }//End of goBack
}


