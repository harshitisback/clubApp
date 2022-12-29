package com.example.menu.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.ArticleAdapter;
import com.example.menu.ArticleModel;
import com.example.menu.R;
import com.example.menu.adapters.NewsLetterAdapter;
import com.example.menu.databinding.FragmentGalleryBinding;
import com.example.menu.modelss.NewslLetterModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    RecyclerView article_rec;
    ArrayList<ArticleModel> articlelist;
    ArticleAdapter articleAdapter;
    FirebaseFirestore db;

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        View root = inflater.inflate(R.layout.activity_articles_page_screen, container, false);

        article_rec= root.findViewById(R.id.article_rec);

        db = FirebaseFirestore.getInstance();

        article_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        articlelist = new ArrayList<>();
        articleAdapter = new ArticleAdapter(getActivity(),  articlelist);
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


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}