package edu.cs.niu.z1829024.explicitintentwithresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
 private TextView nameTV;

 static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTV = (TextView)findViewById(R.id.nameTextView);
    }
    public void getName(View view)
    {
     Intent intent = new Intent(MainActivity.this,NameActivity.class);

     startActivityForResult(intent, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String returnedName;

        if(resultCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            //get the info from the intent and put in String object
            returnedName = data.getStringExtra("nameID");

            //put the info on the screen
            nameTV.setText("Your name is "+ returnedName);



        }
    }
}
