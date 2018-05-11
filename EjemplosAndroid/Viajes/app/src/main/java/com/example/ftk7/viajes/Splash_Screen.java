package com.example.ftk7.viajes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent nueva_pantalla= new Intent(Splash_Screen.this,MainActivity.class);
                startActivity(nueva_pantalla);
            }
        },2000);
    }
}
