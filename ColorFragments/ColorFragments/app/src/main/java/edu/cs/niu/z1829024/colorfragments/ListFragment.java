package edu.cs.niu.z1829024.colorfragments;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.test.suitebuilder.annotation.Suppress;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

private OnItemSelectedListener listener;
private String information;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment into a View object
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        Button plumBtn = view.findViewById(R.id.plumButton);
        Button goldBtn = view.findViewById(R.id.goldButton);
        Button blueBtn = view.findViewById(R.id.blueButton);

        //Handle button clicks with a named listener
        plumBtn.setOnClickListener(shadeListener);
        blueBtn.setOnClickListener(shadeListener);
        goldBtn.setOnClickListener(shadeListener);

        //Return the View object
        return view;
    }

    private View.OnClickListener shadeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Get the content description from the button that was clicked
            information = (String)view.getContentDescription();
            listener.onShadeItemSelected(information);
        }
    };//End shadeListener

    public interface OnItemSelectedListener
    {
        public void onShadeItemSelected(String shadeInfo);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //If the activity is an instance of OnItemSelectedListener
        if(activity instanceof OnItemSelectedListener)
        {
            listener = (OnItemSelectedListener)activity;
        }
        //Otherwise, throw an exception
        else
        {
            throw new ClassCastException(activity.toString() + "must implement ListFragment. OnItemSelectedListener");
        }
    }//End onAttach
}//End of ListFragment