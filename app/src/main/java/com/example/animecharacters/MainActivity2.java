package com.example.animecharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        String describtion = getIntent().getStringExtra("Describtion");
        String nameOfCharacter = getIntent().getStringExtra("NameOfCharacter");
        int image = getIntent().getIntExtra("Image",0);
        ImageView photo =findViewById(R.id.imageView2);
        TextView tvnameCharacter =findViewById(R.id.textView3);
        TextView  tvdesAnime =findViewById(R.id.textView4);

        photo.setImageResource(image);
        tvdesAnime.setText(describtion);
        tvnameCharacter.setText(nameOfCharacter);
    }
}