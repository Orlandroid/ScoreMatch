package com.example.scorematchstatistics

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import android.widget.TableLayout
import androidx.core.content.ContextCompat

class TableLayoutDinamico(tabLayout: TableLayout, context: Context) {

    private var myTabla: TableLayout = tabLayout
    private var mContext: Context = context
    var param = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        400
    )

    init {
        myTabla.orientation = TableLayout.HORIZONTAL
        myTabla.removeAllViews()
    }

    //private var letra: Typeface = Typeface.createFromAsset(context.assets, "fuentes")
    private lateinit var textView: TextView
    private lateinit var renglon: TableRow

    private fun agregarRenglon() {
        renglon = TableRow(mContext)
        renglon.layoutParams = param
    }

    fun agregarCabezeras(cabezera: List<String>) {
        agregarRenglon()
        for (elemento in cabezera)
            crearCeldaCabezera(elemento)
        myTabla.addView(renglon)


    }

    private fun crerCelda(texto: String) {
        textView = TextView(mContext)
        textView.setPadding(8, 4, 8, 4)

        textView.setBackgroundResource(R.drawable.textview_border)
        textView.gravity = Gravity.CENTER
        //textView.typeface = letra
        textView.setTextColor(ContextCompat.getColor(mContext, R.color.negro))
        textView.text = texto
        renglon.addView(textView)
    }

    fun crearCeldaCabezera(texto: String) {
        textView = TextView(mContext)
        textView.setPadding(11, 7, 11, 11)
        textView.gravity = Gravity.CENTER
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.setBackgroundResource(R.drawable.textview_cabezera)
        textView.setTextColor(ContextCompat.getColor(mContext, R.color.black))
        textView.text = texto
        renglon.addView(textView)
    }

    fun agregarRegistrosTabla(total: Int, registros: ArrayList<String>) {
        var contador = 0
        for (j in 0 until total) {
            agregarRenglon()
            for (i in 1..6) {
                Log.w("Datos", contador.toString())
                crerCelda(registros[contador])
                contador++
            }
            myTabla.addView(renglon)
        }

    }

}