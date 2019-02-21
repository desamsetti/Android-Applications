package edu.cs.niu.z1829024.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public final static String MA_TAG = "LifeCycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(MA_TAG,"In MainActiivty: onCreate");
        Toast.makeText(getApplicationContext(),"In MainActivity : onCreate",Toast.LENGTH_LONG).show();
    }//end onCreate

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MA_TAG,"In MainActiivty: onStart");
        Toast.makeText(getApplicationContext(),"In MainActivity : onStart",Toast.LENGTH_LONG).show();
    }//end onStart

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MA_TAG,"In MainActiivty: onResume");
        Toast.makeText(getApplicationContext(),"In MainActivity : onResume",Toast.LENGTH_LONG).show();
    }//end onResume

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MA_TAG,"In MainActiivty: onPause");
        Toast.makeText(getApplicationContext(),"In MainActivity : onPause",Toast.LENGTH_LONG).show();
    }//end onPause


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MA_TAG,"In MainActiivty: onStop");
        Toast.makeText(getApplicationContext(),"In MainActivity : onStop",Toast.LENGTH_LONG).show();
    }//end onStop


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(MA_TAG,"In MainActiivty: onRestart");
        Toast.makeText(getApplicationContext(),"In MainActivity : onRestart",Toast.LENGTH_LONG).show();
    }//end onRestart


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MA_TAG,"In MainActiivty: onDestroy");
        Toast.makeText(getApplicationContext(),"In MainActivity : onDestroy",Toast.LENGTH_LONG).show();
    }//end onDestroy





    public void doSecond(View view){
        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        startActivity(intent);
    }//end doSecond











}//end MainActivity
