package com.tcu.munozviolin.navigationdrawer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Caso1 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;
    static MediaPlayer mp = new MediaPlayer();
    static MediaPlayer mp2 = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso1);

        //las siguientes 4 lineas corresponden al GIF de la flecha derecha
        final ImageView imageView = (ImageView) findViewById(R.id.gif);
        imageView.setBackgroundResource(R.drawable.gif);
        final AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation.start();

        //codigo para controlar la cantidad de segundos que dura la animacion
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //detener el gif luego de 4 segundos
                frameAnimation.stop();
                imageView.setVisibility(View.INVISIBLE);
            }
        }, 4000);

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso1);
        ImageButton buttonAudio1 = (ImageButton) findViewById(R.id.imageButton);
        Button buttonAudio2 = (Button) findViewById(R.id.buttonCaso1_2);
        ImageButton buttonAudio3 = (ImageButton) findViewById(R.id.imageButton2);
        mp = MediaPlayer.create(this, R.raw.afela);
        mp2 = MediaPlayer.create(this, R.raw.ajarra);

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso1.this, R.raw.afela);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        //mp2 = MediaPlayer.create(this, R.raw.st);
        buttonAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso1.this, R.raw.afela);
                    } mp.start();
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
                        mp2 = MediaPlayer.create(Caso1.this, R.raw.ajarra);
                    } mp2.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp2.isPlaying()) {
                        mp2.stop();
                        mp2.release();
                        mp2 = MediaPlayer.create(Caso1.this, R.raw.ajarra);
                    } mp2.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        gestureObject = new GestureDetectorCompat(this, new Caso1.LearnGesture());
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
                //Intent intent = new Intent(Caso1.this, palabra2.class);
                //finish();
                //startActivity(intent);
            } else if (event1.getX() > event2.getX()){//swipe derecha
                Intent intent = new Intent(Caso1.this, Caso2.class);
                finish();
                Caso1.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                startActivity(intent);
            }
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
