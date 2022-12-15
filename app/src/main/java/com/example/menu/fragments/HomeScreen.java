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
import android.widget.TextView;
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
import java.util.Objects;

public class HomeScreen extends Fragment {

    RecyclerView upcom_rec;
    RecyclerView on_rec;
    RecyclerView past_rec;

    FirebaseFirestore db;


    public HomeScreen() {

    }

    List<upcomming> upcommingList;
    UpcommingAdapter upcommingAdapter;

    List<ongoing> ongoingList;
    OngoingAdapter ongoingAdapter;

    List<past> pastList;
    PastAdapter pastAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        db = FirebaseFirestore.getInstance();
        upcom_rec = view.findViewById(R.id.rec_upcome);
        on_rec = view.findViewById(R.id.rec_ongoing);
        past_rec = view.findViewById(R.id.rec_past);

        ImageView profile_pic = (ImageView) view.findViewById(R.id.profile_pic_home_screen);


        // upcoming events ->
        upcom_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        upcommingList = new ArrayList<>();
        upcommingAdapter = new UpcommingAdapter(getActivity(), upcommingList);
        upcom_rec.setAdapter(upcommingAdapter);

        db.collection("UpcommingEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                upcomming up = document.toObject(upcomming.class);
                                upcommingList.add(up);
                                upcommingAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        // ongoing events ->
        on_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        ongoingList = new ArrayList<>();
        ongoingAdapter = new OngoingAdapter(getActivity(), ongoingList);
        on_rec.setAdapter(ongoingAdapter);

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
                            Toast.makeText(getActivity(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        // Past event ->
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
                            Toast.makeText(getActivity(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), profile_page_screen.class);
                startActivity(intent);
            }
        });

        return view;

    }

}
