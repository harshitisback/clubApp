package com.example.menu.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.menu.modelss.ViewAllModelPast;

import java.util.ArrayList;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {

    String link;

    Context context;
    ArrayList<ViewAllModelPast> viewAllModelPastArrayList;

    public ViewAllAdapter(Context context, ArrayList<ViewAllModelPast> viewAllModelPastArrayList) {
        this.context = context;
        this.viewAllModelPastArrayList = viewAllModelPastArrayList;
    }

    @NonNull
    @Override
    public ViewAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewall_past_events_card,parent,false);

        return  new ViewAllAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAllAdapter.ViewHolder holder, int position) {

        ViewAllModelPast viewAllModelPast = viewAllModelPastArrayList.get(position);
        holder.name.setText(viewAllModelPast.getName());
        holder.date.setText(viewAllModelPast.getDate());
        holder.mode.setText(viewAllModelPast.getMode());
        Glide.with(context).load(viewAllModelPast.getUrlImg()).into(holder.viewAllImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = viewAllModelPast.getLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewAllModelPastArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView viewAllImage;
        TextView name, mode, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewAllImage = itemView.findViewById(R.id.viewAll_past_img);
            name = itemView.findViewById(R.id.viewAll_name);
            mode = itemView.findViewById(R.id.viewAll_mode);
            date = itemView.findViewById(R.id.viewAllPast_date);
        }
    }
}
