package com.example.menu;

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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    Context context;
    ArrayList<ArticleModel> articleList;

    public ArticleAdapter(Context context, ArrayList<ArticleModel> articleList) {
        this.context = context;
        this.articleList = articleList;
    }



    public  class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView articleImg;
        TextView title;
      //  TextView date;
        TextView time;
        TextView name;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            articleImg = itemView.findViewById(R.id.post_image);
            title = itemView.findViewById(R.id.post_title);
            time  = itemView.findViewById(R.id.post_time);
            name = itemView.findViewById(R.id.post_editor_name);
            description = itemView.findViewById(R.id.post_desc);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent postDetailActivity = new Intent(context, article_description_screen.class);

                    int position = getAdapterPosition();

                    postDetailActivity.putExtra("title", articleList.get(position).getTitle());
                    postDetailActivity.putExtra("postImage", articleList.get(position).getImg());
                  //  postDetailActivity.putExtra("time", articleList.get(position).getTime());
                    postDetailActivity.putExtra("name", articleList.get(position).getName());
                    postDetailActivity.putExtra("description", articleList.get(position).getDescription());


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
                .inflate(R.layout.custom_article_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleModel articleModel = articleList.get(position);
//        holder.gameText.setText(model.getGameName());
        holder.title.setText(articleModel.getTitle());
        holder.name.setText(articleModel.getName());
        holder.time.setText(articleModel.getTime());
        holder.description.setText(articleModel.getDescription());
//        Glide.with(context).load(ongoingList.get(position).getUrlImg()).into(holder.ongoingImg);
        Glide.with(context).load(articleModel.getImg()).into(holder.articleImg);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}


