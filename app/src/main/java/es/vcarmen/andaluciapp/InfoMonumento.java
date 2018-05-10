package es.vcarmen.andaluciapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by conno on 30/04/2018.
 */

public class InfoMonumento extends AppCompatActivity {
    ImageView header;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Bundle bundle;
    Button botonMapa;
    String lat, lng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_monument);

        botonMapa = (Button) findViewById(R.id.botonMapa);
        bundle = getIntent().getExtras();
        header = (ImageView) findViewById(R.id.header);
        lat = String.valueOf(bundle.get("lat"));
        lng = String.valueOf(bundle.get("lng"));
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Picasso.with(getApplicationContext()).load(String.valueOf(bundle.get("header"))).into(header);
        collapsingToolbarLayout.setTitle(String.valueOf(bundle.get("title")));


        botonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Mapa.class);
                i.putExtra("lat", lat);
                i.putExtra("lng", lng);
                i.putExtra("name", String.valueOf(bundle.get("title")));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
