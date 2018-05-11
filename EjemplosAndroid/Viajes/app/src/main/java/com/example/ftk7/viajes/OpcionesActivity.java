package com.example.ftk7.viajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        TextView tvciudad=findViewById(R.id.textView5);

        Intent intent = getIntent();

        String ciudad=intent.getStringExtra("seleccion");

        tvciudad.setText(ciudad);
    }
}
