package es.vcarmen.andaluciapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
    String titulo;
    private GoogleMap mMap;
    public static ArrayList<MonumentoRuta> listRoute = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_monument);

        bundle = getIntent().getExtras();
        button = (Button) findViewById(R.id.botonAdd);
        header = (ImageView) findViewById(R.id.header);
        lat = Double.parseDouble(String.valueOf(bundle.get("lat")));
        lng = Double.parseDouble(String.valueOf(bundle.get("lng")));
        titulo = String.valueOf(bundle.get("title"));
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Picasso.with(getApplicationContext()).load(String.valueOf(bundle.get("header"))).into(header);
        collapsingToolbarLayout.setTitle(titulo);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonumentoRuta monumentoRuta = new MonumentoRuta(titulo, lat, lng);
                listRoute.add(monumentoRuta);
                System.out.println(listRoute.toString());
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
