package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.menu.adapters.ViewAllAdapter;
import com.example.menu.modelss.ViewAllModelPast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ViewAllPastEvents extends AppCompatActivity {

    // variables
    RecyclerView viewAllRec;
    ArrayList<ViewAllModelPast> modelPastArrayList;
    ViewAllAdapter viewAllAdapter;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_past_events);

        db = FirebaseFirestore.getInstance();
        viewAllRec = findViewById(R.id.viewAllpastrec);

        viewAllRec.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        modelPastArrayList = new ArrayList<>();
        viewAllAdapter = new ViewAllAdapter(getApplicationContext(), modelPastArrayList);
        viewAllRec.setAdapter(viewAllAdapter);

        db.collection("ViewAllPast")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ViewAllModelPast viewAllModelPast = document.toObject(ViewAllModelPast.class);
                                modelPastArrayList.add(viewAllModelPast);
                                viewAllAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(ViewAllPastEvents.this, "No Event is present in this list", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}