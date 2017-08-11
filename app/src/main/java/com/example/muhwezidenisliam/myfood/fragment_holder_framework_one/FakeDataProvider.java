package com.example.muhwezidenisliam.myfood.fragment_holder_framework_one;

import android.content.Context;

import com.example.muhwezidenisliam.myfood.R;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FakeDataProvider implements DataProvider {

    private final Context context;

    public FakeDataProvider(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public List<Article> getArticles(int limit) {
        Gson gson = new Gson();
        Article[] articles = gson.fromJson(new InputStreamReader(context.getResources().openRawResource(R.raw.data_one)), Article[].class);
        ArrayList<Article> list = new ArrayList<>();
        int max = limit == 0 ? articles.length * 5 : Math.min(articles.length * 5, limit);
        for (int i = 0; i < max; i++) {
            list.add(articles[i % articles.length]);
        }
        return list;
    }

}
