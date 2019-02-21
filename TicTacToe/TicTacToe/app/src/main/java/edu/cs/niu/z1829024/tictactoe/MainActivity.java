package edu.cs.niu.z1829024.tictactoe;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button[][] buttons;
    private TicTacToe game;
    private TextView gameStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Create the TicTacToe object
        game = new TicTacToe();

        buildGUI();
        //setContentView(R.layout.activity_main);
    }//End of onCreate



    public void buildGUI()
    {
       //Get the width of the Screen
        Point size = new Point(); //As we are using graphics, use point
        getWindowManager().getDefaultDisplay().getSize(size); //To get the width of the screen
        //Calculate the width of the button
        int width = size.x / TicTacToe.SIDE;           //To get the equal width for three boxes.Also size.x for width and
                                                        //size.y for height
        //Create a gridlayout programmatically
        GridLayout gridLayout = new GridLayout(this);

        //Set the number of rows and columns for the grid
        gridLayout.setRowCount(TicTacToe.SIDE + 1);
        gridLayout.setColumnCount(TicTacToe.SIDE);


        //Create the array of buttons
        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];

        //Create a buttonHandler
        ButtonHandler buttonHandler = new ButtonHandler();



        //Add the buttons to the gridLayout
        for(int row = 0; row < TicTacToe.SIDE;row++)
        {
            for(int col = 0; col<TicTacToe.SIDE;col++)
            {
                //Create an Individual button and put it in the array of buttons
                buttons[row][col] = new Button(this);


                //Change the textsize for the button
                buttons[row][col].setTextSize((int)(width*0.2));

                //Associate the buttonhandler with the button
                buttons[row][col].setOnClickListener(buttonHandler);



                //Put the button in the gridLayout
                gridLayout.addView(buttons[row][col],width,width);
            }
        }

        //Add in the textview

        //Create the textview

        gameStatus = new TextView(this);

        //Create specifications for the textview that will be added to the grid layout
        GridLayout.Spec rowSpec = GridLayout.spec(TicTacToe.SIDE,1);
        GridLayout.Spec colSpec = GridLayout.spec(0,TicTacToe.SIDE);


        //Create layout parameters for the textview
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,colSpec);

        //Apply the layout parameters to the textview
        gameStatus.setLayoutParams(params);

        //Center the text in the textview
        gameStatus.setGravity(Gravity.CENTER);

        //Set the color of the textview
        gameStatus.setBackgroundColor(Color.MAGENTA);

        //Set the width
        gameStatus.setWidth(TicTacToe.SIDE * width);

        //Set the textsize
        gameStatus.setTextSize((int)(width*0.15));

        //Put the status of the game in the textview
        gameStatus.setText(game.result());

        //Add the textview to the gridlayout
        gridLayout.addView(gameStatus);

        //Put the gridLayout on the screen
        setContentView(gridLayout);

    }//End od buildGUI




    private class ButtonHandler implements OnClickListener
    {
        @Override
        public void onClick(View view) {
            //Display a Toast message that shows which button was touched
            //Toast.makeText(MainActivity.this,"ButtonHandler onClick: "+view, Toast.LENGTH_LONG).show();

            //Determine which button was clicked
            for(int row = 0;row<TicTacToe.SIDE;row++)
            {
                for(int col = 0; col<TicTacToe.SIDE;col++)
                {
                    if(view == buttons[row][col])
                    {
                        update(row,col);
                    }
                }
            }
        }//End of onClick
    }//End of ButtonHandler



    public void update(int row,int column)
    {
        //Temporary Toast Message
        //Toast.makeText(MainActivity.this,"update: row "+row + " and column " +column,Toast.LENGTH_LONG).show();

        //Put an X on the button that was clicked
        //buttons[row][column].setText("X");

        int currentPlayer = game.play(row,column);

        if(currentPlayer == 1)
            buttons[row][column].setText("X");
        else if(currentPlayer == 2)
            buttons[row][column].setText("O");

        //Check if the game is over
        if(game.isGameOver())
        {
            gameStatus.setBackgroundColor(Color.CYAN);
            //Disable all of the buttons
            enableButtons(false);
            gameStatus.setText(game.result());
            showNewGameDialog();
        }

    }//End of update



    public void enableButtons(boolean enabled)
    {
        for(int row = 0;row< TicTacToe.SIDE;row++)
        {
            for(int col=0;col<TicTacToe.SIDE;col++)
            {
                buttons[row][col].setEnabled(enabled);
            }
        }
    }//End of enableButtons

    public void resetButtons()
    {
        for(int row=0;row<TicTacToe.SIDE;row++)
            for(int col=0;col<TicTacToe.SIDE;col++)
                buttons[row][col].setText("");
    }

 public void showNewGameDialog()
 {
     AlertDialog.Builder alert = new AlertDialog.Builder(this);

     //Set the title for the dialog box
     alert.setTitle("Tic Tac Toe");

     //Set the message for the dialog box
     alert.setMessage("Play Again?");

     //Create the positive button
     alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i)
         {
             //Reset the TicTacToe object for a new game
             game.resetGame();

             //Enable all of the buttons
             enableButtons(true);

             //Reset the buttons for a new game
             resetButtons();

             gameStatus.setBackgroundColor(Color.MAGENTA);
             gameStatus.setText(game.result());
         }
     });

     //Create the negative button
     alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) {
             //End game
             MainActivity.this.finish();
         }
     });


     //Display the dialog box
     alert.show();


 }//End showNewGameDialog










}//End of MainActivity
