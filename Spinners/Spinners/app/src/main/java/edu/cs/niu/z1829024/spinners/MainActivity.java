package edu.cs.niu.z1829024.spinners;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner xmlSpin, classSpin, listSpin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner that gets its info from strings.xml
        xmlSpin = (Spinner)findViewById(R.id.xmlSpinner);

        //Create the array adapter
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),
                                                                                R.array.spinnerArray,
                                                                                R.layout.spinner_view);


        //Connect the adapter and spinner
        xmlSpin.setAdapter(adapter1);

        //Connect the listener to the spinner
        xmlSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            String selection1;
            selection1 = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"The 1st selection is "+selection1,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //Spinner #2 : get the information from teh SpinnerInfo class
        classSpin = (Spinner)findViewById(R.id.classSpinner);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                                                                    R.layout.spinner_view,
                                                                    SpinnerInfo.valueArray);


        classSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selection2;
                selection2 = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"The 2nd selection is :"+selection2,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Spinner #3: get the info from a List object
        List<String> values = new ArrayList<>();
        values.add("Cookies");
        values.add("Cake");
        values.add("Pie");
        values.add("Brownies");
        values.add("Cheesecake");
        values.add("Ice Cream");


        listSpin = (Spinner)findViewById(R.id.listSpinner);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(),
                                                                R.layout.spinner_view,
                                                                values);

        listSpin.setAdapter(adapter3);

        listSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selection3;
                selection3 = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"The 3rd selection is "+selection3, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }
}
