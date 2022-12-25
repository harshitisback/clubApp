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
import com.example.menu.modelss.upcomming;

import java.util.List;


public class UpcommingAdapter extends RecyclerView.Adapter<UpcommingAdapter.ViewHolder> {

    private final Context context;
    private final List<upcomming> upcommingList;
    String link;

    public UpcommingAdapter(Context context, List<upcomming> upcommingList) {
        this.context = context;
        this.upcommingList = upcommingList;
    }

    @NonNull
    @Override
    public UpcommingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcomming_rec, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UpcommingAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(upcommingList.get(position).getUrlImg()).into(holder.eventImg);
        holder.name.setText(upcommingList.get(position).getName());
        holder.mode.setText(upcommingList.get(position).getMode());
        holder.date.setText(upcommingList.get(position).getDate());

        upcomming up = upcommingList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = up.getLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return upcommingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView eventImg;
        TextView name, mode, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eventImg = itemView.findViewById(R.id.upcoming_events_photo);
            name = itemView.findViewById(R.id.upcoming_events_name);
            mode = itemView.findViewById(R.id.upcoming_event_mode);
            date = itemView.findViewById(R.id.upcoming_event_date);


        }
    }
}
