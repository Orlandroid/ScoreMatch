package com.example.scorematchstatistics

import android.content.Context
import android.preference.PreferenceManager.getDefaultSharedPreferences


class PreferenciasValores(context: Context) {

    private val nombreBotonRegistro = "btnRegistro"

    @Suppress("DEPRECATION")
    private var preferencias = getDefaultSharedPreferences(context)


    fun existePreferencia(): Boolean {
        return preferencias.contains(nombreBotonRegistro)
    }

    fun guardarPreferencias(valor: Boolean) {
        val editor = preferencias.edit()
        editor.putBoolean(nombreBotonRegistro, valor)
        editor.apply()
    }

    fun recuperarPreferencia(): Boolean {
        return preferencias.getBoolean(nombreBotonRegistro, true)
    }

    fun eliminarPreferencia(nombre: String) {
        val editor = preferencias.edit()
        editor.remove(nombre)
        editor.apply()
    }

}