package com.example.muhwezidenisliam.myfood.menu_fragments;



import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;


import com.example.muhwezidenisliam.myfood.MenuActivity;
import com.example.muhwezidenisliam.myfood.R;
import com.special.ResideMenu.ResideMenu;

import com.example.muhwezidenisliam.myfood.drive_image.MainFragment;



public class HomeFragment extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;

    private boolean isFirstRun;
    private SharedPreferences prefs;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.home, container, false);

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        isFirstRun= prefs.getBoolean("isFirstRun",true);

        if(isFirstRun) {
            loadingPopup();
        }

        isFirstRun=false;

        prefs.edit().putBoolean("isFirstRun",isFirstRun).commit();


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MainFragment mainFragment = new MainFragment();
        fragmentTransaction.replace(com.example.muhwezidenisliam.myfood.R.id.fragment_container, mainFragment);
        fragmentTransaction.commit();




        setUpViews();


        return parentView;
    }

    private void setUpViews() {
        MenuActivity parentActivity = (MenuActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();



        // add gesture operation's ignored views
       /* FrameLayout ignored_view = (FrameLayout) parentView.findViewById(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);*/
    }

    private void loadingPopup() {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View layout = inflater.inflate(R.layout.first_time_popup, null);

        final PopupWindow windows = new PopupWindow(layout , ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);

        windows.setFocusable(false);
        windows.setTouchable(true);
        windows.setOutsideTouchable(false);
        layout.post(new Runnable() {
            public void run() {
                windows.showAtLocation(layout, Gravity.CENTER, 0, 0);
            }
        });


        Button btnDismiss = (Button) layout.findViewById(R.id.dismiss);


        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                windows.dismiss();

            }
        });
    }


}
