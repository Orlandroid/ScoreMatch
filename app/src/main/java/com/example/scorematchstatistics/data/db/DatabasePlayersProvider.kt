package com.example.scorematchstatistics.data.db

import com.example.scorematchstatistics.data.model.Player
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabasePlayersProvider @Inject constructor() {


    companion object {
        const val TYPE_NORMAL = "normal"
        const val TYPE_SUPER = "normal"
        const val TYPE_GOLDEN = "normal"

        const val GUARD = "guardia"
        const val ENGINE = "motor"
        const val INTRUSO = "intruder"
        const val INFILTRADOR = "infiltrador"
        const val ARQUITECTO = "arquitecto"
        const val PRODUCER = "productor"
        const val EXPLORER = "explorer"
        const val PROWLER = "medoreador"
        const val MENACE = "amenaza"
        const val SPEEDSTER = "velocista"
        const val HAMMER = "mazo"
        const val KEEPER = "portero"
        const val GK_SWEEPER = "sweeper"
        const val GK_STOPPER = "stopper"

    }

    fun getLevelsGuard():List<Player>{
        return guardLevels
    }


    private val guardLevels = listOf(
        Player( level = 1,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 7, height = 5, strenght = 5,power =  3, skill = 17, resposne = 1),
        Player( level = 2,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0),
        Player( level = 3,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0),
        Player( level = 4,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0),
        Player( level = 5,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 17, height = 9, strenght = 9,power =  6, skill = 32, resposne = 9),
        Player( level = 6,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 11, strenght = 11,power =  7, skill = 35, resposne = 12),
        Player( level = 7,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 12, strenght = 12,power =  8, skill = 39, resposne = 14),
        Player( level = 8,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 25, height = 13, strenght = 13,power =  8, skill = 43, resposne = 16),
        Player( level = 9,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 14, strenght = 14,power =  9, skill = 46, resposne = 18),
        Player( level = 10,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 15, strenght = 15,power =  10, skill = 50, resposne = 20),
    )






}