package com.example.scorematchstatistics


import android.os.Build
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_registro.*
import java.util.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Registro : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btnEnviarRegistro: Button
    private lateinit var databaseReference: DatabaseReference


    private fun validarTxt(): Boolean {
        return txtNivelCapitan.text.toString().isEmpty()
                || txtJugadoresEspeciales.text.toString().isEmpty()
    }

    private fun limpiarTxt() {
        txtJugadoresEspeciales.text = null
        txtNivelCapitan.text = null
    }

    private fun iniciarDatabase() {
        FirebaseApp.initializeApp(requireContext())
        databaseReference = FirebaseDatabase.getInstance().reference
    }

    private fun checkEnviado(): Boolean {
        val id = Build.ID
        var encontrado = false
        FirebaseApp.initializeApp(requireContext())
        databaseReference = FirebaseDatabase.getInstance().getReference("Identificador")

        val datos = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (element in snapshot.children) {
                        if (element.child("name").value.toString() == id) {
                            btnEnviarRegistro.isEnabled = false
                            Toast.makeText(
                                context,
                                "Ya has llenado el registro solo podras visualizar los datos",
                                Toast.LENGTH_SHORT
                            ).show()
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

    private fun obtenerDatos() {
        if (!validarTxt() && !checkEnviado()) {
            val arena: Int = spinerArena.selectedItem.toString().toInt()
            val formacion: String = spinerFormacion.selectedItem.toString()
            val capitan: String = spinerCapitan.selectedItem.toString()
            val nivelCapitan: Int = txtNivelCapitan.text.toString().toInt()
            val tipoPortero: String = spinerTipoPortero.selectedItem.toString()
            val jugadoresEspeciales: Int = txtJugadoresEspeciales.text.toString().toInt()

            val scoreDatos = ScoreMatch(
                UUID.randomUUID().toString(),
                arena,
                formacion,
                capitan,
                nivelCapitan,
                tipoPortero,
                jugadoresEspeciales
            )
            val identificador = Identificador(UUID.randomUUID().toString(), Build.ID)
            iniciarDatabase()
            databaseReference.child("Jugador").child(scoreDatos.id).setValue(scoreDatos)
            databaseReference.child("Identificador").child(identificador.id).setValue(identificador)

            val mensaje: String = getString(R.string.mensaje_exito)
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
            limpiarTxt()
        } else {
            Toast.makeText(context, "Debes de llenar todos lo datos", Toast.LENGTH_SHORT).show()
        }
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

        val vista: View = inflater.inflate(R.layout.fragment_registro, container, false)
        checkEnviado()
        btnEnviarRegistro = vista.findViewById(R.id.btnEnviarRegistro)
        btnEnviarRegistro.setOnClickListener { obtenerDatos() }
        return vista
    }

}