package com.example.ftk7.holamundo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] imagenes={R.drawable.falcon,R.drawable.mapache,R.drawable.tesla};
    private int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ivCoche= findViewById(R.id.ivCoche);

        Button btnValidate= findViewById(R.id.btnValidate);
        Button btnReservar= findViewById(R.id.Reservar);
        final EditText etNombre= findViewById(R.id.etNombre);
        final EditText etUds=findViewById(R.id.editText2);


        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCoche.setImageResource(imagenes[pos]);
                pos++;
                if(pos>imagenes.length-1){
                    pos=0;
                }
                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title);

// 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uds=0;
                String nombre="";
                String msg="";
                try {
                    uds = Integer.valueOf(etUds.getText().toString());
                    nombre= etNombre.getText().toString();
                    if (uds<1 || nombre.length()>0){

                        Toast.makeText(MainActivity.this,"Valores NO validos",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }catch(Exception e){
                    Toast.makeText(MainActivity.this,"Introduzca el numero de unidades",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,nombre+" has reservado "+uds+" unidades",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
