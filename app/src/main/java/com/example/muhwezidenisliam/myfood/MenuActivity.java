package com.example.muhwezidenisliam.myfood;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.muhwezidenisliam.myfood.fragment_holder_framework_one.DataProvider;
import com.example.muhwezidenisliam.myfood.menu_fragments.AboutFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.FoodRecipesFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.FruitsGuideFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.HomeFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.MineralsSourcesFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.NutritionGuideFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.VegetablesGuideFragment;
import com.example.muhwezidenisliam.myfood.menu_fragments.VitaminSourcesFragment;
import com.forcelain.awesomelayoutmanager.AwesomeLayoutManager;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;


public class MenuActivity extends FragmentActivity implements View.OnClickListener {

    private ResideMenu resideMenu;
    private DataProvider dataProvider;
    private AwesomeLayoutManager layoutManager;
    private MenuActivity mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemFruits;
    private ResideMenuItem itemVegetables;
    private ResideMenuItem itemMinerals;
    private ResideMenuItem itemFoodRecipe;
    private ResideMenuItem itemAbout;
    private ResideMenuItem itemVitamins;
    private ResideMenuItem itemNutrition;
    private Button left_icon;
    private TextView title_text;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.residue_menu_layout);


        left_icon = (Button)findViewById(R.id.title_bar_left_menu);
        title_text = (TextView)findViewById(R.id.titlebar);
        mContext = this;
        setUpMenu();

        if (savedInstanceState == null)
           /* getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new HomeFragment(), "fragment")
                    .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();*/


      getFragmentManager()
              .beginTransaction()
              .replace(R.id.main_fragment, new HomeFragment())
              .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
              .commit();

    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
//        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip. 
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome = new ResideMenuItem(this, R.drawable.home, "Home");
        itemFruits = new ResideMenuItem(this, R.drawable.fruits, "Fruits Guide");
        itemVegetables = new ResideMenuItem(this, R.drawable.vegetables, "Vegetables Guide");
        itemAbout = new ResideMenuItem(this, R.drawable.about, "About App");
        itemFoodRecipe  =  new ResideMenuItem(this,R.drawable.foodrecipe, "Food Recipes");
        itemNutrition = new ResideMenuItem(this,R.drawable.nutrition, "Nutrition Guide");
        itemVitamins = new ResideMenuItem(this,R.drawable.vitamins, "Vitamin Sources");
        itemMinerals = new ResideMenuItem(this,R.drawable.minerals, "Mineral Sources");

        itemHome.setOnClickListener(this);
        itemFruits.setOnClickListener(this);
        itemVegetables.setOnClickListener(this);
        itemAbout.setOnClickListener(this);
        itemFoodRecipe.setOnClickListener(this);
        itemNutrition.setOnClickListener(this);
        itemVitamins.setOnClickListener(this);
        itemMinerals.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFruits, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemVegetables,ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemVitamins, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemMinerals, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemNutrition,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemFoodRecipe,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemAbout,ResideMenu.DIRECTION_RIGHT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);

        if (view == itemHome) {
            changeFragment(new HomeFragment());
           left_icon.setBackgroundResource(R.drawable.home);
            title_text.setText("Home");


        } else if (view == itemFruits) {
            changeFragment(new FruitsGuideFragment());
            left_icon.setBackgroundResource(R.drawable.fruits);
            title_text.setText("Fruits Guide");

        } else if (view == itemVegetables) {
            changeFragment(new VegetablesGuideFragment());
            left_icon.setBackgroundResource(R.drawable.vegetables);
            title_text.setText("Vegetables Guide");

        } else if (view == itemVitamins) {
            changeFragment(new VitaminSourcesFragment());
            left_icon.setBackgroundResource(R.drawable.vitamins);
            title_text.setText("Vitamin Sources");

        }else if (view == itemMinerals) {
            changeFragment(new MineralsSourcesFragment());
            left_icon.setBackgroundResource(R.drawable.minerals);
            title_text.setText("Minerals Sources");

        } else if (view == itemNutrition) {
            changeFragment(new NutritionGuideFragment());
            left_icon.setBackgroundResource(R.drawable.nutrition);
            title_text.setText("Nutrition Guide");

        } else if (view == itemFoodRecipe) {
            changeFragment(new FoodRecipesFragment());
            left_icon.setBackgroundResource(R.drawable.foodrecipe);
            title_text.setText("Food Recipes");

        } else if (view == itemAbout) {
            changeFragment(new AboutFragment());
            left_icon.setBackgroundResource(R.drawable.about);
            title_text.setText("About");

        }
        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
//            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
//            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(final Fragment targetFragment) {
        resideMenu.clearIgnoredViewList();
        if (resideMenu.isOpened())
            resideMenu.closeMenu();

        new Handler() {
        }.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment, targetFragment, "fragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();*/

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment, targetFragment)
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();

            }
        }, 600);
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu() {
        return resideMenu;
    }



}
