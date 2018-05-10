package es.vcarmen.andaluciapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by conno on 25/04/2018.
 */

public class AndalusiaMapFilter extends AppCompatActivity {
    TextView almeria, cadiz, cordoba, granada, huelva;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_andalucia);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        almeria = (TextView) findViewById(R.id.almeria);
        cadiz = (TextView) findViewById(R.id.cadiz);
        cordoba = (TextView) findViewById(R.id.cordoba);
        granada = (TextView) findViewById(R.id.granada);
        huelva = (TextView) findViewById(R.id.huelva);

        almeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "ALMERIA", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        cadiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast2 = Toast.makeText(getApplicationContext(), "CADIZ", Toast.LENGTH_SHORT);
                toast2.show();
            }
        });

        cordoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast3 = Toast.makeText(getApplicationContext(), "CORDOBA", Toast.LENGTH_SHORT);
                toast3.show();
            }
        });

        granada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast4 = Toast.makeText(getApplicationContext(), "GRANADA", Toast.LENGTH_SHORT);
                toast4.show();
            }
        });

        huelva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast5 = Toast.makeText(getApplicationContext(), "HUELVA", Toast.LENGTH_SHORT);
                toast5.show();
            }
        });
    }
}
