package es.vcarmen.andaluciapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by conno on 23/04/2018.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.MonumentViewHolder> {
    private List<Monumento> items;
    private Context context;

    public static class MonumentViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombreMonumento;
        public TextView direccionMonumento;
        public TextView lugarycpostal;

        public MonumentViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombreMonumento = (TextView) v.findViewById(R.id.nombreMonumento);
            direccionMonumento = (TextView) v.findViewById(R.id.direccionMonumento);
            lugarycpostal = (TextView) v.findViewById(R.id.lugarycpostal);
        }
    }



    public Adaptador (List<Monumento> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MonumentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.monument_card, viewGroup, false);
        return new MonumentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MonumentViewHolder holder, int i) {
        Picasso.with(context).load(String.valueOf(items.get(i).getImageUrlMin())).into(holder.imagen);
        holder.nombreMonumento.setText(String.valueOf(items.get(i).getName()));
        holder.direccionMonumento.setText(String.valueOf(items.get(i).getAddress()));
        holder.lugarycpostal.setText(String.valueOf(items.get(i).getMunicipality())
                + ", " + String.valueOf(items.get(i).getPostalcode())
                + ", " + String.valueOf(items.get(i).getProvince()));
    }
}
