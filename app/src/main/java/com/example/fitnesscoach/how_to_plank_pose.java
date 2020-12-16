package com.example.fitnesscoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class how_to_plank_pose extends AppCompatActivity {
    ImageView howtoplank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_plank_pose);
        howtoplank=findViewById(R.id.howtoplank);
    }
}