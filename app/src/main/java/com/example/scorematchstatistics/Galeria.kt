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

    private var imagenesId = arrayOf(
        R.drawable.c_amenaza,
        R.drawable.c_amenaza_roberts,
        R.drawable.c_arquitecto_budak,
        R.drawable.c_comandante_segura,
        R.drawable.c_horvath,
        R.drawable.c_explorador_cabrera,
        R.drawable.c_explorador_nazari,
        R.drawable.c_explorador_ramalho,
        R.drawable.c_guardia_bechet,
        R.drawable.c_guardia_davies,
        R.drawable.c_guardia_eriksson,
        R.drawable.c_guardia_richads,
        R.drawable.c_infiltrador_bartosz,
        R.drawable.c_infiltrador_wu,
        R.drawable.c_intruso_babangida,
        R.drawable.c_intruso_kovalchuk,
        R.drawable.c_major,
        R.drawable.c_marksman_faustinho,
        R.drawable.c_mazo,
        R.drawable.c_mazo_mensah,
        R.drawable.c_medoreador_badr,
        R.drawable.c_medoreador_gallagher,
        R.drawable.c_motor_nielsen,
        R.drawable.c_motor_zukic,
        R.drawable.c_muro_romero,
        R.drawable.c_portero_lechner,
        R.drawable.c_portero_schimidt,
        R.drawable.c_portero_taylor,
        R.drawable.c_productor_camara,
        R.drawable.c_productor_oliva,
        R.drawable.c_productor_santos,
        R.drawable.c_protector_dekic,
        R.drawable.c_protector_nacho,
        R.drawable.c_velocista,
        R.drawable.c_velocista_dubois,
        R.drawable.c_velocista_goosens
    )

    private lateinit var nombres:Array<String>

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
        nombres=requireContext().resources.getStringArray(R.array.nombres_jugadores)
        val gridItems: RecyclerView = vista.findViewById(R.id.gridItems)
        val adaptadpr = ListaGaleria(nombres, imagenesId, requireContext())
        val gridLayout = GridLayoutManager(requireContext(), 2)
        gridItems.layoutManager = gridLayout
        gridItems.adapter = adaptadpr
        return vista
    }


}