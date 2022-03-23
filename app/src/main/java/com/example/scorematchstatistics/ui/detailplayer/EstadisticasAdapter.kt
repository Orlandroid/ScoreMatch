package com.example.scorematchstatistics.ui.detailplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.databinding.ItemEstadisticaBinding

class EstadisticasAdapter() :
    RecyclerView.Adapter<EstadisticasAdapter.ViewHolder>() {


    private  var estadistica:Player?=null

    fun setData(lista: Player) {
        estadistica = lista
        notifyDataSetChanged()
    }


    class ViewHolder(val binding:ItemEstadisticaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int,estadistica: Player){
            when(position){
                0->{
                    with(binding){
                        imageEstadistica.setImageResource(R.drawable.running)
                        tvNombreEstadistica.text="Velocidad"
                        //tvValor.text=estadistica.speed.toString()
                    }
                }
                1->{
                    with(binding){
                        imageEstadistica.setImageResource(R.drawable.altura)
                        tvNombreEstadistica.text="Altura"
                        //tvValor.text=estadistica.height.toString()
                    }
                }
                2->{
                    with(binding){
                        imageEstadistica.setImageResource(R.drawable.brazo)
                        tvNombreEstadistica.text="Fuerza"
                        //tvValor.text=estadistica.strenght.toString()
                    }
                }
                3->{
                    with(binding){
                        imageEstadistica.setImageResource(R.drawable.shoe)
                        tvNombreEstadistica.text="Potencia"
                        //tvValor.text=estadistica.power.toString()
                    }
                }
                4->{
                    with(binding){
                        imageEstadistica.setImageResource(R.drawable.thinking)
                        tvNombreEstadistica.text="Respuesta"
                        //tvValor.text=estadistica.resposne.toString()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemEstadisticaBinding.inflate(layoutInflater,viewGroup,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        estadistica?.let { viewHolder.bind(position, it) }
    }

    override fun getItemCount() = 5

}
