package es.vcarmen.andaluciapp;

/**
 * Created by conno on 19/05/2018.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorRuta extends ArrayAdapter<MonumentoRuta> {
    public AdaptadorRuta(@NonNull Context context, @NonNull ArrayList<MonumentoRuta> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = null;
        MonumentoRuta monumentoRuta = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.monument_listroute, parent, false);
        }

        TextView textViewNombre = (TextView) convertView.findViewById(R.id.texto_empresas);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imagen_empresas);

        textViewNombre.setText(monumentoRuta.getName());
        imageView.setImageResource(R.drawable.icon3);

        return convertView;
    }
}
