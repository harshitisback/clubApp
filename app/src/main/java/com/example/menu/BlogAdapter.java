package com.example.menu;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
    Context context;
    ArrayList<BlogModel> blogList;

    public BlogAdapter(Context context, ArrayList<BlogModel> blogList) {
        this.context = context;
        this.blogList = blogList;
    }



    public  class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView blogImg;
        TextView title;
        TextView date;
        TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            blogImg = itemView.findViewById(R.id.post_image);
            title = itemView.findViewById(R.id.post_title);
            time  = itemView.findViewById(R.id.post_time);
            date = itemView.findViewById(R.id.post_date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent postDetailActivity = new Intent(context, blog_description_screen.class);

                    int position = getAdapterPosition();

                    postDetailActivity.putExtra("title", blogList.get(position).getTitle());
                    postDetailActivity.putExtra("postImage", blogList.get(position).getImg());
                    postDetailActivity.putExtra("time", blogList.get(position).getTime());
                    postDetailActivity.putExtra("date", blogList.get(position).getDate());
                    postDetailActivity.putExtra("description", blogList.get(position).getDescription());


                    /*long timestamp = (long) blogList.get(position).getTimeStamp();
                    postDetailActivity.putExtra("postDate", timestamp);*/
                    context.startActivity(postDetailActivity);


                }
            });


        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_blog_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BlogModel blogModel = blogList.get(position);
//        holder.gameText.setText(model.getGameName());
        holder.title.setText(blogModel.getTitle());
        holder.date.setText(blogModel.getDate());
        holder.time.setText(blogModel.getTime());
//        Glide.with(context).load(ongoingList.get(position).getUrlImg()).into(holder.ongoingImg);
        Glide.with(context).load(blogModel.getImg()).into(holder.blogImg);
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }
}
