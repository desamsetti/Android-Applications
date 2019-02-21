package edu.cs.niu.z1829024.application1;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity
    {
        private ViewGroup pictureCntr;
        private Transition transition;

        private Scene activeScene, passiveScene1,passiveScene2,passiveScene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureCntr = (ViewGroup)findViewById(R.id.paintingContainer);

        //Connect the transition object and transition.xml file
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        //Connect the 4 scene objects with the scene_xml files
        activeScene = Scene.getSceneForLayout(pictureCntr,R.layout.scene1,this);
        passiveScene1 = Scene.getSceneForLayout(pictureCntr,R.layout.scene2,this);
        passiveScene2 = Scene.getSceneForLayout(pictureCntr,R.layout.scene3,this);
        passiveScene3 = Scene.getSceneForLayout(pictureCntr,R.layout.scene4,this);

        //Make the first scene active

        activeScene.enter();
    }


    public void changeScenes(View view)
    {
        //Swap the scene objects
        Scene temp = activeScene;
        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = temp;

        //Apply the transition to the active scene
        TransitionManager.go(activeScene,transition);
    }//End of changeScenes











}