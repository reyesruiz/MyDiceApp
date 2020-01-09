package com.digitalruiz.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        int myBox = 10;
        float myFloatBox = 10.2f;
        double myDoubleBox = 10.2783;

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));
                YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));
                Log.i("MyDiceApp", "btnRoll is tapped now!");
                Random rndObject = new Random();
                int myRandomNumber = rndObject.nextInt(6); // 0 .. 5
                Log.i("MyDiceApp", "The first generated random number is " + myRandomNumber + "");
                diceImage1.setImageResource(diceImages[myRandomNumber]);
                myRandomNumber = rndObject.nextInt(6); // 0 .. 5
                Log.i("MyDiceApp", "The second generated random number is " + myRandomNumber + "");
                diceImage2.setImageResource(diceImages[myRandomNumber]);



            }
        });
    }
}
