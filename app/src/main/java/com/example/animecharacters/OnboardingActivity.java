package com.example.animecharacters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {
  private FragmentManager fragmentManager;
    SharedPreferences sharedPreferences ;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        fragmentManager=getSupportFragmentManager();
        final PaperOnboardingFragment paperOnboardingFragment=PaperOnboardingFragment.newInstance(getDataForOnBoarding());
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,paperOnboardingFragment);
        fragmentTransaction.commit();
        sharedPreferences =getSharedPreferences("sharedPref",MODE_PRIVATE);
        boolean isFirstTime = sharedPreferences.getBoolean("firstTime",true);
        if(isFirstTime){
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putBoolean("firstTime",false);
            editor.commit();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 5000);





        }else{
            Intent intent =new Intent(OnboardingActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

        }


    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {
        PaperOnboardingPage src1= new PaperOnboardingPage("Hello","I hope you'll enjoy our app \n Thanks for downloading it \n please click on me to continue :)",
                Color.parseColor("#FF018786"),R.drawable.sticker,R.drawable.heart);
        ArrayList<PaperOnboardingPage> elements =new ArrayList<>();
        elements.add(src1);

        return elements;

    }
}