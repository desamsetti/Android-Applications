package edu.cs.niu.z1829024.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity
{
    private DatabaseManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        manager = new DatabaseManager(this);

        updateView();
    }//End of onCreate

    public void updateView()
    {
        ArrayList<Candy> candies = manager.selectAll();

        //Create the dynamic layout
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);

        //Create a radio group to hold the radio buttons
        RadioGroup radioGroup = new RadioGroup(this);

        //Process the array list and create a radio button for each candy
        for(Candy candy : candies)
        {
            RadioButton radioButton = new RadioButton(this);

            radioButton.setId(candy.getId());
            radioButton.setText(candy.candyToString());

            //Add the radio button to the radio group
            radioGroup.addView(radioButton);
        }//End for

        //Create  the handler for the radio group
        RadioButtonHandler handler = new RadioButtonHandler();

        radioGroup.setOnCheckedChangeListener(handler);


        //Create a back button for exiting
        Button backBtn = new Button(this);

        backBtn.setText(R.string.back_label);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //Add the radio group to the scroll view
        scrollView.addView(radioGroup);

        //add the scrollview to the relative layout
        layout.addView(scrollView);

        //Set the parameters for the button location
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                             ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);


        params.setMargins(0,0,0,50);

        //Add the button to the relative layout using the parameters
        layout.addView(backBtn, params);

        //Display the relative layout
        setContentView(layout);


    }//End of updateView

    //Custom handler for the radio buttons
    private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId)
        {
         manager.deleteById(checkedId);
         Toast.makeText(DeleteActivity.this,"Candy deleted",Toast.LENGTH_SHORT).show();

         updateView();
        }//End of onCheckedChanged
    }//End of RadioButtonHandler

}//End of DeleteActivity
