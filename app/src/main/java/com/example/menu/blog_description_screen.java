package com.example.menu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;;

public class blog_description_screen extends AppCompatActivity {

    ImageView imgpost;
    TextView txtPostDesc, txtPostdatename, txtPostTitle, txtPosttimename;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_description_screen);

        imgpost = findViewById(R.id.post_detail_img);
        txtPostdatename = findViewById(R.id.post_detail_date_name);
        txtPosttimename = findViewById(R.id.post_detail_time_name);
        txtPostDesc = findViewById(R.id.post_detail_desc);
        txtPostTitle = findViewById(R.id.name_blog);



        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        String postImage = getIntent().getExtras().getString("postImage");
        Glide.with(this).load(postImage).into(imgpost);

        String postTitle = getIntent().getExtras().getString("title");
        txtPostTitle.setText(postTitle);

        String postDescription = getIntent().getExtras().getString("description");
        txtPostDesc.setText(postDescription);

        String postTime = getIntent().getExtras().getString("time");
        txtPosttimename.setText(postTime);

        String postDate = getIntent().getExtras().getString("date");
        txtPostdatename.setText(postDate);





    }


}