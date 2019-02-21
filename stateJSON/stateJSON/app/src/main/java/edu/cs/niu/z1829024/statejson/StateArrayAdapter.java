package edu.cs.niu.z1829024.statejson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Z1829024 on 4/30/2018.
 */

public class StateArrayAdapter extends ArrayAdapter<State>
{
    public StateArrayAdapter(@NonNull Context context, List<State> states)
    {
        super(context, -1, states);
    }//End of Constructor


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //Get the state object for the specified position
        State state = getItem(position);

        //Create a reference to the list item View
        ViewHolder viewHolder;

        //Does the convertView (argument #2) have data?
        if(convertView == null)
        {
            viewHolder = new ViewHolder();


            //Create a layout inflater to attach the custom layout
            LayoutInflater inflater = LayoutInflater.from(getContext());



            convertView = inflater.inflate(R.layout.list_item,parent,false);

            //Connect the layouts
            viewHolder.stateTV = convertView.findViewById(R.id.stateTextView);
            viewHolder.stateNumTV =  convertView.findViewById(R.id.stateNumberTextView);

            //Store the viewHolder with the ListView item
            convertView.setTag(viewHolder);
        }
        else //There was data
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        //Populate the two text fields of the ViewHolder object
        viewHolder.stateTV.setText(state.stateAbbr);
        viewHolder.stateNumTV.setText("" + state.stateNum);

        //Return the ListView item to be displayed
        return convertView;
    }//End of getView


    //Inner class
    private static class ViewHolder
    {
        TextView stateTV, stateNumTV;
    }//End of ViewHolder





}//End of StateArrayAdapter
