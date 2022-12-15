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
import com.example.menu.modelss.ongoing;
import java.util.List;


public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.ViewHolder> {

    private final Context context;
    private final List<ongoing> ongoingList;

    public OngoingAdapter(Context context, List<ongoing> ongoingList) {
        this.context = context;
        this.ongoingList = ongoingList;
    }

    @NonNull
    @Override
    public OngoingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoing_rec, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(ongoingList.get(position).getUrlImg()).into(holder.ongoingImg);
        holder.name.setText(ongoingList.get(position).getName());
        holder.mode.setText(ongoingList.get(position).getMode());
        holder.date.setText(ongoingList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return ongoingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ongoingImg;
        TextView name, mode, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ongoingImg = itemView.findViewById(R.id.ongoing_events_photo);
            name = itemView.findViewById(R.id.ongoing_event_name);
            mode = itemView.findViewById(R.id.ongoing_mode);
            date = itemView.findViewById(R.id.ongoing_date);


        }
    }
}
