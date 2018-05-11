package com.example.ftk7.encuentramonedas;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pantalla_Inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout__inicial);

        Button btnWebView=findViewById(R.id.btnWebView);

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantallaWebView = new Intent(Pantalla_Inicial.this,Video_Activity.class);
                startActivity(pantallaWebView);
            }
        });



        Button btnNav=findViewById(R.id.btnNav);

        Uri uriUrl = Uri.parse("https://www.youtube.com/watch?v=4JkIs37a2JE");
        final Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);

        btnNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(launchBrowser);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent nueva_pantalla= new Intent(Pantalla_Inicial.this,MainActivity.class);
                nueva_pantalla.putExtra("saldo",300);
                startActivity(nueva_pantalla);
            }
        },80000);
    }
}
