package com.Mo_Zarara.news_retrofitrxjava_mvvm.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Mo_Zarara.news_retrofitrxjava_mvvm.Adapter.RecyclerAdapter;
import com.Mo_Zarara.news_retrofitrxjava_mvvm.Models.NewsModel;
import com.Mo_Zarara.news_retrofitrxjava_mvvm.Models.Root;
import com.Mo_Zarara.news_retrofitrxjava_mvvm.MyViewModel;
import com.Mo_Zarara.news_retrofitrxjava_mvvm.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    //List<NewsModel> list = new ArrayList<>();

    MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);



        mViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mViewModel.getNewsLiveData();
        mViewModel.getAllNews().observe(this, new Observer<List<NewsModel>>() {
            @Override
            public void onChanged(List<NewsModel> newsModels) {
                if (!newsModels.isEmpty())
                    adapter.setList(newsModels, getApplicationContext());


                /*for (int i = 0; i < newsModels.size(); i++) {
                    NewsModel newsModel = new NewsModel(newsModels.get(i).getAuthor(),
                            newsModels.get(i).getTitle(),
                            newsModels.get(i).getDescription(),
                            newsModels.get(i).getUrl(),
                            newsModels.get(i).getUrlToImage(),
                            newsModels.get(i).getPublishedAt());


                    newsModel.setId(i);
                    mViewModel.insert(newsModel);
                }*/



            }
        });







        //adapter = new RecyclerAdapter(list, this);





        /*mViewModel.liveData.observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                if (root != null) {
                    list = root.getArticles();

                    for (int i = 0; i < list.size(); i++) {
                        adapter.setList(list, getApplicationContext());

                        //adapter = new RecyclerAdapter(list, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        //adapter.notifyDataSetChanged();
                    }

                }


            }
        });*/


    }

    /*public void openNews(Context context, String posation) {

        Uri newsUri = Uri.parse(posation);
        //adapter.getItemId((int) posation);
        //Toast.makeText(context, "mainactivity" + posation, Toast.LENGTH_SHORT).show();
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
        startActivity(websiteIntent);
    }*/


}
