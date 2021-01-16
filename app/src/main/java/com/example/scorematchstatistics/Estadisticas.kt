package com.example.scorematchstatistics

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import android.widget.TableLayout
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_estadisticas.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Estadisticas : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var tableLayout: TableLayout
    private var cabezera =
        listOf("arena", "especiales", "capitan", "formacion", "nivel", "portero")
    private var ordenado = "arena"
    private var buscado = "barreor"


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

    private fun iniciarDatabase() {
        FirebaseApp.initializeApp(requireContext())
        databaseReference = FirebaseDatabase.getInstance().getReference("Jugador")
    }

    private fun listarDatos(orderBy: String = "arena") {
        val leerDatos = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error al cargar datos", Toast.LENGTH_SHORT).show()
            }

            var jugador = ArrayList<String>()
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (element in snapshot.children) {
                        jugador.add(element.child("arena").value.toString())
                        jugador.add(element.child("especiales").value.toString())
                        jugador.add(element.child("capitan").value.toString())
                        jugador.add(element.child("formacion").value.toString())
                        jugador.add(element.child("nivel").value.toString())
                        jugador.add(element.child("portero").value.toString())
                    }
                    val myTabla = context?.let { TableLayoutDinamico(tableLayout, it) }
                    myTabla?.agregarCabezeras(cabezera)
                    myTabla?.agregarRegistrosTabla(snapshot.childrenCount.toInt(), jugador)

                }
            }
        }
        databaseReference.orderByChild(orderBy).addValueEventListener(leerDatos)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        iniciarDatabase()
        listarDatos()
        val vista = inflater.inflate(R.layout.fragment_estadisticas, container, false)
        tableLayout = vista.findViewById(R.id.tablelayout)
        vista.btn_filtart.setOnClickListener {
            listarDatos("capitan")
            Toast.makeText(
                context,
                "Search values",
                Toast.LENGTH_SHORT
            ).show()
        }
        vista.spinnerFiltar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
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
        return vista
    }


}