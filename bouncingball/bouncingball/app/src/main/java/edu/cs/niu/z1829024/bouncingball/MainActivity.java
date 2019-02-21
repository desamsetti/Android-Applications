package edu.cs.niu.z1829024.bouncingball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create a FrameLayout and connect it with the screen
        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        //Create a bounce surface view
        BounceSurfaceView bounceSurfaceView = new BounceSurfaceView(this,null);

        //Put the surface view on the frame layout
        frameLayout.addView(bounceSurfaceView);
    }
}
