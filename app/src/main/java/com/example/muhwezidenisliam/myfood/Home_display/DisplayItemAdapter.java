package com.example.muhwezidenisliam.myfood.Home_display;

import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


import com.example.muhwezidenisliam.myfood.R;
import com.example.muhwezidenisliam.myfood.drive_image.MainFragment;

import ch.haclyon.driveimageview.DriveImageModel;
import ch.haclyon.driveimageview.DriveImageView;


public class DisplayItemAdapter extends ArrayAdapter<String> {


    private FragmentManager fragmentManager;
    private String[] foods={"Ugandan Rolex","Chicken dish","Pizza","Macaroni Dish","Burger"};

    public DisplayItemAdapter(Context context, ArrayList<String> descriptions, FragmentManager fragmentManager) {
        super(context, 0, descriptions);
        this.fragmentManager = fragmentManager;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String desc = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(com.example.muhwezidenisliam.myfood.R.layout.word_item, parent, false);
        }

        String ftext = foods[position];
        DriveImageModel m = new DriveImageModel(desc, ftext, MainFragment.samplePictures[position]);

        DriveImageView view = (DriveImageView) convertView.findViewById(com.example.muhwezidenisliam.myfood.R.id.driveImageView);
        view.setDriveImageModel(m);
        view.setBackgroundColor(MainFragment.sampleColours[position]);
        view.setCustomFolderSpacing(130f);
        view.setAlphaValue(1.0f);
        view.setCustomHeight(MainFragment.sampleHeights[position]);
        return convertView;
    }

}