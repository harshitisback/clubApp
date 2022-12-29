package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class blogs_screen extends AppCompatActivity {

    RecyclerView blog_rec;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs_screen);

        // id's
        db = FirebaseFirestore.getInstance();


        ArrayList<BlogModel> bloglist;
        BlogAdapter blogAdapter;

        blog_rec = findViewById(R.id.blog_rec);
        blog_rec.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        bloglist = new ArrayList<>();
        //   bloglist.add(new BlogModel("https://firebasestorage.googleapis.com/v0/b/menu-c7a13.appspot.com/o/testimg.png?alt=media&token=49d93405-f40f-45d9-b76d-9673dea47f2a","25m","RO","2-3-22","The description is here"));
        blogAdapter = new BlogAdapter(this, bloglist);
        blog_rec.setAdapter(blogAdapter);



        db.collection("BlogCollection")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @SuppressLint("NotifyDataSetChanged")
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if(task.isSuccessful()){
                for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                    BlogModel blogModel = documentSnapshot.toObject(BlogModel.class);
                    bloglist.add(blogModel);
                    blogAdapter.notifyDataSetChanged();
                }
            }
        }
    });


}
}