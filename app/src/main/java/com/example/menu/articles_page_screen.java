package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class articles_page_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_page_screen);
    }

    public void areadmorebtn1(View view) {
        Intent i2 = new Intent(getApplicationContext(),article_description_screen.class);
        startActivity(i2);
    }

    public void upcoming(View view) {
        Intent i3 = new Intent(getApplicationContext(),upcoming_events_screen.class);
        startActivity(i3);
    }

    public void ongoingevents(View view) {
        Intent i4 = new Intent(getApplicationContext(),ongoing_events_screen.class);
        startActivity(i4);
    }

    public void blogspage(View view) {
        Intent i5 = new Intent(getApplicationContext(),blogs_screen.class);
        startActivity(i5);
    }
}