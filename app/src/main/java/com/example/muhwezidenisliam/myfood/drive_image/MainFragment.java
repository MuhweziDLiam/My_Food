package com.example.muhwezidenisliam.myfood.drive_image;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.muhwezidenisliam.myfood.Home_display.DisplayItemAdapter;
import com.example.muhwezidenisliam.myfood.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    public static String[] sampleTexts = new String[]{"Ugandan rolex prepared using chapati and eggs", "Fried chicken dish with lettuce", "Beef pizza ingredients sauce pepper beef ", "Macaroni with spices and beef ", "Beef  burger ingredients are flour and beef"};
    public static int[] samplePictures = new int[]{R.drawable.type5, R.drawable.type3, R.drawable.type4, R.drawable.type2, R.drawable.type1};
    public static String[] sampleColours = new String[]{"#F44336", "#009688", "#4CAF50", "#FF5722", "#795548"};
    public static float[] sampleHeights = new float[]{50f, 50f, 50f, 50f, 50f};

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(new DisplayItemAdapter(view.getContext(), new ArrayList<String>(Arrays.asList(sampleTexts)), getFragmentManager()));

        return view;
    }
}
