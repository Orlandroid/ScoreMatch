package com.example.scorematchstatistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Estadisticas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var tableLayout: TableLayout
    private var cabezera =
        listOf("arena", "especiales", "capitan", "formacion", "nivel", "portero")


    private fun iniciarDatabase() {
        FirebaseApp.initializeApp(requireContext())
        databaseReference = FirebaseDatabase.getInstance().getReference("Jugador")
    }

    private fun listarDatos() {
        val leerDatos = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

            var jugador = ArrayList<String>()
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (element in snapshot.children) {
                        jugador.add(element.child("arena").value.toString())
                        jugador.add(element.child("cantidadJugadoresEspeciales").value.toString())
                        jugador.add(element.child("capitan").value.toString())
                        jugador.add(element.child("formacion").value.toString())
                        jugador.add(element.child("nivelCapitan").value.toString())
                        jugador.add(element.child("tipoPorterp").value.toString())
                    }
                    var myTabla = context?.let { TableLayoutDinamico(tableLayout, it) }
                    myTabla?.agregarCabezeras(cabezera)
                    myTabla?.agregarRegistrosTabla(snapshot.childrenCount.toInt(), jugador)

                }
            }
        }
        databaseReference.addValueEventListener(leerDatos)
    }

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
        iniciarDatabase()
        listarDatos()
        val vista: View = inflater.inflate(R.layout.fragment_estadisticas, container, false)
        tableLayout = vista.findViewById(R.id.tablelayout)
        return vista
    }


}