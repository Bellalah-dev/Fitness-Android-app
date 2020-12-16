package com.example.fitnesscoach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesscoach.Interface.ItemClickListener;
import com.example.fitnesscoach.R;
import com.example.fitnesscoach.ViewExercise;
import com.example.fitnesscoach.model.EXercise;

import java.util.List;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
   public ImageView img;
    public TextView text;
    private ItemClickListener item;
    private View itemView;



    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        img=(ImageView) itemView.findViewById(R.id.img);
        text=(TextView) itemView.findViewById(R.id.text_card);
        itemView.setOnClickListener(this);
    }
    public void setItemOnclickListener(ItemClickListener itemClickListener)
    {
        item=itemClickListener;
    }

    @Override
    public void onClick(View view) {
  item.onClick(view,getAdapterPosition());
    }
}
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<EXercise> eXerciseList;
    private Context contexte;

    public RecyclerViewAdapter(List<EXercise> eXerciseList,Context contexte) {
        this.contexte = contexte;
        this.eXerciseList=eXerciseList;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_exercise,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
      holder.img.setImageResource(eXerciseList.get(position).getImage_id());
      holder.text.setText(eXerciseList.get(position).getName());
      holder.setItemOnclickListener(new ItemClickListener() {
          @Override
          public void onClick(View view, int position) {
           Intent intent;
              intent = new Intent(contexte, ViewExercise.class);
              intent.putExtra("image_id",eXerciseList.get(position).getImage_id());
           intent.putExtra("name",eXerciseList.get(position).getName());
           contexte.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return eXerciseList.size();
    }
}
