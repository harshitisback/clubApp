package com.example.menu.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.menu.MainActivity;
import com.example.menu.R;
import com.example.menu.adapters.UpcommingAdapter;
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
    FirebaseFirestore db;


    public HomeScreen() {

    }

    List<upcomming> upcommingList;
    UpcommingAdapter upcommingAdapter;

    TextView textView_1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        db = FirebaseFirestore.getInstance();
        upcom_rec = view.findViewById(R.id.rec_upcome);

        // Inflate the layout for this fragment


        ImageView profile_pic = (ImageView) view.findViewById(R.id.profile_pic);


//
        upcom_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        upcommingList = new ArrayList<>();
        upcommingAdapter = new UpcommingAdapter(getActivity(), upcommingList);
        upcom_rec.setAdapter(upcommingAdapter);
//
//        db.collection("UpcommingEvents")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                upcomming up = document.toObject(upcomming.class);
//                                upcommingList.add(up);
//                                upcommingAdapter.notifyDataSetChanged();
//                            }
//                        } else {
//                            Toast.makeText(getActivity(), "Error loding the events", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });

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