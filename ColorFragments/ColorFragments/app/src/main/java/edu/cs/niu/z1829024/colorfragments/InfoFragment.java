package edu.cs.niu.z1829024.colorfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {


    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }


    public void setText(String shadeInfo)
    {
        //Connect the textview that is on the screen
        TextView info = (TextView)getView().findViewById(R.id.colorInfoTextView);
        info.setText(shadeInfo);
    }



}