package com.example.fitnesscoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesscoach.Adapter.RecyclerViewAdapter;
import com.example.fitnesscoach.R;
import com.example.fitnesscoach.model.EXercise;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    List<EXercise> list= new ArrayList<>();
    RecyclerView.LayoutManager RecycleManager;
    RecyclerView Recycle;
    RecyclerViewAdapter RecycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initData();
        Recycle=(RecyclerView) findViewById(R.id.list);
        RecycleAdapter=new RecyclerViewAdapter(list,getBaseContext());
        RecycleManager=new LinearLayoutManager(this);
        Recycle.setLayoutManager(RecycleManager);
        Recycle.setAdapter(RecycleAdapter);
    }

    private void initData() {
        list.add(new EXercise(R.drawable.easy_yoga,"Easy Pose"));
        list.add(new EXercise(R.drawable.yoga,"Cobra Pose"));
        list.add(new EXercise(R.drawable.images,"Downward Dog Pose"));
        list.add(new EXercise(R.drawable.plank,"Plank Pose"));
        list.add(new EXercise(R.drawable.child,"Child Pose"));
        list.add(new EXercise(R.drawable.half,"half pigeon Pose"));
        list.add(new EXercise(R.drawable.bow,"Bow Pose"));
        list.add(new EXercise(R.drawable.cow,"Cow Pose"));
        list.add(new EXercise(R.drawable.hero,"Hero Pose"));
        list.add(new EXercise(R.drawable.crescent,"Crescent Pose"));
        list.add(new EXercise(R.drawable.knee,"knee to chest Pose"));
        list.add(new EXercise(R.drawable.upward,"upward dog Pose"));
        list.add(new EXercise(R.drawable.warrior,"Warrior Pose"));
        list.add(new EXercise(R.drawable.camel,"Camel Pose"));
        list.add(new EXercise(R.drawable.twist,"uWarrior Pose"));
        list.add(new EXercise(R.drawable.standing,"Standing Pose"));





    }
}