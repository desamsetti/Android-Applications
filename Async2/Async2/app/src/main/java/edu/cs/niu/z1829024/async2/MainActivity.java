package edu.cs.niu.z1829024.async2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TestTask testTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void doChange(View view)
    {
        EditText dataET = findViewById(R.id.numberEditText);
        int faveNum = Integer.parseInt(dataET.getText().toString());

        Log.w("MainActivity","Creating the TestTask object");
        testTask = new TestTask(this);

        Log.w("MainActivity","Starting TestTask");
        testTask.execute(faveNum);

    }//End of doChange


    public void updateView(String message)
    {
    Log.w("MainActivity","In UpdateView");
    TextView messageTV = findViewById(R.id.messageTextView);
    messageTV.setText(message);
    }//End of updateView
}//End of MainActivity
