package com.example.franklinsierra.laboratorio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater=null;

    Context context;
    /*List<String> nombres;
    List<String> about;
    private int layout;*/
    private String[] nombres;
    private String[] about;
    private String[] info;
    int[] frutas;
    //List<String> info;

    public Adaptador(Context context,String[] nombres, String[] about, int[] frutas, String[] info) {
        this.context = context;
        this.nombres = nombres;
        this.about = about;
        this.frutas = frutas;
        this.info=info;

        inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
        public int getCount() {
            return frutas.length;
        }

        @Override
        public Object getItem(int position) {
            return this.nombres[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v=inflater.inflate(R.layout.customlayout,null);
            ImageView miImage=(ImageView)v.findViewById(R.id.imageLauncher);
            TextView nombre=(TextView) v.findViewById(R.id.textName);
            TextView description=(TextView) v.findViewById(R.id.teextDescription);

            miImage.setImageResource(frutas[position]);
            nombre.setText(nombres[position]);
            description.setText(about[position]);


            return v;
        }


}
