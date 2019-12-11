package com.example.basicanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView anim;
    SeekBar speed;
    Button play;
    Button pause;
    Button restart;
    float seekvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speed=findViewById(R.id.speed);
        anim=findViewById(R.id.anim);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        restart=findViewById(R.id.restart);
        speed.setMin(-100);
        speed.setMax(100);

        speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekvalue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                anim.setSpeed(seekvalue/100);

            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.setProgress(1);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.resumeAnimation();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.pauseAnimation();
            }
        });
    }
}
