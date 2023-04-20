package com.example.animecharacters;

import androidx.room.Database;
import androidx.room.RoomDatabase;
 @Database(entities = {animeCharacterModel.class},version = 1)
public abstract class AnimeDataBase extends RoomDatabase {
    abstract public CharactersDao charactersDao();
}
