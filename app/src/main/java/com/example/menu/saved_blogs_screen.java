package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class saved_blogs_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_blogs_screen);
    }

    public void registeredevents(View view) {
        Intent i6 = new Intent(getApplicationContext(),registered_events_screen.class);
        startActivity(i6);
    }

    public void pastevents(View view) {

        Intent i7 = new Intent(getApplicationContext(),past_events_screen.class);
        startActivity(i7);
    }
}