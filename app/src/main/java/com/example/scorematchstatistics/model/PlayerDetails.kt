package com.example.scorematchstatistics.model

data class PlayerDetails(
    val nombre: String,
    val idImagen: Int,
    val playerLevels: HashMap<Int, List<Int>>
)