package com.example.scorematchstatistics.ui.galery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorematchstatistics.ui.detailplayer.JugadorAll
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.squareup.picasso.Picasso


class GaleriaAdapter(
    val players: List<Player>
) :
    RecyclerView.Adapter<GaleriaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cartaImagen: ImageView = itemView.findViewById(R.id.imagenViewGaleria)
        val cartaTexto: TextView = itemView.findViewById(R.id.texto_galeria)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.elemento_galeria, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cartaTexto.text = players[position].name
        Picasso.get().load(players[position].image).into(holder.cartaImagen)
        holder.cartaImagen.setOnClickListener {
            val intento = Intent(it.context, JugadorAll::class.java)
            intento.putExtra("jugador", players[position].name)
            it.context.startActivity(intento)
        }
    }


}