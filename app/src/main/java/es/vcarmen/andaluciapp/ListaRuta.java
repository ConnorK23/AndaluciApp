package es.vcarmen.andaluciapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

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
        AdaptadorRuta adaptadorRuta = new AdaptadorRuta(this, listRoute);
        listView.setAdapter(adaptadorRuta);

        button = (Button) findViewById(R.id.comenzarruta);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mapa.class);
                startActivity(intent);
            }
        });
    }
}
