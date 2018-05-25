package es.vcarmen.andaluciapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageView andalucia, granada, jaen, almeria, cadiz, cordoba, huelva, malaga, sevilla, ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        andalucia = (ImageView) findViewById(R.id.andalucia);
        granada = (ImageView) findViewById(R.id.granada);
        jaen = (ImageView) findViewById(R.id.jaen);
        almeria = (ImageView) findViewById(R.id.almeria);
        cadiz = (ImageView) findViewById(R.id.cadiz);
        cordoba = (ImageView) findViewById(R.id.cordoba);
        huelva = (ImageView) findViewById(R.id.huelva);
        malaga = (ImageView) findViewById(R.id.malaga);
        sevilla = (ImageView) findViewById(R.id.sevilla);
        ruta = (ImageView) findViewById(R.id.ruta);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 4000, 4000);

        andalucia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", (Bundle) null);
                startActivity(intent);
            }
        });

        granada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Granada");
                startActivity(intent);
            }
        });

        jaen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Jaén");
                startActivity(intent);
            }
        });

        almeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Almería");
                startActivity(intent);
            }
        });

        cadiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Cádiz");
                startActivity(intent);
            }
        });

        cordoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Córdoba");
                startActivity(intent);
            }
        });

        huelva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Huelva");
                startActivity(intent);
            }
        });

        malaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Málaga");
                startActivity(intent);
            }
        });

        sevilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAllMonuments.class);
                intent.putExtra("Provincia", "Sevilla");
                startActivity(intent);
            }
        });

        ruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaRuta.class);
                startActivity(intent);
            }
        });
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
