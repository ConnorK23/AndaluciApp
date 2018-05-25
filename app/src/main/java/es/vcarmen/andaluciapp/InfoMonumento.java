package es.vcarmen.andaluciapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by conno on 30/04/2018.
 */

public class InfoMonumento extends AppCompatActivity implements OnMapReadyCallback {
    ImageView header;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Bundle bundle;
    double lat, lng;
    String titulo, direccion, municipio, imageUrlMin;
    private GoogleMap mMap;
    public static ArrayList<MonumentoRuta> listRoute = new ArrayList<>();
    FloatingActionButton button;
    EditText direccionM, municipioM, codigopostalM, historiaM;
    boolean showingFirst = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_monument);

        bundle = getIntent().getExtras();
        button = (FloatingActionButton) findViewById(R.id.botonAdd);
        header = (ImageView) findViewById(R.id.header);
        direccionM = (EditText) findViewById(R.id.direccion);
        municipioM = (EditText) findViewById(R.id.municipio);
        codigopostalM = (EditText) findViewById(R.id.codigopostal);
        historiaM = (EditText) findViewById(R.id.historia);

        lat = Double.parseDouble(String.valueOf(bundle.get("lat")));
        lng = Double.parseDouble(String.valueOf(bundle.get("lng")));
        System.out.println(imageUrlMin);
        direccion = String.valueOf(bundle.get("direccion"));
        titulo = String.valueOf(bundle.get("title"));
        municipio = String.valueOf(bundle.get("municipio")) + ", " + String.valueOf(bundle.get("provincia"));

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Picasso.with(getApplicationContext()).load(String.valueOf(bundle.get("header"))).into(header);
        collapsingToolbarLayout.setTitle(titulo);

        direccionM.setText(direccion);
        municipioM.setText(municipio);
        codigopostalM.setText(String.valueOf(bundle.get("cpostal")));
        historiaM.setText(String.valueOf(bundle.get("info")));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showingFirst == true) {
                    MonumentoRuta monumentoRuta = new MonumentoRuta(titulo, lat, lng, String.valueOf(bundle.get("header")));
                    listRoute.add(monumentoRuta);
                    Snackbar.make(view, "Monumento añadido a tu lista!", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(R.color.snackbar_action))
                            .setAction("Ir a lista", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getApplicationContext(), ListaRuta.class);
                                    startActivity(intent);
                                }
                            }).show();
                    showingFirst = false;
                } else {
                    Snackbar.make(view, "Este monumento ya ha sido añadido", Snackbar.LENGTH_LONG)
                            .setActionTextColor(getResources().getColor(R.color.snackbar_action))
                            .setAction("Ir a lista", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getApplicationContext(), ListaRuta.class);
                                    startActivity(intent);
                                }
                            }).show();
                }
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title(String.valueOf(bundle.get("title"))));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setMinZoomPreference(4.0f);
        mMap.setMaxZoomPreference(20.0f);
        mMap.addPolyline(new PolylineOptions().add(sydney).width(5).color(Color.RED));

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
