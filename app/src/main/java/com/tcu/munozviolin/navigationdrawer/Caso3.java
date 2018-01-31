package com.tcu.munozviolin.navigationdrawer;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Caso3 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;
    static MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso3);

        //las siguientes 4 lineas corresponden al GIF de la flecha izquierda
        final ImageView imageView = (ImageView) findViewById(R.id.gifIzq3);
        imageView.setBackgroundResource(R.drawable.gif2);
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

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso3);
        mp = MediaPlayer.create(this, R.raw.pirates_of_caribbean);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso3.this, R.raw.pirates_of_caribbean);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });

        gestureObject = new GestureDetectorCompat(this, new Caso3.LearnGesture());
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
                Intent intent = new Intent(Caso3.this, Caso2.class);
                finish();
                Caso3.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent);
            } else if (event1.getX() > event2.getX()){//swipe derecha
                //Intent intent = new Intent(Caso3.this, Caso3.class);
                //finish();
                //startActivity(intent);
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