package es.vcarmen.andaluciapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static es.vcarmen.andaluciapp.InfoMonumento.listRoute;

/**
 * Created by conno on 19/05/2018.
 */

public class ListaRuta extends AppCompatActivity {

    ListView listView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_monumentoruta);
        listView = (ListView) findViewById(R.id.lista_empresas);

        final AdaptadorRuta adaptadorRuta = new AdaptadorRuta(this, listRoute);
        listView.setAdapter(adaptadorRuta);

        HashSet<MonumentoRuta> hs = new HashSet<>(listRoute);
        List<MonumentoRuta> arraylist = new ArrayList<>(hs);

        for (Object item : arraylist) {
            System.out.println(item);
        }

        button = (Button) findViewById(R.id.comenzarruta);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mapa.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                new AlertDialog.Builder(ListaRuta.this)
                        .setTitle("Eliminar")
                        .setMessage("¿Desea eliminar este contacto?")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                MonumentoRuta monumentoRuta = (MonumentoRuta) listRoute.get(i);
                                listRoute.remove(monumentoRuta);
                                adaptadorRuta.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(R.mipmap.alert)
                        .show();
                return true;
            }
        });
    }
}
