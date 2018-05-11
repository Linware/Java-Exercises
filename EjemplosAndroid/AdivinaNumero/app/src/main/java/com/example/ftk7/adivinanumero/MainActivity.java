package com.example.ftk7.adivinanumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numeroUsuario= findViewById(R.id.etTexto);
        Button botonAdivinar= findViewById(R.id.btnAdivinar);

        botonAdivinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroEscogido= numeroUsuario.getText().toString();

                final int numeroAleatorio= (int) (Math.random() * 5) + 1;

                if(Integer.parseInt(numeroEscogido)>5 || Integer.parseInt(numeroEscogido)<1){
                    Toast.makeText(MainActivity.this,"Solo se permiten numeros entre 1 y 5",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(numeroEscogido.equals(String.valueOf(numeroAleatorio))){
                    Toast.makeText(MainActivity.this,"Has acertado!!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Numero erroneo.El bueno hubiese sido el "+numeroAleatorio,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
