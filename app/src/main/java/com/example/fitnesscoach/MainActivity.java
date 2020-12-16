package com.example.fitnesscoach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     Button btn,btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd=findViewById(R.id.btn_ad);
        btn=findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,advices.class);
                startActivity(i);

            }
        });


    }

    public void editerProfil(View view) {
            Intent intent=new Intent(getApplicationContext(), Profil.class);
            startActivity(intent);
    }

    public void paramétrer(View view) {
        Intent intent=new Intent(getApplicationContext(),Settings.class);
        startActivity(intent);
    }

    public void Conseiller(View view) {
    }



}