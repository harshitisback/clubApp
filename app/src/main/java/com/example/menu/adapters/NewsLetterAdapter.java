package com.example.menu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.menu.R;
import com.example.menu.modelss.NewslLetterModel;

import java.util.ArrayList;

public class NewsLetterAdapter extends RecyclerView.Adapter<NewsLetterAdapter.ViewHolder> {
    Context context;
    ArrayList<NewslLetterModel> newsList;
//    public ItemClickListener clickListener;

    public NewsLetterAdapter(Context context, ArrayList<NewslLetterModel> newsList) {
        this.context = context;
        this.newsList = newsList;
    }






    public  class  ViewHolder extends RecyclerView.ViewHolder  {

        ImageView newsLetter_img;
        TextView name;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsLetter_img = itemView.findViewById(R.id.newsLetter_img);
            name = itemView.findViewById(R.id.newsLetter_name);
            date = itemView.findViewById(R.id.newsLetter_date);

        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_newsl_card,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            NewslLetterModel newslLetterModel = newsList.get(position);
            holder.name.setText(newslLetterModel.getName());
            holder.date.setText(newslLetterModel.getDate());
            Glide.with(context).load(newslLetterModel.getImg()).into(holder.newsLetter_img);

//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//
//                }
//            });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }










}
