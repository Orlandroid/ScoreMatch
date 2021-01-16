package com.example.scorematchstatistics.controlador

import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_registro.*

class controllerRegistro {

    fun validarTxt(nivelCapitan: EditText, especiales: EditText): Boolean {
        return nivelCapitan.text.toString().isEmpty()
                || especiales.text.toString().isEmpty()
    }

    private fun limpiarTxt(nivelCapitan: EditText, especiales: EditText) {
        especiales.text = null
        nivelCapitan.text = null
    }

}