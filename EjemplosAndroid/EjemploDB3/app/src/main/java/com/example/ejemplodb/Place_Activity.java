package com.example.ejemplodb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Place_Activity extends AppCompatActivity {
    public final static int OP_ADD=1;
    public final static int OP_EDIT=2;

    private TextView tvTitulo;
    private EditText etNombre;
    private EditText etCiudad;

    private int mOP;
    private JPlace mPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_layout);

        tvTitulo = findViewById(R.id.tvTitulo);
        etNombre = findViewById(R.id.etNombre);
        etCiudad = findViewById(R.id.etCiudad);

        //Distinguimos si es una operación de alta o de editar:
        Bundle datos = getIntent().getExtras();
        mOP = datos.getInt("op");

        if (mOP == OP_ADD) {
            tvTitulo.setText(R.string.place_title_new);
            //Deshabilitamos el botón de eliminar:
            findViewById(R.id.btn_Del).setEnabled(false);
            /*
            findViewById(R.id.btn_Del).setVisibility(View.VISIBLE);
            findViewById(R.id.btn_Del).setVisibility(View.INVISIBLE);
            findViewById(R.id.btn_Del).setVisibility(View.GONE);
            */
        } else {
            //Obtengo los datos del place a editar:
            mPlace = (JPlace)datos.getSerializable("place");

            tvTitulo.setText(R.string.place_title_edit);
            etNombre.setText(mPlace.getName());
            etCiudad.setText(mPlace.getCity()+" "+mPlace.getLan()+" "+mPlace.getLon());
        }


        findViewById(R.id.btn_Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Comprobamos que ha escrito algo en nombre y ciudad:
                if (etNombre.getText().toString().length()<=0) {
                    Toast.makeText(Place_Activity.this,"Indica un nombre",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etCiudad.getText().toString().length()<=0) {
                    Toast.makeText(Place_Activity.this,"Indica la ciudad",Toast.LENGTH_SHORT).show();
                    return;
                }
                DBHelper db = new DBHelper(Place_Activity.this);
                JPlace p;
                if (mOP == OP_ADD) {
                    p = new JPlace(0, etNombre.getText().toString(), etCiudad.getText().toString(),"",0.0,0.0);
                    db.placeInsert(p);
                } else {
                    p = new JPlace(mPlace.getID(), etNombre.getText().toString(), etCiudad.getText().toString(),"",0.0,0.0);
                    db.placeUpdate(p);
                }
                finish();
            }
        });

        findViewById(R.id.btn_Del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(Place_Activity.this);
                db.placeDelete(mPlace.getID());
                finish();
            }
        });

    }
}
