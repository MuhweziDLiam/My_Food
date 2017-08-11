package com.example.muhwezidenisliam.myfood.fragment_holder_framework_three;

import com.example.muhwezidenisliam.myfood.fragment_holder_framework_three.Article;

import java.util.List;

public interface DataProvider {
    List<Article> getArticles(int limit, String json);
}
