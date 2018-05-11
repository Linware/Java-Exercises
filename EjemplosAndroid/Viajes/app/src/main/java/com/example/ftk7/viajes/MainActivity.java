package com.example.ftk7.viajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] arrayFotos={R.mipmap.bilbao,R.mipmap.madrid,R.mipmap.oslo};
    private String[] arrayCiudad={"Bilbao","Madrid","Oslo"}; //ATAR ESTO AL RECORRIDO DE LAS FOTOS
    private String valorSeleccionado;
    private int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRegistrar= findViewById(R.id.btnReservar);
        Button btnAnterior= findViewById(R.id.btnAnterior);
        Button btnSiguiente=findViewById(R.id.btnSiguiente);
        final ImageView ivFotos=findViewById(R.id.ivFotos);
        final TextView txtCiudad=findViewById(R.id.textView3);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paso_pantalla= new Intent(MainActivity.this,OpcionesActivity.class);
                paso_pantalla.putExtra("seleccion",valorSeleccionado);
                startActivity(paso_pantalla);
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    pos=pos-1;
                ivFotos.setImageResource(arrayFotos[pos]);
                txtCiudad.setText(arrayCiudad[pos]);
                valorSeleccionado=arrayCiudad[pos];
                }catch (Exception e){
                    pos=arrayFotos.length-1;
                    ivFotos.setImageResource(arrayFotos[pos]);
                    txtCiudad.setText(arrayCiudad[pos]);
                    valorSeleccionado=arrayCiudad[pos];
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    pos=pos+1;
                    ivFotos.setImageResource(arrayFotos[pos]);
                    txtCiudad.setText(arrayCiudad[pos]);
                    valorSeleccionado=arrayCiudad[pos];
                }catch (Exception e){
                    pos=0;
                    ivFotos.setImageResource(arrayFotos[pos]);
                    txtCiudad.setText(arrayCiudad[pos]);
                    valorSeleccionado=arrayCiudad[pos];
                }
            }
        });

    }
}
