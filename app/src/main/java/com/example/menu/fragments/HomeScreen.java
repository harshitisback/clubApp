package com.example.menu.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.menu.R;
import com.example.menu.adapters.OngoingAdapter;
import com.example.menu.adapters.PastAdapter;
import com.example.menu.adapters.UpcommingAdapter;
import com.example.menu.modelss.ongoing;
import com.example.menu.modelss.past;
import com.example.menu.modelss.upcomming;
import com.example.menu.profile_page_screen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends Fragment {

    RecyclerView rec_upcomming;
    List<upcomming> upcommingList;
    UpcommingAdapter upcommingAdapter;

    FirebaseFirestore db;


    public HomeScreen() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = FirebaseFirestore.getInstance();
        View root = inflater.inflate(R.layout.fragment_home_screen, container, false);

        ImageView profile_pic = (ImageView) root.findViewById(R.id.profile_pic_home_screen);

        // Upcoming Events
        rec_upcomming = root.findViewById(R.id.upcomming_rec);
        rec_upcomming.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        upcommingList = new ArrayList<>();
        upcommingAdapter = new UpcommingAdapter(getActivity(), upcommingList);
        rec_upcomming.setAdapter(upcommingAdapter);

        db.collection("UpcommingEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                upcomming upcomming = document.toObject(upcomming.class);
                                upcommingList.add(upcomming);
                                upcommingAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });


        // Ongoing Events
        RecyclerView ongoing_rec;
        List<ongoing> ongoingList;
        OngoingAdapter ongoingAdapter;

        ongoing_rec = root.findViewById(R.id.ongoing_rec);
        ongoing_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        ongoingList = new ArrayList<>();
        ongoingAdapter = new OngoingAdapter(getActivity(), ongoingList);
        ongoing_rec.setAdapter(ongoingAdapter);

        db.collection("OngoingEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ongoing ongoing = document.toObject(ongoing.class);
                                ongoingList.add(ongoing);
                                ongoingAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });


        // Past Events
        RecyclerView past_rec;
        List<past> pastList;
        PastAdapter pastAdapter;

        past_rec = root.findViewById(R.id.past_rec);
        past_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        pastList = new ArrayList<>();
        pastAdapter = new PastAdapter(getActivity(), pastList);
        past_rec.setAdapter(pastAdapter);

        db.collection("PastEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                past past = document.toObject(past.class);
                                pastList.add(past);
                                pastAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });


        // Profile Pic
        profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), profile_page_screen.class);
                startActivity(intent);
            }
        });


        return root;

    }

}
