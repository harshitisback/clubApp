package com.example.menu.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menu.R;
import com.example.menu.editing_department;
import com.example.menu.faculty_coordinator_description_1_screen;
import com.example.menu.faculty_coordinator_description_2_screen;
import com.example.menu.profile_page_screen;
import com.example.menu.technical_department;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutUs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutUs extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutUs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutUs.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutUs newInstance(String param1, String param2) {
        AboutUs fragment = new AboutUs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).hide();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_home_screen, container, false);

        View view = inflater.inflate(R.layout.fragment_about_us_initial, container, false);

        ImageView Sandeep_Sahu_photo = (ImageView) view.findViewById(R.id.Sandeep_Sahu_photo);

        Sandeep_Sahu_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), faculty_coordinator_description_1_screen.class);
                startActivity(i1);
            }
        });

        ImageView Atul_Aman_photo = (ImageView) view.findViewById(R.id.Atul_Aman_photo);

        Atul_Aman_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getActivity(), faculty_coordinator_description_2_screen.class);
                startActivity(i2);
            }
        });


        TextView technical_team  =(TextView) view.findViewById(R.id.tech_team);

        technical_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent( getActivity() , technical_department.class);
                startActivity( i3 );
            }
        });

        TextView editing_team  =(TextView) view.findViewById(R.id.edit_team);

        editing_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent( getActivity() , editing_department.class);
                startActivity( i3 );
            }
        });

        return view;

    }
}

