package es.vcarmen.andaluciapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by conno on 20/04/2018.
 */

public class ListAllMonuments extends AppCompatActivity {
    ArrayList<Monumento> listMonuments = new ArrayList<>();
    Monumento monumento;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_all_monuments);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference("");

        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                monumento = dataSnapshot.getValue(Monumento.class);
                listMonuments.add(monumento);
                System.out.println(listMonuments.toString());
                adapter = new Adaptador(listMonuments, getApplicationContext());
                recycler.setAdapter(adapter);

                recycler.addOnItemTouchListener(
                        new RecyclerItemTouch(getApplicationContext(), recycler ,new RecyclerItemTouch.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Monumento monumento2 = (Monumento) listMonuments.get(position);
                                Intent i = new Intent(getApplicationContext(), InfoMonumento.class);
                                i.putExtra("header", monumento2.getImageUrlMax());
                                i.putExtra("title", monumento2.getName());
                                i.putExtra("lat", String.valueOf(monumento2.getLat()));
                                i.putExtra("lng", String.valueOf(monumento2.getLng()));
                                startActivity(i);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                // do whatever
                            }
                        })
                );
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
