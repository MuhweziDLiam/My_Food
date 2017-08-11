package com.example.muhwezidenisliam.myfood.menu_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.muhwezidenisliam.myfood.R;

/**
 * Created by Muhwezi Denis Liam on 4/1/2017.
 */
public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about, container, false);

        return rootView;
    }
}

