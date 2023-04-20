package com.example.animecharacters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {
    ArrayList<animeCharacterModel>myAnimeList=new ArrayList<>();
    int[]images ={R.drawable.eren_attack_on_titan___attack_on_titan_aesthetic__attack_on_titan_art__eren_jaeger,R.drawable.tanjiro_icon,
          R.drawable.melodias,R.drawable.naruto_uzumaki_namikaze____soy_una_verdadera_kunoichi_,
            R.drawable.the_best_mikasa_ackerman_quotes,R.drawable.deku,
            R.drawable.kaneki,R.drawable.levi,R.drawable.anya_forger_icon,
            R.drawable.resource__};

    private AnimeDataBase dataBase;
    int counter=-1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDB();
        setUpAnime();




    }

    private void setUpDB() {
    dataBase = Room.databaseBuilder(getApplicationContext(),AnimeDataBase.class,"anime_db")
           .allowMainThreadQueries()
            .build();
    }

    private void setUpAnime(){
        String[] charNames =getResources().getStringArray(R.array.charNames);
        String[] animeNames =getResources().getStringArray(R.array.animeNames);
        String[] desAnimes=getResources().getStringArray(R.array.animeDescibe);
        RecyclerView recyclerView = findViewById(R.id.mrecycleview);
        Button button= findViewById(R.id.addButton);
        button.setOnClickListener(view -> {
            counter++;
            if(counter< charNames.length) {
               myAnimeList.add(new animeCharacterModel(1,charNames[counter], animeNames[counter], images[counter], desAnimes[counter]));
                //dataBase.charactersDao().insertAnime(new animeCharacterModel(1,charNames[counter], animeNames[counter], images[counter], desAnimes[counter]));
                AC_recycleViewAdaptar adaptar = new AC_recycleViewAdaptar(this, myAnimeList, this);
                recyclerView.setAdapter(adaptar);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));



            } else Toast.makeText(this, "full!,please delete any element to add another", Toast.LENGTH_SHORT).show();  });




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

    @Override
    public void deleteAnime(animeCharacterModel animeCharacterModel) {

    }

    @Override
    public void insertAnime(animeCharacterModel animeCharacterModel) {

    }

    @Override
    public List<animeCharacterModel> getAll() {
        return null;
    }
}