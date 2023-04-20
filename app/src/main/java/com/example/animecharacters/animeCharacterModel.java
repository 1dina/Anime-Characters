package com.example.animecharacters;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Otaku")
public class animeCharacterModel {
    @PrimaryKey
     int id;
     String nameOfCharacter;
     String nameOfAnime;
    int Images;
   String desAnime;
    public animeCharacterModel(int id, String nameOfCharacter, String nameOfAnime, int images, String desAnime) {
        this.id = id;
        this.nameOfCharacter = nameOfCharacter;
        this.nameOfAnime = nameOfAnime;
        this.Images = images;
        this.desAnime = desAnime;

    }

    public animeCharacterModel(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    public void setNameOfCharacter(String nameOfCharacter) {
        this.nameOfCharacter = nameOfCharacter;
    }

    public String getNameOfAnime() {
        return nameOfAnime;
    }

    public void setNameOfAnime(String nameOfAnime) {
        this.nameOfAnime = nameOfAnime;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    public String getDesAnime() {
        return desAnime;
    }

    public void setDesAnime(String desAnime) {
        this.desAnime = desAnime;
    }


}
