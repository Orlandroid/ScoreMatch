package com.example.scorematchstatistics

data class ScoreMatch(
    var id: String,
    var arena: Int,
    var formacion: String,
    var capitan: String,
    var nivelCapitan: Int,
    var tipoPorterp: String,
    var cantidadJugadoresEspeciales: Int
) {

}