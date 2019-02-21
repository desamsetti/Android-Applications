package edu.cs.niu.z1829024.bouncingball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Z1829024 on 4/11/2018.
 */

public class BounceSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private BounceThread bounceThread;

    public BounceSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Create the SurfaceHolder
        SurfaceHolder holder = getHolder();

        //Attach the callback methods to the surface holder
        holder.addCallback(this);

        //Create the thread
        bounceThread = new BounceThread(holder);
    }


    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2)
    {

    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder)
    {
        bounceThread.start();
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {
        //End the animation
        bounceThread.endBounce();

        //Nullify the Thread
        Thread dummyThread = bounceThread;
        bounceThread = null;
        dummyThread.interrupt();
    }
}//End of BounceSurfaceView
