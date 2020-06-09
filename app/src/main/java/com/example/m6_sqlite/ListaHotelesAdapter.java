package com.example.m6_sqlite;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m6_sqlite.room.hotels;

import java.util.ArrayList;

public class ListaHotelesAdapter extends RecyclerView.Adapter<ListaHotelesAdapter.ViewHolder> {
    ArrayList<hotels> listh=new ArrayList<>();

    public ListaHotelesAdapter(ArrayList<hotels> listh) {
        this.listh = listh;
    }

    @NonNull
    @Override
    public ListaHotelesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_hoteles_adapter,parent,false);

        return new ListaHotelesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaHotelesAdapter.ViewHolder holder, int position) {
        String cif=listh.get(position).getCif();
        String nom=listh.get(position).getNom();
        int habit=listh.get(position).getHabitacions();
        int fact= listh.get(position).getFacturacio();
        int pob=listh.get(position).getPoblacio_id();

        holder.cif.setText(cif);
        holder.nom.setText(nom);
        holder.habitacions.setText(habit);
        holder.factracio.setText(fact);
        holder.poblacio.setText(pob);

    }

    @Override
    public int getItemCount() {
        return listh.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom,cif,habitacions,factracio,poblacio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom=itemView.findViewById(R.id.textViewNombre);
            cif=itemView.findViewById(R.id.textViewCif);
            habitacions=itemView.findViewById(R.id.textViewHabitacions);
            factracio=itemView.findViewById(R.id.textViewFact);
            poblacio=itemView.findViewById(R.id.textViewPob);

        }
    }
}
