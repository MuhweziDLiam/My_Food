package com.example.muhwezidenisliam.myfood.fragment_holder_framework_three;

import android.content.Context;

import com.example.muhwezidenisliam.myfood.R;
import com.example.muhwezidenisliam.myfood.fragment_holder_framework_three.Article;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FakeDataProvider implements DataProvider {

    private final Context context;

    int the_resource;

    public FakeDataProvider(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public List<Article> getArticles(int limit, String json) {
        if(json.equals("four"))
        {
            the_resource = R.raw.data_four;

        }
        else
        {
            the_resource = R.raw.data_five;
        }
        Gson gson = new Gson();
        Article[] articles = gson.fromJson(new InputStreamReader(context.getResources().openRawResource(the_resource)), Article[].class);
        ArrayList<Article> list = new ArrayList<>();
        int max = limit == 0 ? articles.length * 8 : Math.min(articles.length * 8, limit);
        for (int i = 0; i < max; i++) {
            list.add(articles[i % articles.length]);
        }
        return list;
    }

}
