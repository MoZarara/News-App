package com.Mo_Zarara.news_retrofitrxjava_mvvm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Mo_Zarara.news_retrofitrxjava_mvvm.Models.NewsModel;
import com.Mo_Zarara.news_retrofitrxjava_mvvm.R;
import com.Mo_Zarara.news_retrofitrxjava_mvvm.Ui.MainActivity;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder> {

    private List<NewsModel> list = new ArrayList<>();
    Context context;


    /*public RecyclerAdapter(List<NewsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }*/

    public class View_Holder extends RecyclerView.ViewHolder {

        public View view;
        public TextView date, time, title;
        public ImageView image;

        public View_Holder(@NonNull View itemView) {
            super(itemView);

            view = itemView;

            date = itemView.findViewById(R.id.date_id);
            time = itemView.findViewById(R.id.time_id);
            title = itemView.findViewById(R.id.title_id);
            image = itemView.findViewById(R.id.image_id);

        }



    }


    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new View_Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {

        /*NewsModel currentNews = list.get(position);
        holder.date.setText(currentNews.getPublishedAt());*/

        /*holder.date.setText(list.get(position).getPublishedAt());
        holder.time.setText(list.get(position).getPublishedAt());*/
        holder.title.setText(list.get(position).getTitle());

        Picasso.get().load(list.get(position).getUrlToImage()).
                placeholder(R.drawable.ic_launcher_background).
                into(holder.image);



        final int index = holder.getAdapterPosition();
        ((View_Holder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((ListActivity) context).openStories(dataList.get(index));

                //((MainActivity) context).openNews(context, list.get(index).getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(index).getUrl()));
                websiteIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(websiteIntent);

                //Toast.makeText(context, "nnnnn" + list.get(index).getUrl(), Toast.LENGTH_SHORT).show();


            }
        });


        String dateObject = new String(list.get(position).getPublishedAt());


        //TextView dataView = (TextView) view.findViewById(R.id.date_view);
        String formattedDate = formatDate(dateObject);
        holder.date.setText(formattedDate);

        //da.setText(formattedDate);

        //TextView timeView = (TextView) view.findViewById(R.id.time_view);
        String formatteTime = formatTime(dateObject);
        holder.time.setText(formatteTime);
        //timeView.setText(formatteTime);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setList(List<NewsModel> list, Context context) {
        this.list = list;
        this.context = context;
        notifyDataSetChanged();
    }

    private String formatDate(String dateObject) {
        String DATE_FORMAT_I = "yyyy-MM-dd'T'HH:mm:ss";
        String DATE_FORMAT_O = "dd LLL, yyyy";
/*
        formatOutput.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
        //formatOutput.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
*/

        SimpleDateFormat sourceFormat = new SimpleDateFormat(DATE_FORMAT_I);
        sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsed = null; // => Date is in UTC now
        try {
            parsed = sourceFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        TimeZone tz = TimeZone.getTimeZone("Africa/Cairo");
        SimpleDateFormat destFormat = new SimpleDateFormat(DATE_FORMAT_O);
        destFormat.setTimeZone(tz);

        String dateString = destFormat.format(parsed);

        return dateString;
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(String dateObject) {

        String DATE_FORMAT_I = "yyyy-MM-dd'T'HH:mm:ss";
        String DATE_FORMAT_O = "h:mm a";
/*
        formatOutput.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
        //formatOutput.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
*/

        SimpleDateFormat sourceFormat = new SimpleDateFormat(DATE_FORMAT_I);
        sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsed = null; // => Date is in UTC now
        try {
            parsed = sourceFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        TimeZone tz = TimeZone.getTimeZone("Africa/Cairo");
        SimpleDateFormat destFormat = new SimpleDateFormat(DATE_FORMAT_O);
        destFormat.setTimeZone(tz);

        String dateString = destFormat.format(parsed);

        return dateString;
    }

}
