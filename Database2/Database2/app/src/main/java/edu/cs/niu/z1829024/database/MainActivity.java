package edu.cs.niu.z1829024.database;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager manager;
    private double total;
    private ScrollView scrollView;

    private int buttonWidth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create database manager
        manager = new DatabaseManager(this);

        //Set the total to 0
        total = 0.0;

        //Connect the Scrollview
        scrollView = findViewById(R.id.contentScrollView);

        //Calculate the width of the button
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);


        buttonWidth = size.x / 2;


        updateView();


    }//End of onCreate


    @Override
    protected void onResume() {
        super.onResume();
        updateView();
    }//End of onResume




    public void updateView()
    {
        ArrayList<Candy> candies = manager.selectAll();

        if(candies.size() > 0)
        {
            //Clear the scrollview of any existing info
            scrollView.removeAllViewsInLayout();

            //GridLayout for the buttons
            GridLayout gridlayout = new GridLayout(this);
            gridlayout.setRowCount((candies.size() + 1)/2);
            gridlayout.setColumnCount(2);

            //Array of candybuttons, 2 per row
            CandyButton [] buttons = new CandyButton[candies.size()];
            ButtonHandler handler = new ButtonHandler();

            //Fill the gridLayout
            int sub = 0;
            for(Candy candy:candies)
            {
                //create the button
                buttons[sub] = new CandyButton(this,candy);
                buttons[sub].setText(candy.getName() + "\n" + candy.getPrice());


                //Handle the button click
                buttons[sub].setOnClickListener(handler);

                //Add the button to the gridlayout
                gridlayout.addView(buttons[sub],buttonWidth,GridLayout.LayoutParams.WRAP_CONTENT);

                //Increment subscript
                sub++;
            }//End for
            //Add the gridlayout to the scrollview
            scrollView.addView(gridlayout);
        }
    }//End of updateView




    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            //Get the price and it to the total
            total += ((CandyButton)view).getPrice();

            String pay = NumberFormat.getCurrencyInstance().format(total);

            Toast.makeText(MainActivity.this,pay,Toast.LENGTH_LONG).show();



        }//End of OnClick
    }//End of OnClickListener


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add)
        {
            Log.w("MainActivity","Add selected");
            Intent addIntent = new Intent(MainActivity.this,InsertactivityActivity.class);
            startActivity(addIntent);
            return true;
        }
        else if(id==R.id.action_delete)
        {
            Log.w("MainActivity","Delete Selected");
            Intent deleteIntent = new Intent(MainActivity.this,DeleteActivity.class);
            startActivity(deleteIntent);
            return true;
        }
        else if(id==R.id.action_update)
        {
            Log.w("MainActivity","Update Selected");
            Intent updateIntent = new Intent(MainActivity.this,UpdateActivity.class);
            startActivity(updateIntent);
            return true;
        }
        else if(id == R.id.action_reset)
        {
            Log.w("MainActivity","Reset Selected");
            //Reset the total to 0
            total = 0.0;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
