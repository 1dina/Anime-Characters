package com.example.animecharacters;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
 @Database(entities = {animeCharacterModel.class},version = 1)
public abstract class AnimeDataBase extends RoomDatabase {
    abstract public CharactersDao charactersDao();
    private static AnimeDataBase instance;
   /* public  static synchronized  AnimeDataBase getInstance(Context context){
        if(instance==null){
            instance =
        }
       return instance;
    }*/
}
