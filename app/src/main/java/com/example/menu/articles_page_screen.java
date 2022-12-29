package com.example.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class articles_page_screen extends AppCompatActivity {

    RecyclerView article_rec;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_page_screen);

        // id's
        db = FirebaseFirestore.getInstance();


        ArrayList<ArticleModel> articlelist;
        ArticleAdapter articleAdapter;

        article_rec = findViewById(R.id.article_rec);
        article_rec.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        articlelist = new ArrayList<>();
         articleAdapter = new ArticleAdapter(this,  articlelist);
        article_rec.setAdapter(articleAdapter);


        db.collection("ArticleCollection")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                ArticleModel articleModel = documentSnapshot.toObject(ArticleModel.class);
                                articlelist.add(articleModel);
                                articleAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });

    }
}