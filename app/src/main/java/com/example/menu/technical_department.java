package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.menu.fragments.AboutUs;

public class technical_department extends AppCompatActivity {

    ImageView back;
    ImageView team_member_1, team_member_2;
    CardView lead_1, lead_2, lead_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_department);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(technical_department.this, AboutUs.class);
                startActivity(i4);
            }
        });

        team_member_1 = findViewById(R.id.team_members_1);
        team_member_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(technical_department.this, member_description_1_screen.class);
                startActivity(i5);
            }
        });

        team_member_2 = findViewById(R.id.team_members_2);
        team_member_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(technical_department.this, member_description_2_screen.class);
                startActivity(i6);
            }
        });

        lead_1 = findViewById(R.id.lead_card_view_1);
        lead_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(technical_department.this, our_lead_description_1_screen.class);
                startActivity(i7);
            }
        });

        lead_2 = findViewById(R.id.lead_card_view_2);
        lead_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(technical_department.this, our_lead_description_2_screen.class);
                startActivity(i8);
            }
        });

        lead_3 = findViewById(R.id.lead_card_view_3);
        lead_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i9 = new Intent(technical_department.this, our_lead_description_3_screen.class);
                startActivity(i9);
            }
        });


//        -------------------------------- Dialog :--------------------------------------------------------------------

//                Dialog dialog = new Dialog(null);
//                dialog.setContentView(R.layout.faculty_coordinator_description_1_screen);

//        lead_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.show();
//            }
//        });


    }


}