package com.drdroid.app.vigenere_cipher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends MainActivity {
    Animation myAnimation;
    TextView myText;
    ImageView LogoV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        myText = (TextView)findViewById(R.id.sptv);
        LogoV = (ImageView) findViewById(R.id.imgLogo);

        myAnimation = AnimationUtils.loadAnimation(this, R.anim.myani);

        myText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                myText.startAnimation(myAnimation);
            }
        });

        Handler h=new Handler();
        h.postDelayed(new Runnable() {

            public void run() {
                // TODO Auto-generated method stub
                startActivity(new Intent(Splash.this,Option.class));
                finish();
            }
        }, 2000);
    }

    }
