package com.example.ftk7.encuentramonedas;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

private int[] imagenes={R.mipmap.coins,R.mipmap.plain_coin,R.mipmap.skull,R.mipmap.question};
private int pos=0;
private int puntos=0;
private int puntos_totales;
private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle datos=getIntent().getExtras();
        int saldo= datos.getInt("saldo");

        Toast.makeText(MainActivity.this,"Tu saldo es de "+saldo,Toast.LENGTH_SHORT).show();

        final Handler handler=new Handler();

        final ImageView imageView= findViewById(R.id.imageView);
        final ImageView imageView2= findViewById(R.id.imageView2);
        final ImageView imageView3= findViewById(R.id.imageView3);

        SharedPreferences pref=getSharedPreferences("Adivina",0);
        int record=pref.getInt("puntos",0);

        Toast.makeText(MainActivity.this,"Tu record fue: "+record,Toast.LENGTH_SHORT).show();
        final SharedPreferences.Editor editor=pref.edit();

        final Runnable mToastRunnable= new Runnable(){

            @Override
            public void run() {

            }
        };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pos= (int) (Math.random() * 3);
                if (pos==0){
                    puntos+=5;
                    puntos_totales+=puntos;
                    editor.putInt("puntos",puntos_totales);

                }else if(pos==1){
                    puntos+=1;
                    puntos_totales+=puntos;
                    editor.putInt("puntos",puntos_totales);
                }else{
                    editor.apply();
                    puntos=0;
                    puntos_totales=0;
                }
                imageView.setImageResource(imagenes[pos]);
                Toast.makeText(MainActivity.this,"Puntos: "+puntos,Toast.LENGTH_SHORT).show();

                mHandler.postDelayed(mToastRunnable,1000);

                imageView.setImageResource(imagenes[3]);
                imageView2.setImageResource(imagenes[3]);
                imageView3.setImageResource(imagenes[3]);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos= (int) (Math.random() * 3);
                if (pos==0){
                    puntos+=5;
                    puntos_totales+=puntos;
                    editor.putInt("puntos",puntos_totales);

                }else if(pos==1){
                    puntos+=1;
                    puntos_totales+=puntos;
                    editor.putInt("puntos",puntos_totales);
                }else{
                    editor.apply();
                    puntos=0;
                    puntos_totales=0;
                }
                imageView3.setImageResource(imagenes[pos]);
                Toast.makeText(MainActivity.this,"Puntos: "+puntos,Toast.LENGTH_SHORT).show();

                mHandler.postDelayed(mToastRunnable,1000);
                imageView.setImageResource(imagenes[3]);
                imageView2.setImageResource(imagenes[3]);
                imageView3.setImageResource(imagenes[3]);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos= (int) (Math.random() * 3);
                if (pos==0){
                    puntos+=5;
                    puntos_totales+=puntos;
                    editor.putInt("puntos",puntos_totales);

                }else if(pos==1){
                    puntos+=1;
                    puntos_totales+=puntos;
                    editor.putInt("puntos",puntos_totales);
                }else{
                    editor.apply();
                    puntos=0;
                    puntos_totales=0;
                }
                imageView2.setImageResource(imagenes[pos]);
                Toast.makeText(MainActivity.this,"Puntos: "+puntos,Toast.LENGTH_SHORT).show();

                mHandler.postDelayed(mToastRunnable,1000);
                imageView.setImageResource(imagenes[3]);
                imageView2.setImageResource(imagenes[3]);
                imageView3.setImageResource(imagenes[3]);
            }
        });

    }

}
