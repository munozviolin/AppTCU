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

public class Caso16 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso16);

        //las siguientes 4 lineas corresponden al GIF de la flecha izquierda
        final ImageView imageView = (ImageView) findViewById(R.id.gifIzq16);
        imageView.setBackgroundResource(R.drawable.gif2);
        final AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation.start();

        //las siguientes 4 lineas corresponden al GIF de la flecha derecha
        final ImageView imageView2 = (ImageView) findViewById(R.id.gifDer16);
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

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso16);
        ImageButton buttonAudio1 = (ImageButton) findViewById(R.id.imageButton16);
        Button buttonAudio2 = (Button) findViewById(R.id.buttonCaso16_1);
        ImageButton buttonAudio8 = (ImageButton) findViewById(R.id.imageButton16_2);
        Button buttonAudio4 = (Button) findViewById(R.id.buttonCaso16_2);
        ImageButton buttonAudio5 = (ImageButton) findViewById(R.id.imageButton16_3);
        Button buttonAudio3 = (Button) findViewById(R.id.buttonCaso16_3);
        ImageButton buttonAudio6 = (ImageButton) findViewById(R.id.imageButton16_4);

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

        gestureObject = new GestureDetectorCompat(this, new Caso16.LearnGesture());
    }

    void play(int resourceID) {
        final MediaPlayer player;

        if (resourceID == 1){
            player = MediaPlayer.create(this, R.raw.nhuilhi);
        } else if (resourceID == 2){
            player = MediaPlayer.create(this, R.raw.nharachunh);
        } else if (resourceID == 3){
            player = MediaPlayer.create(this, R.raw.lenhifa);
        } else {
            player = MediaPlayer.create(this, R.raw.conh);
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

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY){
            if (event2.getX() > event1.getX()){//swipe izquierda
                Intent intent = new Intent(Caso16.this, Caso15.class);
                finish();
                Caso16.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent);
            } else if (event1.getX() > event2.getX()){//swipe derecha
                Intent intent = new Intent(Caso16.this, Caso17.class);
                finish();
                Caso16.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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