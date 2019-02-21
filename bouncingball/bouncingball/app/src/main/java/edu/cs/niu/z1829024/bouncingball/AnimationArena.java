package edu.cs.niu.z1829024.bouncingball;

import android.graphics.Canvas;

/**
 * Created by Z1829024 on 4/11/2018.
 */

public class AnimationArena
{
    private Ball myBall;

    public AnimationArena()
    {
        //Create the Ball object
        myBall = new Ball();
    }

    public void update(int width, int height)
    {
        myBall.move(0,0,width,height);
    }

    public void draw(Canvas canvas)
    {
        //Set the background color for the canvas
        canvas.drawRGB(156,174,216);



        //Draw the Ball
        myBall.draw(canvas);
    }


}//End of AnimationArena
