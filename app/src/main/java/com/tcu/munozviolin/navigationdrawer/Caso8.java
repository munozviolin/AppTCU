package com.tcu.munozviolin.navigationdrawer;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Caso8 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;
    static MediaPlayer mp = new MediaPlayer();
    static MediaPlayer mp2 = new MediaPlayer();
    static MediaPlayer mp3 = new MediaPlayer();
    static MediaPlayer mp4 = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso8);

        //las siguientes 4 lineas corresponden al GIF de la flecha izquierda
        final ImageView imageView = (ImageView) findViewById(R.id.gifIzq8);
        imageView.setBackgroundResource(R.drawable.gif2);
        final AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation.start();

        //las siguientes 4 lineas corresponden al GIF de la flecha derecha
        final ImageView imageView2 = (ImageView) findViewById(R.id.gifDer8);
        imageView2.setBackgroundResource(R.drawable.gif);
        final AnimationDrawable frameAnimation2 = (AnimationDrawable) imageView2.getBackground();
        frameAnimation2.start();

        //codigo para controlar la cantidad de segundos que dura la animacion
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //detener el gif luego de 8 segundos
                frameAnimation.stop();
                frameAnimation2.stop();
                imageView.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
            }
        }, 8000);

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso8);
        ImageButton buttonAudio1 = (ImageButton) findViewById(R.id.imageButton8);
        Button buttonAudio2 = (Button) findViewById(R.id.buttonCaso8_1);
        ImageButton buttonAudio8 = (ImageButton) findViewById(R.id.imageButton8_2);
        Button buttonAudio4 = (Button) findViewById(R.id.buttonCaso8_2);
        ImageButton buttonAudio5 = (ImageButton) findViewById(R.id.imageButton8_3);
        Button buttonAudio3 = (Button) findViewById(R.id.buttonCaso8_3);
        ImageButton buttonAudio6 = (ImageButton) findViewById(R.id.imageButton8_4);

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(1);
            }
        });

        buttonAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(1);
            }
        });

        buttonAudio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(2);
            }
        });

        buttonAudio8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(2);
            }
        });

        buttonAudio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(3);
            }
        });

        buttonAudio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(3);
            }
        });

        buttonAudio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(4);
            }
        });

        buttonAudio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(4);
            }
        });

        /*mp = MediaPlayer.create(this, R.raw.caju);
        mp2 = MediaPlayer.create(this, R.raw.tuectuenh);
        mp3 = MediaPlayer.create(this, R.raw.quilanh);
        mp4 = MediaPlayer.create(this, R.raw.querracaquerraca);

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        //mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso8.this, R.raw.caju);
                    }
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        //mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso8.this, R.raw.caju);
                    }
                    mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp2.isPlaying()) {
                        //mp2.stop();
                        mp2.release();
                        mp2 = MediaPlayer.create(Caso8.this, R.raw.tuectuenh);
                    }
                    mp2.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp2.isPlaying()) {
                        //mp2.stop();
                        mp2.release();
                        mp2 = MediaPlayer.create(Caso8.this, R.raw.tuectuenh);
                    }
                    mp2.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp3.isPlaying()) {
                        //mp3.stop();
                        mp3.release();
                        mp3 = MediaPlayer.create(Caso8.this, R.raw.quilanh);
                    }
                    mp3.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp3.isPlaying()) {
                        //mp3.stop();
                        mp3.release();
                        mp3 = MediaPlayer.create(Caso8.this, R.raw.quilanh);
                    }
                    mp3.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp4.isPlaying()) {
                        //mp4.stop();
                        mp4.release();
                        mp4 = MediaPlayer.create(Caso8.this, R.raw.querracaquerraca);
                    }
                    mp4.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        buttonAudio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp4.isPlaying()) {
                        //mp4.stop();
                        mp4.release();
                        mp4 = MediaPlayer.create(Caso8.this, R.raw.querracaquerraca);
                    }
                    mp4.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });*/

        gestureObject = new GestureDetectorCompat(this, new Caso8.LearnGesture());
    }

    void play(int resourceID) {
        final MediaPlayer player;

        if (resourceID == 1){
            player = MediaPlayer.create(this, R.raw.caju);
        } else if (resourceID == 2){
            player = MediaPlayer.create(this, R.raw.tuectuenh);
        } else if (resourceID =){
            player = MediaPlayer.create(this, R.raw.quilanh);
        } else {
            player = MediaPlayer.create(this, R.raw.querracaquerraca);
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
        else if (mp2 != null) {
            mp2.stop();
        }
        else if(mp3 != null) {
            mp3.stop();
        }
        else if (mp4 != null) {
            mp4.stop();
        }
    }*/

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY){
            if (event2.getX() > event1.getX()){//swipe izquierda
                Intent intent = new Intent(Caso8.this, Caso7.class);
                finish();
                Caso8.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent);
            } else if (event1.getX() > event2.getX()){//swipe derecha
                Intent intent = new Intent(Caso8.this, Caso8.class);
                finish();
                Caso8.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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