package com.example.fitnesscoach;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fitnesscoach.MainActivity;
import com.example.fitnesscoach.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // rediriger vers la classe principale aprés 3minutes
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                //démarrer une page
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        // handel psot delayed
        new Handler().postDelayed(runnable,3000);   }
}