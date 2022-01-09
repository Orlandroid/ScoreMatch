package com.example.scorematchstatistics.ui.detailplayer


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorematchstatistics.R


class ViewPagerAdapter(private val imagenes: Array<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {


    class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_player_all_levels, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int = imagenes.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        //Picasso.get().load(imagenes[position]).into(holder.Imagen)
    }

}