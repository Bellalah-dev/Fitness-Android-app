package com.example.fitnesscoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewExercise extends AppCompatActivity {
    int image_id;
    String name;
    TextView timmer,title;
    ImageView imageView;
    Button btn ;
    Boolean isRunning=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);
        timmer=(TextView) findViewById(R.id.timer);
        title=(TextView) findViewById(R.id.title);
        imageView=(ImageView) findViewById(R.id.detail_image);
        btn = (Button) findViewById(R.id.btn_start);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    btn.setText("DONE");
                    new CountDownTimer(20000, 10000) {

                        @Override
                        public void onTick(long l) {
                            timmer.setText("" + l / 1000);
                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText(ViewExercise.this, "finish", Toast.LENGTH_LONG).show();
                            finish();
                        }

                    }.start();
                } else {
                    Toast.makeText(ViewExercise.this, "finish", Toast.LENGTH_LONG).show();
                    finish();
                }
                isRunning =! isRunning;
            }
        });
                timmer.setText("");
        if(getIntent() != null)
        {
            image_id=getIntent().getIntExtra("image_id",-1);
            name=getIntent().getStringExtra("name");

        }
    }
}