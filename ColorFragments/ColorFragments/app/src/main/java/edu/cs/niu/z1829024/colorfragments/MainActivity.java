package edu.cs.niu.z1829024.colorfragments;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends Activity implements ListFragment.OnItemSelectedListener
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//End onCreate


    @Override
    public void onShadeItemSelected(String shadeInfo)
    {
     //Create an Information Fragment
     InfoFragment infoFragment = (InfoFragment)getFragmentManager().findFragmentById(R.id.infoFragment);

     //Check to see if the infofragment is in the layout
        if(infoFragment!= null && infoFragment.isInLayout())
        {
            //This means the device is in landscape orientation
            infoFragment.setText(shadeInfo); //This uses the setText for the InfoFragment
        }
        else
        {
            //Devicce is in portrait orientation
            Intent intent = new Intent(this,InformationActivity.class);
            //Put the passed in string into the intent
            intent.putExtra("Information",shadeInfo);
            startActivity(intent);
        }

    }
}
