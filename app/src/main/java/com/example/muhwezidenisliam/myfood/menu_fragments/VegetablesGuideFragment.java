package com.example.muhwezidenisliam.myfood.menu_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.muhwezidenisliam.myfood.R;
import com.example.muhwezidenisliam.myfood.fragment_holder_framework_three.Article;
import com.example.muhwezidenisliam.myfood.fragment_holder_framework_three.ArticleAdapter;
import com.example.muhwezidenisliam.myfood.fragment_holder_framework_three.DataProvider;
import com.example.muhwezidenisliam.myfood.fragment_holder_framework_three.FakeDataProvider;
import com.forcelain.awesomelayoutmanager.AwesomeLayoutManager;

import java.util.List;

/**
 * Created by Muhwezi Denis Liam on 4/1/2017.
 */
public class VegetablesGuideFragment extends Fragment {
    private DataProvider dataProvider;
    private AwesomeLayoutManager layoutManager;
    private ArticleAdapter adapter;
    private RecyclerView recyclerView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pages,container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new AwesomeLayoutManager();
        layoutManager.setScaleFactor(0.5f);
        layoutManager.setPagination(true);
        layoutManager.setPageHeightFactor(.7f);
        layoutManager.setTransitionDuration(450);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ArticleAdapter();
        recyclerView.setAdapter(adapter);
        dataProvider = new FakeDataProvider(getActivity());
        List<Article> articles = dataProvider.getArticles(0,"four");
        adapter.setArticles(articles);
        adapter.setItemClickListener(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos) {
                layoutManager.openItem(pos);
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (layoutManager.getOrientation() == AwesomeLayoutManager.Orientation.HORIZONTAL) {
                            layoutManager.close();
                        } else {

                        }

                        return true;
                    }
                }
                return false;
            }
        });
        // TODO Auto-generated method stub
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_one:
                adapter.setArticles(dataProvider.getArticles(1,"four"));
                return true;
            case R.id.menu_item_two:
                adapter.setArticles(dataProvider.getArticles(2,"four"));
                return true;
            case R.id.menu_item_many:
                adapter.setArticles(dataProvider.getArticles(0,"four"));
                return true;
            case R.id.menu_goto_first:
                recyclerView.scrollToPosition(0);
                return true;
            case R.id.menu_goto_last:
                recyclerView.scrollToPosition(adapter.getItemCount() - 1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        dataProvider = null;
        super.onDestroyView();
    }
}
