package com.example.scorematchstatistics

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.TableLayout
import androidx.core.content.ContextCompat

class TableLayoutDinamico(tabLayout: TableLayout, context: Context) {

    private var myTabla: TableLayout = tabLayout
    private var mContext: Context = context
    var param: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        100
    )

    //private var letra: Typeface = Typeface.createFromAsset(context.assets, "fuentes")
    private lateinit var textView: TextView
    private lateinit var renglon: TableRow

    private fun agregarRenglon() {
        renglon = TableRow(mContext)
    }

    fun agregarCabezeras(cabezera: List<String>) {
        agregarRenglon()
        for (elemento in cabezera)
            crerCelda(elemento)
        myTabla.addView(renglon)


    }

    private fun crerCelda(texto: String) {
        textView = TextView(mContext)
        textView.setPadding(11, 7, 11, 11)
        textView.setBackgroundResource(R.drawable.textview_border)
        //textView.typeface = letra
        textView.setTextColor(ContextCompat.getColor(mContext, R.color.negro))
        textView.text = texto
        renglon.addView(textView)
    }

    private fun crearCeldaCabezera() {

    }

    fun agregarRegistrosTabla(total: Int, registros: ArrayList<String>) {
        var contador: Int = 0
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