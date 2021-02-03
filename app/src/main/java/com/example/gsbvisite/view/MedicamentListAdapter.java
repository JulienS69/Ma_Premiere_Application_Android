package com.example.gsbvisite.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.gsbvisite.R;
import com.example.gsbvisite.modele.Medicament;


import java.util.ArrayList;

public class MedicamentListAdapter extends BaseAdapter {

    private ArrayList<Medicament> lesmedicaments;
    private LayoutInflater inflater;

    public MedicamentListAdapter(Context context, ArrayList<Medicament> lesmedicaments){
        this.lesmedicaments = lesmedicaments;
        this.inflater = LayoutInflater.from(context);
    }

    //region Méthode implémentées

    /**
     *
     * @return le nombre de lignes
     */

    @Override
    public int getCount() {
        return lesmedicaments.size();
    }

    /**
     *
     * @param position
     * @return l'item de la ligne actuelle
     */

    @Override
    public Object getItem(int position) {
        return lesmedicaments.get(position);
    }

    /**
     *
     * @param position
     * @return un indice par rapport à la ligne actuelle
     */

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return la ligne (view) formaté avec gestion des évènements
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Déclaration d'un Holder
        ViewHolder holder;
        // si la ligne n'existe pas encore
        if (convertView == null) {
            holder = new ViewHolder();
            // la ligne est construire avec un formatage (inflater) relié à layout_list_medicament
            convertView = inflater.inflate(R.layout.layout_list_medicament, null);
            // chaque propriété du holder est relié à une propriété graphique
            holder.txtNomCommercial = (TextView) convertView.findViewById(R.id.txtNomCommercial);
            holder.txtEffet = (TextView) convertView.findViewById(R.id.txtEffet);
            holder.txtPrix = (TextView) convertView.findViewById(R.id.txtPrix);
            holder.txtComposition = (TextView) convertView.findViewById(R.id.txtComposition);
            holder.txtContreIndic = (TextView) convertView.findViewById(R.id.txtContreIndic);
            holder.txtDepotLegal = (TextView) convertView.findViewById(R.id.txtDepotLegal);
            // affecter le holder à la vue
            convertView.setTag(holder);
        }
        else {
        // récupération du holder dans la ligne existante
            holder = (ViewHolder) convertView.getTag();
        }
        // valorisation du contenu du holder (donc de la ligne)
        holder.txtNomCommercial.setText(lesmedicaments.get(position).getMNomCommercial());
        holder.txtEffet.setText(lesmedicaments.get(position).getEffet());
        holder.txtPrix.setText(lesmedicaments.get(position).getMPrixEchant().toString());
        holder.txtComposition.setText(lesmedicaments.get(position).getMComposition());
        holder.txtContreIndic.setText(lesmedicaments.get(position).getContreindic());
        holder.txtDepotLegal.setText(lesmedicaments.get(position).getMDepotLegal());

        return convertView;
    }

    //endregion

    private class ViewHolder{
        TextView txtNomCommercial;
        TextView txtEffet;
        TextView txtPrix;
        TextView txtComposition;
        TextView txtContreIndic;
        TextView txtDepotLegal;

    }
}
