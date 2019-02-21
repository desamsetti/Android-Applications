package edu.cs.niu.z1829024.lifecycle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class secondActivity extends Activity {



    public final static String SA_TAG = "LifeCycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(SA_TAG,"In SecondActivity: onCreate");
        Toast.makeText(getApplicationContext(),"In second Activity: onCreate", Toast.LENGTH_LONG).show();
    }//end onCreate

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(SA_TAG,"In SecondActivity: onStart");
        Toast.makeText(getApplicationContext(),"In second Activity: onStart", Toast.LENGTH_LONG).show();
    }//end onStart

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(SA_TAG,"In SecondActivity: onResume");
        Toast.makeText(getApplicationContext(),"In second Activity: onResume", Toast.LENGTH_LONG).show();
    }//End onResume


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(SA_TAG,"In SecondActivity: onPause");
        Toast.makeText(getApplicationContext(),"In second Activity: onPause", Toast.LENGTH_LONG).show();
    }//End onPause


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(SA_TAG,"In SecondActivity: onStop");
        Toast.makeText(getApplicationContext(),"In second Activity: onStop", Toast.LENGTH_LONG).show();
    }//End onStop


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(SA_TAG,"In SecondActivity: onRestart");
        Toast.makeText(getApplicationContext(),"In second Activity: onRestart", Toast.LENGTH_LONG).show();
    }//End onRestart


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(SA_TAG,"In SecondActivity: onDestroy");
        Toast.makeText(getApplicationContext(),"In second Activity: onDestroy", Toast.LENGTH_LONG).show();
    }//End onDestroy

    public void goBack(View view){
        finish();
    }//End goBack








}//end SecondActivity
