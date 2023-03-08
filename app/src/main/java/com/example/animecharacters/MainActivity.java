package com.example.animecharacters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {
    ArrayList<animeCharacterModel>myAnimeList=new ArrayList<>();
    int[]images ={R.drawable.eren_attack_on_titan___attack_on_titan_aesthetic__attack_on_titan_art__eren_jaeger,R.drawable.tanjiro_icon,
          R.drawable.melodias,R.drawable.naruto_uzumaki_namikaze____soy_una_verdadera_kunoichi_,
            R.drawable.the_best_mikasa_ackerman_quotes,R.drawable.deku,
            R.drawable.kaneki,R.drawable.levi,R.drawable.anya_forger_icon,
            R.drawable.resource__};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mrecycleview);
        setUpAnime();
        AC_recycleViewAdaptar adaptar = new AC_recycleViewAdaptar(this,myAnimeList,this);
        recyclerView.setAdapter(adaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpAnime(){
        String[] charNames =getResources().getStringArray(R.array.charNames);
        String[] animeNames =getResources().getStringArray(R.array.animeNames);
        String[] desAnimes=getResources().getStringArray(R.array.animeDescibe);
        for(int i=0;i<charNames.length;i++){
            myAnimeList.add(new animeCharacterModel(charNames[i],animeNames[i],images[i],desAnimes[i]));
        }

    }

    @Override
    public void onitemClick(int position) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("NameOfCharacter", myAnimeList.get(position).nameOfCharacter);
        intent.putExtra("Describtion", myAnimeList.get(position).desAnime);
        intent.putExtra("Image", myAnimeList.get(position).Images);

        startActivity(intent);
    }
}