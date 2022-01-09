package com.example.scorematchstatistics.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val level: Int?=0,
    val name: String,
    val typeOfPlayer: String,
    val image:Int,
    val speed: Int,
    val height: Int,
    val strenght: Int,
    val power: Int,
    val skill: Int,
    val resposne: Int
): Parcelable