package com.example.scorematchstatistics.controlador

import android.content.Context
import android.widget.TableLayout
import android.widget.Toast
import com.example.scorematchstatistics.TableLayoutDinamico
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class ControladorEstadisticas {


    fun listarDatos(
        orderBy: String = "arena",
        context: Context,
        tableLayout: TableLayout,
        databaseReference: DatabaseReference,
        cabezera: List<String>
    ) {
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
                    val myTabla = TableLayoutDinamico(tableLayout, context)
                    myTabla.agregarCabezeras(cabezera)
                    myTabla.agregarRegistrosTabla(snapshot.childrenCount.toInt(), jugador)

                }
            }
        }
        databaseReference.orderByChild(orderBy).addValueEventListener(leerDatos)
    }

}