package com.example.animecharacters;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharactersDao {
    @Delete
    void deleteAnime(animeCharacterModel animeCharacterModel);
    @Insert(onConflict = OnConflictStrategy.NONE)
    void insertAnime(animeCharacterModel animeCharacterModel);
    @Query("SELECT * From Otaku")
   List<animeCharacterModel>getAll();
}
