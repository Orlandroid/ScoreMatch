package com.example.scorematchstatistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Galeria : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val imagenesId = arrayOf(
        R.drawable.arquitecto7,
        R.drawable.arquitecto8,
        R.drawable.barreror8,
        R.drawable.bulldozer1,
        R.drawable.comander10,
        R.drawable.comander9,
        R.drawable.comander92,
        R.drawable.explorador9,
        R.drawable.explorador10,
        R.drawable.barreror5
    )

    private val nombres = arrayOf(
        "Arquitecto",
        "Arquitecto",
        "barreror",
        "bulldozer",
        "comander",
        "comander",
        "comander",
        "explorador",
        "explorador",
        "barreror"
    )


    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_galeria, container, false)
        val gridItems: RecyclerView = vista.findViewById(R.id.gridItems)
        val adaptadpr = ListaGaleria(nombres, imagenesId)
        val gridLayout = GridLayoutManager(requireContext(), 2)
        gridItems.layoutManager = gridLayout
        gridItems.adapter = adaptadpr
        return vista
    }


}