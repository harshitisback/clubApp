package com.example.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.menu.adapters.OngoingAdapter;
import com.example.menu.adapters.UpcommingAdapter;
import com.example.menu.modelss.ongoing;
import com.example.menu.modelss.upcomming;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class test extends Fragment {

    RecyclerView rec_upcomming;
    List<upcomming>  upcommingList;
    UpcommingAdapter upcommingAdapter;
    FirebaseFirestore db;




    public test() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = FirebaseFirestore.getInstance();
       View root =  inflater.inflate(R.layout.fragment_test, container, false);

       rec_upcomming = root.findViewById(R.id.upcomming_rec_test);
        rec_upcomming.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        upcommingList = new ArrayList<>();
        upcommingAdapter = new UpcommingAdapter(getActivity(),upcommingList);
        rec_upcomming.setAdapter(upcommingAdapter);

        db.collection("UpcommingEvents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                upcomming upcomming = document.toObject(upcomming.class);
                                upcommingList.add(upcomming);
                                upcommingAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });


        RecyclerView ongoing_rec;
        List<ongoing>  ongoingList;
        OngoingAdapter ongoingAdapter;

        ongoing_rec = root.findViewById(R.id.onging_test_rec);
        ongoing_rec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
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
                            Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });




       return root;
    }
}