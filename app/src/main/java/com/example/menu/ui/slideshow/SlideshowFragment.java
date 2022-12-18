package com.example.menu.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.adapters.NewsLetterAdapter;
import com.example.menu.databinding.FragmentSlideshowBinding;
import com.example.menu.modelss.NewslLetterModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    RecyclerView newsletter_rec;
    ArrayList<NewslLetterModel> newslLetterList;
    NewsLetterAdapter newsLetterAdapter;
    FirebaseFirestore db;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        newsletter_rec = root.findViewById(R.id.newsLetter_rec);
        db = FirebaseFirestore.getInstance();

        newsletter_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        newslLetterList = new ArrayList<>();
        newsLetterAdapter = new NewsLetterAdapter(getActivity(), newslLetterList);
        newsletter_rec.setAdapter(newsLetterAdapter);

        db.collection("NewsLetter")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NewslLetterModel newslLetterModel = document.toObject(NewslLetterModel.class);
                                newslLetterList.add(newslLetterModel);
                                newsLetterAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Something wrong", Toast.LENGTH_SHORT).show();
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