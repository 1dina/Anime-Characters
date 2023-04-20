package com.example.animecharacters;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AC_recycleViewAdaptar extends RecyclerView.Adapter<AC_recycleViewAdaptar.MyViewHolder> {
    Context context;
    private int lastposition =-1;
    ArrayList<animeCharacterModel>myAnimeList;
   private final RecycleViewInterface recycleViewInterface;
    public AC_recycleViewAdaptar(Context context,ArrayList<animeCharacterModel>myAnimeList,RecycleViewInterface recycleViewInterface){
        this.context=context;
        this.myAnimeList=myAnimeList;
        this.recycleViewInterface=recycleViewInterface;

    }

    @NonNull
    @Override
    public AC_recycleViewAdaptar.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row,parent,false);

        return new AC_recycleViewAdaptar.MyViewHolder(view,recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AC_recycleViewAdaptar.MyViewHolder holder, int position) {
        holder.tvCharName.setText(myAnimeList.get(position).nameOfCharacter);
        holder.tvAnimeName.setText(myAnimeList.get(position).nameOfAnime);
        holder.Character.setImageResource(myAnimeList.get(position).Images);
        //setAnimation(holder.itemView,position);


    }

    @Override
    public int getItemCount() {
        return myAnimeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCharName;
        TextView tvAnimeName;
        ImageView Character;
        public MyViewHolder(@NonNull View itemView,RecycleViewInterface recycleViewInterface) {
            super(itemView);
            tvCharName = itemView.findViewById(R.id.textView);
         tvAnimeName = itemView.findViewById(R.id.textView2);
             Character =itemView.findViewById(R.id.imageView);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (recycleViewInterface != null) {
                         int pos= getAdapterPosition();
                         if(pos != RecyclerView.NO_POSITION){
                             recycleViewInterface.onitemClick(pos);
                         }
                     }
                 }
             });

        }
    }
  /*  private void setAnimation (View viewAnimation,int postion){
        if( postion >lastposition){
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewAnimation.startAnimation(slideIn);
            lastposition=postion;
        }
    }*/
}
