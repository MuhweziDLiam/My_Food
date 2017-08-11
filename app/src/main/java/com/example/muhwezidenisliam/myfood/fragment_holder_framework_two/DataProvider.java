package com.example.muhwezidenisliam.myfood.fragment_holder_framework_two;

import java.util.List;

public interface DataProvider {
    List<Article> getArticles(int limit, String json);
}
