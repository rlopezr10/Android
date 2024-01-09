package com.example.frutapp.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frutapp.R;

import java.util.List;

public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.ViewHolder> {

    private List<Fruta> datos;

    public FrutaAdapter(List<Fruta> frutas) {
        this.datos = frutas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrutaAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(datos.get(position).getName());
        holder.id.setText("ID: " + datos.get(position).getId());
        holder.familia.setText("Familia: " + datos.get(position).getFamily());
        holder.genero.setText("Genero: " + datos.get(position).getGenus());
        holder.orden.setText("Orden: " + datos.get(position).getOrder());
    }

    @Override
    public int getItemCount() { return datos.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, familia, genero, id, orden;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.name);
            familia = itemView.findViewById(R.id.family);
            genero = itemView.findViewById(R.id.genus);
            id = itemView.findViewById(R.id.id);
            orden = itemView.findViewById(R.id.order);
        }
    }
}
