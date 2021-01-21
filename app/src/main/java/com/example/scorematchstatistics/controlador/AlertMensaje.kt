package com.example.scorematchstatistics.controlador


import android.content.Context

import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AlertMensaje {


    fun showAlertDialog(context: Context, titulo: String, mensaje: String) {
        val alert = MaterialAlertDialogBuilder(context)
        alert.setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
        alert.create()
        alert.show()
    }
}