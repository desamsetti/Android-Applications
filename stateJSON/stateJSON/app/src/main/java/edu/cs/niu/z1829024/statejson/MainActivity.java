package edu.cs.niu.z1829024.statejson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<State> states;
    private StateArrayAdapter stateArrayAdapter;
    private ListView stateListView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the list
        states = new ArrayList<>();

        //Connect the listview to the layout
        stateListView = findViewById(R.id.stateListView);


        //Create the array adapter
        stateArrayAdapter = new StateArrayAdapter(this,states);

        //Attach the array adapter to the listview
        stateListView.setAdapter(stateArrayAdapter);
    }//End of onCreate


    //Method for button click
    public void getData(View view)
    {
        //Create a string that holds the URL
        String urlString = getString(R.string.web_url);

        try
        {
            URL url = new URL(urlString);
            StateTask stateTask = new StateTask();
            stateTask.execute(url);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//End of getData




    //Inner AsyncTask class
    private class StateTask extends AsyncTask<URL,String,JSONObject>
    {
        @Override
        protected JSONObject doInBackground(URL... urls)
        {

            HttpURLConnection connection = null;
            try
            {
                //Create the http connection
                connection = (HttpURLConnection)urls[0].openConnection();


                //Test to make sure the connection was okay
                int responseCode = connection.getResponseCode();

                if(responseCode == HttpURLConnection.HTTP_OK)
                {
                    //Read the JSON info from the file
                    StringBuilder builder = new StringBuilder();

                    try
                    {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;

                        line = reader.readLine();
                        while(line != null)
                        {
                            //Append the line to the string builder
                            builder.append(line);

                            line = reader.readLine();
                        }


                    }
                    catch(IOException ioe)
                    {
                        publishProgress("Read Error");
                        ioe.printStackTrace();
                    }
                    return new JSONObject(builder.toString());
                }
                else
                {
                    publishProgress("Bad HTTP connection");
                }


            }//End of outer try
            catch(Exception e)
            {
                publishProgress("Bad URL connection");
                e.printStackTrace();
            }
            finally
            {
                connection.disconnect();
            }
            return null;
        }//End of doInBackground

        @Override
        protected void onProgressUpdate(String... values)
        {
            //super.onProgressUpdate(values);
            Toast.makeText(MainActivity.this,values[0],Toast.LENGTH_LONG).show();

        }//End of onProgressUpdate

        @Override
        protected void onPostExecute(JSONObject jsonObject)
        {
            //super.onPostExecute(jsonObject);
            convertJSONtoArrayList(jsonObject);


            stateArrayAdapter.notifyDataSetChanged();

            stateListView.smoothScrollToPosition(0);
        }//End of onPostExecute
    }//End of StateTask



    //Method to parse the JSON
    private void convertJSONtoArrayList(JSONObject statesObj)
    {
        //Clear the current information in the list
        states.clear();

        try
        {
            //Get the JSON array
            JSONArray stateArray = statesObj.getJSONArray("places");

            //Loop through the array and get the individual json objects
            for(int sub = 0;sub < stateArray.length(); sub++ )
            {
                //Get a json object at position sub
                JSONObject stateObj = stateArray.getJSONObject(sub);

                //Add the json object to the list
                states.add( new State(stateObj.getString("Place"),stateObj.getInt("Number")));
            }//End of for loop
        }
        catch(JSONException jse)
        {
            jse.printStackTrace();
        }
    }//End of convertJtoAL
}//End of MainActivity