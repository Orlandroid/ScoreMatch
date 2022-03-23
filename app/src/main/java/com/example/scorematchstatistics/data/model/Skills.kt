package com.example.scorematchstatistics.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Skills(
    val speed: Int,
    val height: Int,
    val strenght: Int,
    val power: Int,
    val skill: Int,
    val resposne: Int
):Parcelable