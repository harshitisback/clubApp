package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class upcoming_events_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events_screen);
    }

    public void uermbtn1(View view) {
        Intent i10 = new Intent(getApplicationContext(),blog_description_screen.class);
        startActivity(i10);
    }
}

