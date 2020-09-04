package com.Mo_Zarara.news_retrofitrxjava_mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.Mo_Zarara.news_retrofitrxjava_mvvm.Models.NewsModel;

import java.util.List;


@Dao
public interface NewsDao {

    @Insert
    void insert(NewsModel newsModel);

    @Update
    void update(NewsModel newsModel);

    @Delete
    void delete(NewsModel newsModel);

    @Query("DELETE From newsTable")
    void deleteAll();

    @Query("SELECT * From newsTable")
    LiveData<List<NewsModel>> getAllNews();

}
