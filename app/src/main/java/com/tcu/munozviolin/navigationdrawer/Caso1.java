package com.tcu.munozviolin.navigationdrawer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Caso1 extends AppCompatActivity {

    GestureDetectorCompat gestureObject;
    static MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caso1);

        Button buttonAudio = (Button) findViewById(R.id.buttonCaso1);
        mp = MediaPlayer.create(this, R.raw.st);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Caso1.this, R.raw.st);
                    } mp.start();
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
