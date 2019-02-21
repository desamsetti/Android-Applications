package edu.cs.niu.z1829024.explicitintentwithresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends Activity {
private EditText nameET;












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


        //Connect the nameET object to the item on the screen
        nameET = (EditText)findViewById(R.id.nameEditText);



    }
    public void goBack(View view)
    {
        String nameInput;
        nameInput = nameET.getText().toString();

        Intent intent;
        intent = getIntent();
        //Put the name into the intent
        intent.putExtra("nameID",nameInput);

        //Set the result code
        ((Activity)view.getContext()).setResult(RESULT_OK, intent );
    }
}
