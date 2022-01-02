package com.example.scorematchstatistics.ui.stadistics

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.scorematchstatistics.controlador.ControladorEstadisticas
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.databinding.FragmentEstadisticasBinding


class EstadisticasFragment : Fragment() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var ctrEstadisticas: ControladorEstadisticas
    private var cabezera =
        listOf("arena", "especiales", "capitan", "formacion", "nivel", "portero")
    private var _binding: FragmentEstadisticasBinding? = null
    private val binding get() = _binding!!


    private fun iniciarDatabase() {
        FirebaseApp.initializeApp(requireContext())
        databaseReference = FirebaseDatabase.getInstance().getReference("Jugador")
    }


    private fun listarDatos(ordernarPor: String) {
        ctrEstadisticas = ControladorEstadisticas()
        ctrEstadisticas.listarDatos(
            ordernarPor,
            requireContext(),
            binding.tablelayout,
            databaseReference,
            cabezera
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEstadisticasBinding.inflate(inflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        iniciarDatabase()
        with(binding) {
            btnFiltart.setOnClickListener {
            }
            spinnerFiltar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    when (position) {
                        0 -> listarDatos("arena")
                        1 -> listarDatos("especiales")
                        2 -> listarDatos("capitan")
                        3 -> listarDatos("formacion")
                        4 -> listarDatos("nivel")
                        5 -> listarDatos("portero")
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_score, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_actualizar -> startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/orlando1818/ScoreMatch/blob/main/README.md")
                )
            )
        }
        return super.onOptionsItemSelected(item)
    }


}