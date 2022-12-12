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
import com.example.menu.modelss.upcomming;
import com.squareup.picasso.Picasso;

import java.util.List;


public class UpcommingAdapter extends RecyclerView.Adapter<UpcommingAdapter.ViewHolder> {

    private Context context;
    private List<upcomming> upcommingList;

    public UpcommingAdapter(Context context, List<upcomming> upcommingList) {
        this.context = context;
        this.upcommingList = upcommingList;
    }

    @NonNull
    @Override
    public UpcommingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcomming_rec,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UpcommingAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(upcommingList.get(position).getUrlImg()).into(holder.eventImg);
        holder.name.setText(upcommingList.get(position).getName());
        holder.mode.setText(upcommingList.get(position).getMode());
        holder.date.setText(upcommingList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return upcommingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView eventImg;
        TextView name, mode, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eventImg = itemView.findViewById(R.id.upcoming_events_photo);
            name = itemView.findViewById(R.id.upcoming_events_name);
            mode = itemView.findViewById(R.id.mode);
            date = itemView.findViewById(R.id.date);



        }
    }
}
