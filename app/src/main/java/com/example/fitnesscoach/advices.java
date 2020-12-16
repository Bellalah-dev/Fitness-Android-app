package com.example.fitnesscoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class advices extends AppCompatActivity {
    Button bcobra,beasy,bdog,bplank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advices);
        bcobra=findViewById(R.id.howcobra);
        beasy=findViewById(R.id.howeasy);
        bdog=findViewById(R.id.howdowndog);
        bplank=findViewById(R.id.howplank);

        //how to cobra listener
        bcobra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(advices.this,how_to_cobra.class);
                startActivity(i);

            }
        });

        //how to easy pose listener
        beasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(advices.this,how_to_easy_pose.class);
                startActivity(i);

            }
        });

        //how to down dog listener
        bdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(advices.this,how_to_down_dog.class);
                startActivity(i);

            }
        });

        //how to plank pose listener
        bplank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(advices.this,how_to_plank_pose.class);
                startActivity(i);

            }
        });

    }
}