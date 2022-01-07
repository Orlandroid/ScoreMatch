package com.example.scorematchstatistics.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val level: Int,
    val name: String,
    val typeOfPlayer: String,
    val speed: Int,
    val height: Int,
    val strenght: Int,
    val power: Int,
    val skill: Int,
    val resposne: Int
)