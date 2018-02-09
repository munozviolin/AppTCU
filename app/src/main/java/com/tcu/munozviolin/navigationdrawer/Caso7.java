package com.tcu.munozviolin.navigationdrawer;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
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

public class Caso7 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;
    //static MediaPlayer mp = new MediaPlayer();
    //static MediaPlayer mp2 = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso7);

        //las siguientes 4 lineas corresponden al GIF de la flecha izquierda
        final ImageView imageView = (ImageView) findViewById(R.id.gifIzq7);
        imageView.setBackgroundResource(R.drawable.gif2);
        final AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation.start();

        //las siguientes 4 lineas corresponden al GIF de la flecha derecha
        final ImageView imageView2 = (ImageView) findViewById(R.id.gifDer7);
        imageView2.setBackgroundResource(R.drawable.gif);
        final AnimationDrawable frameAnimation2 = (AnimationDrawable) imageView2.getBackground();
        frameAnimation2.start();

        //codigo para controlar la cantidad de segundos que dura la animacion
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //detener el gif luego de 7 segundos
                frameAnimation.stop();
                frameAnimation2.stop();
                imageView.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
            }
        }, 7000);

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso7);
        ImageButton buttonAudio1 = (ImageButton) findViewById(R.id.imageButton7);
        Button buttonAudio2 = (Button) findViewById(R.id.buttonCaso7_1);
        ImageButton buttonAudio7 = (ImageButton) findViewById(R.id.imageButton7_2);
        //mp = MediaPlayer.create(this, R.raw.tare);
        //mp2 = MediaPlayer.create(this, R.raw.tiu);

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(1);
                //mp = MediaPlayer.create(v.getContext(), R.raw.tare);
                /*try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        //mp = MediaPlayer.create(Caso7.this, R.raw.tare);
                        //mp = MediaPlayer.create(v.getContext(), R.raw.tare);
                    }
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }*/
            }
        });

        buttonAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(1);
                /*mp = MediaPlayer.create(v.getContext(), R.raw.tare);
                try {
                    if (mp.isPlaying()) {
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mp.stop();
                                mp.release();
                            }
                        });
                        //mp.stop();
                        //mp.release();
                        //mp = MediaPlayer.create(Caso7.this, R.raw.tare);
                        mp = MediaPlayer.create(v.getContext(), R.raw.tare);
                    }
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }*/
            }
        });

        buttonAudio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(2);
                /*mp = MediaPlayer.create(v.getContext(), R.raw.tiu);
                try {
                    if (mp.isPlaying()) {
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mp.stop();
                                mp.release();
                            }
                        });
                        //mp.stop();
                        //mp.release();
                        mp = MediaPlayer.create(v.getContext(), R.raw.tiu);
                        //mp = MediaPlayer.create(Caso7.this, R.raw.tiu);
                    }
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }*/
            }
        });

        buttonAudio7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(2);
                /*mp = MediaPlayer.create(v.getContext(), R.raw.tiu);
                try {
                    if (mp.isPlaying()) {
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mp.stop();
                                mp.release();
                            }
                        });
                        //mp.stop();
                        //mp.release();
                        //mp = MediaPlayer.create(Caso7.this, R.raw.tiu);
                        mp = MediaPlayer.create(v.getContext(), R.raw.tiu);
                    }
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }*/
            }
        });

        gestureObject = new GestureDetectorCompat(this, new Caso7.LearnGesture());
    }

    void play(int resourceID) {
        final MediaPlayer player;

        if (resourceID == 1){
            player = MediaPlayer.create(this, R.raw.tare);
        } else {
            player = MediaPlayer.create(this, R.raw.tiu);
        }

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.release();
            }
        });

        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

    }

    /*@Override
    public void onStop() {
        super.onStop();

        if (mp != null) {
            mp.stop();
        }
        *//*else if (mp2 != null) {
            mp2.stop();
        }*//*
    }*/

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY){
            if (event2.getX() > event1.getX()){//swipe izquierda
                Intent intent = new Intent(Caso7.this, Caso6.class);
                finish();
                Caso7.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent);
            } else if (event1.getX() > event2.getX()){//swipe derecha
                Intent intent = new Intent(Caso7.this, Caso8.class);
                finish();
                Caso7.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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