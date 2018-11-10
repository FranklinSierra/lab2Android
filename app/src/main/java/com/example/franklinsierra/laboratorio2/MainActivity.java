package com.example.franklinsierra.laboratorio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] nombres=new String[]{"Manzana", "Uvas", "Kiwi", "Naranja","Pera", "Piña"};

    String[] about=new String[]{"en Boyacá", "en el Valle del Cauca", "en el Cauaca",
            "en el Meta","en Neiva ","en Santander"};

    String[] info=new String[]{"Reduce el colesterol en la sangre",
            "Contienen todas las vitaminas B",
            "Mejora la circulacion",
            "Favorece el sistema inmune",
            "Contiene hierro",
            "Tiene acido folico"};


   /* private List<String> nombres;
    private List<String> about;
    private List<String> info;*/

    ListView mListView;
    Adaptador miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] frutas=new int[]{R.drawable.apple,R.drawable.grapes,R.drawable.kiwi,R.drawable.orange,
                R.drawable.pear,R.drawable.pineapple};

       /* nombres=new ArrayList<String>();
        nombres.add("Manzana");
        nombres.add("Uvas");
        nombres.add("Kiwi");
        nombres.add("Naranja");
        nombres.add("Pera");
        nombres.add("Piña");

        about=new ArrayList<String>();
        about.add("en Boyaca");
        about.add("en el Valle del Cauca");
        about.add("en el Cauca");
        about.add("en el Meta");
        about.add("en Neiva");
        about.add("en Santander");

        info=new ArrayList<String>();
        info.add("Reduce el colesterol en la sangre");
        about.add("Contienen todas las vitaminas B");
        about.add("Mejora la circulacion");
        about.add("Favorece el sistema inmune");
        about.add("Contiene hierro");
        about.add("Tiene acido folico");*/

        mListView=(ListView)findViewById(R.id.lista);
        miAdaptador=new Adaptador(this,nombres,about,frutas,info);
        mListView.setAdapter(miAdaptador);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"consumela por: "+info[position],Toast.LENGTH_SHORT).show();
            }
        });

    }

    //creo el boton

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    //cuando clickean el item

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                miAdaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
