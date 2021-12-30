package com.example.scorematchstatistics.ui.registration


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
import android.widget.Toast
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.model.Identificador
import com.example.scorematchstatistics.util.PreferenciasValores
import com.example.scorematchstatistics.model.ScoreMatch
import com.example.scorematchstatistics.controlador.AlertMensaje
import com.example.scorematchstatistics.controlador.ControladorRegistro
import com.example.scorematchstatistics.databinding.FragmentRegistroBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import java.util.*


class RegistroFragment : Fragment() {

    private var _binding: FragmentRegistroBinding? = null
    private val binding get() = _binding!!
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
            binding.btnEnviarRegistro.isEnabled = preferencia.recuperarPreferencia()
            Log.w("Datos", "Se ha encontrado la preferencia")
            return true
        }
        Log.w("Datos", "Seguimos con el metodo")
        val registradoYa: Boolean
        databaseReference = FirebaseDatabase.getInstance().getReference("Identificador")
        val ctrRegistro = ControladorRegistro()
        registradoYa =
            ctrRegistro.checkEnviado(requireContext(), databaseReference, binding.btnEnviarRegistro)
        Log.w("Datos", registradoYa.toString())
        return registradoYa

    }


    private fun desabilitar() {
        val alertMensaje = AlertMensaje()
        alertMensaje.showAlertDialog(
            requireContext(),
            requireContext().getString(R.string.tituloInternet),
            requireContext().getString(R.string.mensajeAlertInternet)
        )
        val ctrRegistro = ControladorRegistro()
        ctrRegistro.desabilitarTodo(
            arrayOf(binding.txtNivelCapitan, binding.txtJugadoresEspeciales),
            arrayOf(
                binding.spinerArena,
                binding.spinerFormacion,
                binding.spinerCapitan,
                binding.spinerTipoPortero
            ),
            binding.btnEnviarRegistro
        )
    }

    private fun obtenerDatos() {
        if (!conecion(requireContext())) {
            desabilitar()
            return
        }
        val ctrRegistro = ControladorRegistro()
        if (!ctrRegistro.validarTxt(binding.txtNivelCapitan, binding.txtJugadoresEspeciales) && !check()) {
            val arena: Int = binding.spinerArena.selectedItem.toString().toInt()
            val formacion: String = binding.spinerFormacion.selectedItem.toString()
            val capitan: String = binding.spinerCapitan.selectedItem.toString()
            val nivelCapitan: Int = binding.txtNivelCapitan.text.toString().toInt()
            val tipoPortero: String = binding.spinerTipoPortero.selectedItem.toString()
            val jugadoresEspeciales: Int = binding.txtJugadoresEspeciales.text.toString().toInt()

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
            ctrRegistro.limpiarTxt(binding.txtNivelCapitan, binding.txtJugadoresEspeciales)
        } else {
            Toast.makeText(context, "Debes de llenar todos lo datos", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        setUpUi()
        return binding.root
    }


    private fun setUpUi() {
        check()
        with(binding) {
            btnEnviarRegistro.setOnClickListener {
                obtenerDatos()
            }
            txtJugadoresEspeciales.setOnClickListener {
                if (!conecion(requireContext())) {
                    desabilitar()
                }
            }
            txtNivelCapitan.setOnClickListener {
                if (!conecion(requireContext())) {
                    desabilitar()
                }
            }
        }
    }

}