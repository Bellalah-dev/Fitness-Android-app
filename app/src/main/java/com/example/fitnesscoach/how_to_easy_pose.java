package com.example.fitnesscoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class how_to_easy_pose extends AppCompatActivity {
    ImageView howtoeasy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_easy_pose);
        howtoeasy=findViewById(R.id.howtoeasy);
    }
}