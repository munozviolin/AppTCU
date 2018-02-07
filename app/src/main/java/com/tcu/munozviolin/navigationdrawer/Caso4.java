package com.tcu.munozviolin.navigationdrawer;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Caso4 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;
    static MediaPlayer mp = new MediaPlayer();
    static MediaPlayer mp2 = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso4);

        //las siguientes 4 lineas corresponden al GIF de la flecha izquierda
        final ImageView imageView = (ImageView) findViewById(R.id.gifIzq4);
        imageView.setBackgroundResource(R.drawable.gif2);
        final AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation.start();

        //las siguientes 4 lineas corresponden al GIF de la flecha derecha
        final ImageView imageView2 = (ImageView) findViewById(R.id.gifDer4);
        imageView2.setBackgroundResource(R.drawable.gif);
        final AnimationDrawable frameAnimation2 = (AnimationDrawable) imageView2.getBackground();
        frameAnimation2.start();

        //codigo para controlar la cantidad de segundos que dura la animacion
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //detener el gif luego de 4 segundos
                frameAnimation.stop();
                frameAnimation2.stop();
                imageView.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
            }
        }, 4000);

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso4);
        ImageButton buttonAudio1 = (ImageButton) findViewById(R.id.imageButton4);
        Button buttonAudio2 = (Button) findViewById(R.id.buttonCaso4_1);
        ImageButton buttonAudio4 = (ImageButton) findViewById(R.id.imageButton4_2);
        mp = MediaPlayer.create(this, R.raw.ola);
        mp2 = MediaPlayer.create(this, R.raw.oterra);

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso4.this, R.raw.ola);
                    } mp = MediaPlayer.create(Caso4.this, R.raw.ola);
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso4.this, R.raw.ola);
                    } mp = MediaPlayer.create(Caso4.this, R.raw.ola);
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp2.isPlaying()) {
                        mp2.stop();
                        mp2.release();
                        mp2 = MediaPlayer.create(Caso4.this, R.raw.oterra);
                    } mp2 = MediaPlayer.create(Caso4.this, R.raw.oterra);
                    mp2.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp2.isPlaying()) {
                        mp2.stop();
                        mp2.release();
                        mp2 = MediaPlayer.create(Caso4.this, R.raw.oterra);
                    } mp2 = MediaPlayer.create(Caso4.this, R.raw.oterra);
                    mp2.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        gestureObject = new GestureDetectorCompat(this, new Caso4.LearnGesture());
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mp != null) {
            mp.stop();
        }
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY){
            if (event2.getX() > event1.getX()){//swipe izquierda
                Intent intent = new Intent(Caso4.this, Caso3.class);
                finish();
                Caso4.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent);
            } /*else if (event1.getX() > event2.getX()){//swipe derecha
                Intent intent = new Intent(Caso4.this, Caso4.class);
                finish();
                Caso4.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent);
            }*/
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}