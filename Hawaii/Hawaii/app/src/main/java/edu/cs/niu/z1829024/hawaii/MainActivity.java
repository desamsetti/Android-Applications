package edu.cs.niu.z1829024.hawaii;
import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button ukuleleBtn,drumsBtn;
    private MediaPlayer ukuleleMP,drumsMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the two buttons
        ukuleleBtn = (Button)findViewById(R.id.ukuleleButton);
        drumsBtn = (Button)findViewById(R.id.drumsButton);

        //Create the media player for the ukulele mp3
        ukuleleMP = new MediaPlayer();
        ukuleleMP = MediaPlayer.create(this,R.raw.ukulele);

        //Create the media player for the drum mp3
        drumsMP = new MediaPlayer();
        drumsMP = MediaPlayer.create(this,R.raw.drums);
    }//End onCreate



    public void doUkulele(View view)
    {
    //If the ukulele mp3 is playing
        if(ukuleleMP.isPlaying())
        {
            ukuleleMP.pause();
            ukuleleBtn.setText(R.string.playUkuleleString);
        }
     //Otherwise the ukulele mp3 is not playing
        else
        {
            //If the drum mp3 is playing
            if(drumsMP.isPlaying())
            {
                drumsMP.pause();
                drumsBtn.setText(R.string.playDrumsString);
            }
            //Start the ukulele mp3
            ukuleleMP.start();
            ukuleleBtn.setText(R.string.pauseUkuleleString);
        }
    }//End doUkulele

    public void doDrums(View view)
    {
        //If the drums mp3 is playing
        if(drumsMP.isPlaying())
        {
            drumsMP.pause();
            drumsBtn.setText(R.string.playUkuleleString);
        }
        //Otherwise the Drums mp3 is not playing
        else
        {
            //If the Ukulele mp3 is playing
            if(ukuleleMP.isPlaying())
            {
                ukuleleMP.pause();
                ukuleleBtn.setText(R.string.playDrumsString);
            }
            //Start the drums mp3
            drumsMP.start();
            drumsBtn.setText(R.string.pauseUkuleleString);
        }
    }//End doDrums



}//End MainActivity