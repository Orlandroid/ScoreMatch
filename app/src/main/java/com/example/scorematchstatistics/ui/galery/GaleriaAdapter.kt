package com.example.scorematchstatistics.ui.galery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.squareup.picasso.Picasso


class GaleriaAdapter(
    private val players: List<Player>,
    private val lister: ListerElementsGalery
) :
    RecyclerView.Adapter<GaleriaAdapter.ViewHolder>() {

    private var listaPlayer = listOf<Player>()

    private fun setData(players: List<Player>) {
        listaPlayer = players
        notifyDataSetChanged()
    }

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
        holder.itemView.setOnClickListener {
            lister.clickOnPlayer(player = players[position])
        }
    }

}