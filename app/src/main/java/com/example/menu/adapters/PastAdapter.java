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
import com.example.menu.modelss.past;

import java.util.List;


public class PastAdapter extends RecyclerView.Adapter<PastAdapter.ViewHolder> {

    private final Context context;
    private final List<past> pastList;

    public PastAdapter(Context context, List<past> pastList) {
        this.context = context;
        this.pastList = pastList;
    }

    @NonNull
    @Override
    public PastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.past_rec, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(pastList.get(position).getUrlImg()).into(holder.pastImg);
        holder.name.setText(pastList.get(position).getName());
        holder.mode.setText(pastList.get(position).getMode());
        holder.date.setText(pastList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return pastList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pastImg;
        TextView name, mode, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pastImg = itemView.findViewById(R.id.past_events_photo);
            name = itemView.findViewById(R.id.past_event_name);
            mode = itemView.findViewById(R.id.past_event_mode);
            date = itemView.findViewById(R.id.past_event_date);


        }
    }
}
