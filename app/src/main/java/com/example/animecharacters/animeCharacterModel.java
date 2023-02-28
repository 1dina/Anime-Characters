package com.example.animecharacters;

public class animeCharacterModel {
    String nameOfCharacter;
    String nameOfAnime;
    int Images;
    String desAnime;

    public animeCharacterModel(String nameOfCharacter, String nameOfAnime, int images, String desAnime) {
        this.nameOfCharacter = nameOfCharacter;
        this.nameOfAnime = nameOfAnime;
        Images = images;
        this .desAnime=desAnime;
    }

    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    public String getNameOfAnime() {
        return nameOfAnime;
    }

    public int getImages() {
        return Images;
    }

    public String getDesAnime() {
        return desAnime;
    }
}
