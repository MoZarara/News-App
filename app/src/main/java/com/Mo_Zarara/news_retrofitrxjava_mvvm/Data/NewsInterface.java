package com.Mo_Zarara.news_retrofitrxjava_mvvm.Data;

import com.Mo_Zarara.news_retrofitrxjava_mvvm.Models.Root;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface NewsInterface {

    @GET("v2/top-headlines?country=eg&apiKey=9441f8222a0049648c09db8ef0c9f6b7")
    Observable<Root> getNews();
}
