package com.example.scorematchstatistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

class JugadorAll : AppCompatActivity() {

    private val imagenesId = arrayOf(
        R.drawable.mazo1,
        R.drawable.mazo7,
        R.drawable.mazo8,
        R.drawable.mazo9,
        R.drawable.mazo10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugador_all)
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            //Toast.makeText(baseContext, bundle.getString("jugador"), Toast.LENGTH_SHORT).show()
        }
        val adapter = ViewPagerAdapter(imagenesId)
        val viewpager: ViewPager2 = findViewById(R.id.viewPager)
        viewpager.adapter = adapter

    }
}