package com.example.scorematchstatistics.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scorematchstatistics.databinding.ItemMenuBinding
import com.squareup.picasso.Picasso


class MenuAdapter(private val listener: ListenerClickOnMenu) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {


    private var listOfMenu = listOf<Menu>()

    fun setData(posts: List<Menu>) {
        listOfMenu = posts
        notifyDataSetChanged()
    }


    interface ListenerClickOnMenu {
        fun clickOnGalery()
        fun clickOnPost()
    }

    class ViewHolder(private val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: Menu) {
            with(binding) {
                txtNombreMenu.text = menu.title
                Picasso.get().load(menu.image).resize(500, 500).into(imageMenu)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemMenuBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(listOfMenu[position])
        viewHolder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    listener.clickOnGalery()
                }
                1 -> {
                    listener.clickOnPost()
                }
            }
        }
    }


    override fun getItemCount() = listOfMenu.size
}
