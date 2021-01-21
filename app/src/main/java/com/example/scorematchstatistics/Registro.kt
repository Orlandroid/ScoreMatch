package com.example.scorematchstatistics


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.scorematchstatistics.controlador.AlertMensaje
import com.example.scorematchstatistics.controlador.ControladorRegistro
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

    @Suppress("DEPRECATION")
    private fun conecion(context: Context): Boolean {
        val con: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network: NetworkInfo? = con.activeNetworkInfo
        //true conexion false no conexion
        return network?.isConnectedOrConnecting == true //not internet
    }

    private fun iniciarDatabase() {
        FirebaseApp.initializeApp(requireContext())
        databaseReference = FirebaseDatabase.getInstance().reference
    }

    private fun check(): Boolean {
        val preferencia = PreferenciasValores(requireContext())
        if (preferencia.existePreferencia()) {
            btnEnviarRegistro.isEnabled = preferencia.recuperarPreferencia()
            Log.w("Datos", "Se ha encontrado la preferencia")
            return true
        }
        Log.w("Datos", "Seguimos con el metodo")
        val registradoYa: Boolean
        databaseReference = FirebaseDatabase.getInstance().getReference("Identificador")
        val ctrRegistro = ControladorRegistro()
        registradoYa =
            ctrRegistro.checkEnviado(requireContext(), databaseReference, btnEnviarRegistro)
        Log.w("Datos", registradoYa.toString())
        return registradoYa

    }


    

    private fun obtenerDatos() {
        if (!conecion(requireContext())) {
            val alertMensaje = AlertMensaje()
            alertMensaje.showAlertDialog(
                requireContext(),
                requireContext().getString(R.string.tituloInternet),
                requireContext().getString(R.string.mensajeAlertInternet)
            )
            val ctrRegistro = ControladorRegistro()
            ctrRegistro.desabilitarTodo(
                arrayOf(txtNivelCapitan, txtJugadoresEspeciales),
                arrayOf(spinerArena, spinerFormacion, spinerCapitan, spinerTipoPortero),
                btnEnviarRegistro
            )
            return
        }
        val ctrRegistro = ControladorRegistro()
        if (!ctrRegistro.validarTxt(txtNivelCapitan, txtJugadoresEspeciales) && !check()) {
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
            ctrRegistro.limpiarTxt(txtNivelCapitan, txtJugadoresEspeciales)
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
        btnEnviarRegistro = vista.findViewById(R.id.btnEnviarRegistro)
        btnEnviarRegistro.setOnClickListener { obtenerDatos() }
        check()
        return vista
    }

}