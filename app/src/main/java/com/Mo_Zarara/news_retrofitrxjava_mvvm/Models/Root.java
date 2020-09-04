package com.Mo_Zarara.news_retrofitrxjava_mvvm.Models;

import java.util.List;

public class Root {

    private List<NewsModel> articles;

    public Root(List<NewsModel> articles) {
        this.articles = articles;
    }

    public List<NewsModel> getArticles() {
        return articles;
    }

}
