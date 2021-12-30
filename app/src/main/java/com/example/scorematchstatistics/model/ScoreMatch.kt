package com.example.scorematchstatistics.model


data class ScoreMatch(
    var id: String,
    var arena: Int,
    var formacion: String,
    var capitan: String,
    var nivel: Int,
    var portero: String,
    var especiales: Int
) {

}

