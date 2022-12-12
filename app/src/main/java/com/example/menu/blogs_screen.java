package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class blogs_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs_screen);
    }

    public void bookmarkbtn2(View view) {
        Intent i5 = new Intent(getApplicationContext(),saved_blogs_screen.class);
        startActivity(i5);
    }

}