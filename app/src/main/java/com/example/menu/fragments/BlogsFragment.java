package com.example.menu.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu.ArticleAdapter;
import com.example.menu.ArticleModel;
import com.example.menu.BlogAdapter;
import com.example.menu.BlogModel;
import com.example.menu.R;
import com.example.menu.databinding.FragmentGalleryBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;


public class BlogsFragment extends Fragment {

    RecyclerView blog_rec;
    ArrayList<BlogModel> bloglist;
    BlogAdapter blogAdapter;
    FirebaseFirestore db;


    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        View root = inflater.inflate(R.layout.activity_blogs_screen, container, false);

        blog_rec= root.findViewById(R.id.blog_rec);

        db = FirebaseFirestore.getInstance();


        blog_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        bloglist = new ArrayList<>();
        //   bloglist.add(new BlogModel("https://firebasestorage.googleapis.com/v0/b/menu-c7a13.appspot.com/o/testimg.png?alt=media&token=49d93405-f40f-45d9-b76d-9673dea47f2a","25m","RO","2-3-22","The description is here"));
        blogAdapter = new BlogAdapter(getActivity(), bloglist);
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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}