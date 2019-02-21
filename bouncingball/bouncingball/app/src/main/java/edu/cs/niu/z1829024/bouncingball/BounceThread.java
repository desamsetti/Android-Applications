package edu.cs.niu.z1829024.bouncingball;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Z1829024 on 4/11/2018.
 */

public class BounceThread extends Thread
{
    private SurfaceHolder surfaceHolder;
    private AnimationArena animationArena;

    private boolean isRunning;

    public BounceThread(SurfaceHolder sh)
    {
        surfaceHolder = sh;
        isRunning = true;
        animationArena = new AnimationArena();
    }//End of Constructor


    public void run()
    {
        try{
            while(isRunning)
            {
                //Create the canvas and lock it so that nothing else can make a change
                Canvas canvas = surfaceHolder.lockCanvas();

                //Update the ball location on the animation arena
                animationArena.update(canvas.getWidth(),canvas.getHeight());

                //Draw the ball
                animationArena.draw(canvas);

                //Unlock the canvas
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }//End of run





    //Method to end the animation
    public void endBounce()
    {
        isRunning = false;
    }



}//End of BounceThread
