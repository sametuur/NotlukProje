package com.yu.development;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread LogoAnimation=new Thread(){
            @Override
            public void run(){
                ImageView logo=findViewById(R.id.imageView);
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_intro_logo);
                logo.startAnimation(animation);
            }
        };
        LogoAnimation.start();

        Thread ad=new Thread(){
            @Override
            public void run(){
                TextView logo=findViewById(R.id.textView);
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_intro_logo);
                logo.startAnimation(animation);
            }
        };
        ad.start();

        Thread redirect=new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3500);
                    Intent i =new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        redirect.start();
    }
}
