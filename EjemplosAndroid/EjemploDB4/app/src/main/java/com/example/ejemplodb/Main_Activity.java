package com.example.ejemplodb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;

import java.util.ArrayList;

public class Main_Activity extends AppCompatActivity {

    public ArrayList<JPlace> mItems;
    public ListView mLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        mLV = (ListView)findViewById(R.id.lvPlaces);
        mLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                /*
                Toast.makeText(Main_Activity.this,
                        "Has tocado "+mItems.get(posicion).getName(),
                        Toast.LENGTH_SHORT).show();
                */
                Intent detalle = new Intent(Main_Activity.this,Place_Activity.class);
                detalle.putExtra("op",Place_Activity.OP_EDIT);
                detalle.putExtra("place",mItems.get(posicion));
                startActivity(detalle);
            }
        });

        mLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent map = new Intent(Main_Activity.this, Map_Activity.class);
                map.putExtra("place",mItems.get(position));
                startActivity(map);
                return true;
            }
        });

        //Alta de nuevo lugar:
        findViewById(R.id.btn_Nuevo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detalle = new Intent(Main_Activity.this,Place_Activity.class);
                detalle.putExtra("op",Place_Activity.OP_ADD);
                startActivity(detalle);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        //Obtenemos la lista de places de la bbdd:
        DBHelper db = new DBHelper(Main_Activity.this);
        mItems = db.placesList();

        ListaAdapter adapter = new ListaAdapter(this);
        mLV.setAdapter(adapter);
    }

    public class ViewHolder {
        public final View mView;
        public final TextView tvName;
        public final TextView tvCity;
        public final ImageView ivPlace;

        public ViewHolder(View v) {
            mView = v;
            tvName = (TextView) v.findViewById(R.id.tvPlaceName);
            tvCity = (TextView) v.findViewById(R.id.tvPlaceCity);
            ivPlace = (ImageView) v.findViewById(R.id.ivPlace);
        }
    }

    private class ListaAdapter extends ArrayAdapter<JPlace> {
        public ListaAdapter(Context context) {
            super(context, R.layout.main_row_layout, mItems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_row_layout, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvName.setText(mItems.get(position).getName());
            holder.tvCity.setText(mItems.get(position).getCity());

            /*
            //Mostramos la imagen, como un recurso dentro de la app:
            String nombre_img = String.format("img_%s",mItems.get(position).getID());
            int resId = getResources().getIdentifier(nombre_img,"drawable",getPackageName());
            holder.ivPlace.setImageResource(resId);
            */

            //Caregamos la imagen desde una dirección de Internet (Son necesarios permisos de Internet):
            AQuery aq = new AQuery(Main_Activity.this);
            aq.id(holder.ivPlace).progress(this).image(mItems.get(position).getUrl(), false, true, 0, R.mipmap.ic_launcher, null, AQuery.FADE_IN);
            return convertView;
        }
    }
}
