package com.example.scorematchstatistics.ui.galery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.squareup.picasso.Picasso


class GaleriaAdapter(
    private val lister: ListerElementsGalery
) :
    RecyclerView.Adapter<GaleriaAdapter.ViewHolder>() {

    private var listOfPlayer = listOf<Player>()

    fun setData(players: List<Player>) {
        listOfPlayer = players
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

    override fun getItemCount(): Int = listOfPlayer.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cartaTexto.text = listOfPlayer[position].name
        Picasso.get().load(listOfPlayer[position].image).into(holder.cartaImagen)
        holder.itemView.setOnClickListener {
            lister.clickOnPlayer(player = listOfPlayer[position])
        }
    }

}