package com.example.scorematchstatistics.controlador

import android.content.Context
import android.os.Build
import android.widget.*
import com.example.scorematchstatistics.PreferenciasValores
import com.google.firebase.database.*


class ControladorRegistro {


    fun validarTxt(nivelCapitan: EditText, especiales: EditText): Boolean {
        return nivelCapitan.text.toString().isEmpty()
                || especiales.text.toString().isEmpty()
    }


    fun desabilitarTodo(txt: Array<EditText>, spinner: Array<Spinner>, btnEnviar: Button) {
        for (elemnto in txt)
            elemnto.isEnabled = false
        for (elemento in spinner)
            elemento.isEnabled = false
        btnEnviar.isEnabled = false
    }

    fun limpiarTxt(nivelCapitan: EditText, especiales: EditText) {
        especiales.text = null
        nivelCapitan.text = null
    }

    fun checkEnviado(
        context: Context,
        databaseReference: DatabaseReference,
        btnRegistro: Button
    ): Boolean {
        val id = Build.ID
        var encontrado = false
        val datos = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (element in snapshot.children) {
                        if (element.child("name").value.toString() == id) {
                            btnRegistro.isEnabled = false
                            val alertM = AlertMensaje()
                            alertM.showAlertDialog(
                                context,
                                "Registro",
                                "Ya has contestado el registro por lo cual solo podras visualizar los datos"
                            )
                            val preferencias = PreferenciasValores(context)
                            preferencias.guardarPreferencias(false)
                            encontrado = true
                            break
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        }

        databaseReference.addValueEventListener(datos)
        return encontrado
    }

}