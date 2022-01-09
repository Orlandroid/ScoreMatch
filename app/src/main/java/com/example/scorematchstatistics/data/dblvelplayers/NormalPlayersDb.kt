package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NormalPlayersDb @Inject constructor() {

    companion object {
        const val TYPE_NORMAL = "normal"
        const val TYPE_SUPER = "normal"
        const val TYPE_GOLDEN = "normal"

        /*NORMAL PLAYERS*/
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

    private val imageGuard = R.drawable.c_guardia_bechet
    private val imageEngine = R.drawable.c_motor_zukic
    private val imageInstruso = R.drawable.c_intruso_kovalchuk
    private val imageInfiltrator = R.drawable.c_infiltrador_wu
    private val imageArquitecto = R.drawable.c_arquitecto_budak
    private val imageProducer =  R.drawable.c_productor_santos
    private val imageExplorer = R.drawable.c_explorador_cabrera
    private val imageProwler = R.drawable.c_medoreador_badr
    private val imageMenace = R.drawable.c_amenaza
    private val imageSpeedsTer = R.drawable.c_velocista
    private val imageHammer = R.drawable.c_mazo
    private val imageKeeper = R.drawable.c_portero_schimidt
    private val imageGkSweeper = R.drawable.c_portero_lechner
    private val imageGkStopper = R.drawable.c_portero_taylor



    fun getLevelsGuard():List<Player>{
        return guardLevels
    }

    fun getLevelsEngine():List<Player>{
        return engineLevels
    }

    fun getLevelsIntruso():List<Player>{
        return intrusoLevels
    }

    fun getLevelsInfiltrator():List<Player>{
        return infiltratorLevels
    }

    fun getLevelsArquitecto():List<Player>{
        return arquitectoLevels
    }

    fun getLevelsProducer():List<Player>{
        return producerLevels
    }

    fun getLevelsExplorer():List<Player>{
        return explorerLevels
    }

    fun getLevelsProwler():List<Player>{
        return prowlerLevels
    }

    fun getLevelsMenace():List<Player>{
        return menaceLevels
    }

    fun getLevelsSpeedsTer():List<Player>{
        return speedsTerLevers
    }

    fun getLevelsHameer():List<Player>{
        return hameerLevels
    }

    fun getLevelsKeeper():List<Player>{
        return keeperLevels
    }

    fun getLevelsGkSweeper():List<Player>{
        return gkSweeper
    }


    fun getLevelsGkStopper():List<Player>{
        return gkStopper
    }


    private val guardLevels = listOf(
        Player( level = 1,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 7, height = 5, strenght = 5,power =  3, skill = 17, resposne = 1,image = imageGuard),
        Player( level = 2,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageGuard),
        Player( level = 3,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageGuard),
        Player( level = 4,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageGuard),
        Player( level = 5,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 17, height = 9, strenght = 9,power =  6, skill = 32, resposne = 9,image = imageGuard),
        Player( level = 6,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 11, strenght = 11,power =  7, skill = 35, resposne = 12,image = imageGuard),
        Player( level = 7,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 12, strenght = 12,power =  8, skill = 39, resposne = 14,image = imageGuard),
        Player( level = 8,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 25, height = 13, strenght = 13,power =  8, skill = 43, resposne = 16,image = imageGuard),
        Player( level = 9,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 14, strenght = 14,power =  9, skill = 46, resposne = 18,image = imageGuard),
        Player( level = 10,name = GUARD, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 15, strenght = 15,power =  10, skill = 50, resposne = 20,image = imageGuard)
    )

    private val engineLevels = listOf(
        Player( level = 1,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageEngine),
        Player( level = 2,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 10, height = 10, strenght = 8,power =  8, skill = 8, resposne = 10,image = imageEngine),
        Player( level = 3,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageEngine),
        Player( level = 4,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 15, height = 14, strenght = 11,power =  11, skill = 11, resposne = 15,image = imageEngine),
        Player( level = 5,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 17, height = 16, strenght = 13,power =  13, skill = 13, resposne = 17,image = imageEngine),
        Player( level = 6,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 17, strenght = 14,power =  14, skill = 14, resposne = 20,image = imageEngine),
        Player( level = 7,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 19, strenght = 16,power =  16, skill = 16, resposne = 22,image = imageEngine),
        Player( level = 8,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 25, height =21, strenght = 17,power =  17, skill = 17, resposne = 25,image = imageEngine),
        Player( level = 9,name = ENGINE, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 23, strenght = 19,power =  19, skill = 19, resposne = 27,image = imageEngine),
        Player( level = 10,name = ENGINE, typeOfPlayer =TYPE_NORMAL, speed = 30, height = 25, strenght = 20,power =  20, skill = 20, resposne = 30,image = imageEngine)
    )

    private val intrusoLevels = listOf(
        Player( level = 1,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageInstruso),
        Player( level = 2,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 21, height = 6, strenght = 8,power =  4, skill = 6, resposne = 10,image = imageInstruso),
        Player( level = 3,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 24, height = 7, strenght = 10,power =  5, skill = 7, resposne = 12,image = imageInstruso),
        Player( level = 4,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageInstruso),
        Player( level = 5,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 9, strenght = 13,power =  6, skill = 9, resposne = 17,image = imageInstruso),
        Player( level = 6,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 33, height = 11, strenght = 14,power =  7, skill = 11, resposne = 20,image = imageInstruso),
        Player( level = 7,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 36, height = 12, strenght = 16,power =  8, skill = 12, resposne = 22,image = imageInstruso),
        Player( level = 8,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 39, height = 13, strenght = 17,power =  8, skill = 13, resposne = 25,image = imageInstruso),
        Player( level = 9,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 42, height = 14, strenght = 19,power =  9, skill = 14, resposne = 27,image = imageInstruso),
        Player( level = 10,name = INTRUSO, typeOfPlayer = TYPE_NORMAL, speed = 45, height = 15, strenght = 20,power =  10, skill = 15, resposne = 30,image = imageInstruso)
    )

    private val infiltratorLevels = listOf(
        Player( level = 1,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 14, height = 7, strenght = 5,power =  5, skill = 8, resposne = 1,image = imageInfiltrator),
        Player( level = 2,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 17, height = 8, strenght = 6,power =  6, skill = 10, resposne = 3,image = imageInfiltrator),
        Player( level = 3,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 10, strenght = 7,power =  7, skill = 12, resposne = 5,image = imageInfiltrator),
        Player( level = 4,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 23, height = 11, strenght = 8,power =  8, skill = 14, resposne = 7,image = imageInfiltrator),
        Player( level = 5,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 26, height = 13, strenght = 9,power =  9, skill = 16, resposne = 9,image = imageInfiltrator),
        Player( level = 6,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 28, height = 14, strenght = 11,power =  11, skill = 17, resposne = 12,image = imageInfiltrator),
        Player( level = 7,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 31, height = 16, strenght = 12,power =  12, skill = 19, resposne = 14,image = imageInfiltrator),
        Player( level = 8,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 34, height = 17, strenght = 13,power =  13, skill = 21, resposne = 16,image = imageInfiltrator),
        Player( level = 9,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 37, height = 19, strenght = 14,power =  14, skill = 23, resposne = 18,image = imageInfiltrator),
        Player( level = 10,name = INFILTRADOR, typeOfPlayer = TYPE_NORMAL, speed = 40, height = 20, strenght = 15,power =  15, skill = 25, resposne = 20,image = imageInfiltrator)
    )


    private val arquitectoLevels = listOf(
        Player( level = 1,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 7, height = 5, strenght = 5,power =  3, skill = 17, resposne = 1,image = imageArquitecto),
        Player( level = 2,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageArquitecto),
        Player( level = 3,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageArquitecto),
        Player( level = 4,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageArquitecto),
        Player( level = 5,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 17, height = 9, strenght = 9,power =  6, skill = 32, resposne = 9,image = imageArquitecto),
        Player( level = 6,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 11, strenght = 11,power =  7, skill = 35, resposne = 12,image = imageArquitecto),
        Player( level = 7,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 12, strenght = 12,power =  8, skill = 39, resposne = 14,image = imageArquitecto),
        Player( level = 8,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 25, height = 13, strenght = 13,power =  8, skill = 43, resposne = 16,image = imageArquitecto),
        Player( level = 9,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 14, strenght = 14,power =  9, skill = 46, resposne = 18,image = imageArquitecto),
        Player( level = 10,name = ARQUITECTO, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 15, strenght = 15,power =  10, skill = 50, resposne = 20,image = imageArquitecto),

    )

    private val producerLevels = listOf(
        Player( level = 1,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProducer),
        Player( level = 2,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 10, height = 8, strenght = 10,power =  10, skill = 16, resposne = 3,image = imageProducer),
        Player( level = 3,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProducer),
        Player( level = 4,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 15, height = 11, strenght = 14,power =  14, skill = 22, resposne = 7,image = imageProducer),
        Player( level = 5,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProducer),
        Player( level = 6,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 14, strenght = 17,power =  17, skill = 28, resposne = 12,image = imageProducer),
        Player( level = 7,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 16, strenght = 19,power =  19, skill = 31, resposne = 14,image = imageProducer),
        Player( level = 8,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 25, height = 17, strenght = 21,power =  21, skill = 34, resposne = 16,image = imageProducer),
        Player( level = 9,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 19, strenght = 23,power =  23, skill = 37, resposne = 18,image = imageProducer),
        Player( level = 10,name = PRODUCER, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 20, strenght = 25,power =  25, skill = 40, resposne = 20,image = imageProducer)
    )

    private val explorerLevels = listOf(
        Player( level = 1,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 14, height = 8, strenght = 7,power =  3, skill = 3, resposne = 11,image = imageExplorer),
        Player( level = 2,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 17, height = 10, strenght = 8,power =  4, skill = 4, resposne = 14,image = imageExplorer),
        Player( level = 3,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageExplorer),
        Player( level = 4,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageExplorer),
        Player( level = 5,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 26, height = 16, strenght = 13,power =  6, skill = 6, resposne = 22,image = imageExplorer),
        Player( level = 6,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 28, height = 17, strenght = 14,power =  7, skill = 7, resposne = 24,image = imageExplorer),
        Player( level = 7,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 31, height = 19, strenght = 16,power =  8, skill = 8, resposne = 27,image = imageExplorer),
        Player( level = 8,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 34, height = 21, strenght = 17,power =  8, skill = 8, resposne = 30,image = imageExplorer),
        Player( level = 9,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 37, height = 23, strenght = 19,power =  9, skill = 9, resposne = 32,image = imageExplorer),
        Player( level = 10,name = EXPLORER, typeOfPlayer = TYPE_NORMAL, speed = 40, height = 25, strenght = 20,power =  10, skill = 10, resposne = 35,image = imageExplorer)
    )


    private val prowlerLevels = listOf(
        Player( level = 1,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProwler),
        Player( level = 2,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProwler),
        Player( level = 3,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProwler),
        Player( level = 4,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageProwler),
        Player( level = 5,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 9, strenght = 9,power =  16, skill = 9, resposne = 34,image = imageProwler),
        Player( level = 6,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 24, height = 11, strenght = 11,power =  17, skill = 11, resposne = 37,image = imageProwler),
        Player( level = 7,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 12, strenght = 12,power =  19, skill = 12, resposne = 40,image = imageProwler),
        Player( level = 8,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 13, strenght = 13,power =  21, skill = 13, resposne = 44,image = imageProwler),
        Player( level = 9,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 32, height = 14, strenght = 14,power =  23, skill = 14, resposne = 47,image = imageProwler),
        Player( level = 10,name = PROWLER, typeOfPlayer = TYPE_NORMAL, speed = 35, height = 15, strenght = 15,power =  25, skill = 15, resposne = 50,image = imageProwler)
    )

    private val menaceLevels = listOf(
        Player( level = 1,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageMenace),
        Player( level = 2,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageMenace),
        Player( level = 3,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 16, height = 12, strenght = 14,power =  14, skill = 10, resposne = 12,image = imageMenace),
        Player( level = 4,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 19, height = 14, strenght = 17,power =  17, skill = 11, resposne = 15,image = imageMenace),
        Player( level = 5,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 16, strenght = 19,power =  19, skill = 13, resposne = 17,image = imageMenace),
        Player( level = 6,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 24, height = 17, strenght = 21,power =  21, skill = 14, resposne = 20,image = imageMenace),
        Player( level = 7,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 19, strenght = 23,power =  23, skill = 16, resposne = 22,image = imageMenace),
        Player( level = 8,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 21, strenght = 26,power =  26, skill = 17, resposne = 25,image = imageMenace),
        Player( level = 9,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 32, height = 23, strenght = 28,power =  28, skill = 19, resposne = 27,image = imageMenace),
        Player( level = 10,name = MENACE, typeOfPlayer = TYPE_NORMAL, speed = 35, height = 25, strenght = 30,power =  30, skill = 20, resposne = 30,image = imageMenace)
    )


    private val speedsTerLevers = listOf(
        Player( level = 1,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 21, height = 3, strenght = 5,power =  5, skill = 3, resposne = 1,image = imageSpeedsTer),
        Player( level = 2,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 24, height = 4, strenght = 6,power =  6, skill = 4, resposne = 3,image = imageSpeedsTer),
        Player( level = 3,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageSpeedsTer),
        Player( level = 4,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageSpeedsTer),
        Player( level = 5,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 34, height = 6, strenght = 9,power =  9, skill = 6, resposne = 9,image = imageSpeedsTer),
        Player( level = 6,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 37, height = 7, strenght = 11,power =  11, skill = 7, resposne = 12,image = imageSpeedsTer),
        Player( level = 7,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 40, height = 8, strenght = 12,power =  12, skill = 8, resposne = 14,image = imageSpeedsTer),
        Player( level = 8,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 44, height = 8, strenght = 13,power =  13, skill = 8, resposne = 16,image = imageSpeedsTer),
        Player( level = 9,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 0, height = 0, strenght = 0,power =  0, skill = 0, resposne = 0,image = imageSpeedsTer),
        Player( level = 10,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 50, height = 10, strenght = 15,power =  15, skill = 10, resposne = 20,image = imageSpeedsTer)
    )

    private val hameerLevels = listOf(
        Player( level = 1,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 1, height = 13, strenght = 15,power =  13, skill = 2, resposne = 1,image = imageHammer),
        Player( level = 2,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 3, height = 16, strenght = 18,power =  16, skill = 2, resposne = 3,image = imageHammer),
        Player( level = 3,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 5, height = 19, strenght = 22,power =  19, skill = 3, resposne = 5,image = imageHammer),
        Player( level = 4,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 7, height = 22, strenght = 25,power =  22, skill = 3, resposne = 7,image = imageHammer),
        Player( level = 5,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 9, height = 25, strenght = 28,power =  25, skill = 3, resposne = 9,image = imageHammer),
        Player( level = 6,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 12, height = 28, strenght = 32,power =  28, skill = 4, resposne = 12,image = imageHammer),
        Player( level = 7,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 14, height = 31, strenght = 35,power =  31, skill = 4, resposne = 14,image = imageHammer),
        Player( level = 8,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 16, height = 34, strenght = 38,power =  34, skill = 4, resposne = 16,image = imageHammer),
        Player( level = 9,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 18, height = 37, strenght = 42,power =  37, skill = 5, resposne = 18,image = imageHammer),
        Player( level = 10,name = HAMMER, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 40, strenght = 45,power =  40, skill = 5, resposne = 20,image = imageHammer)
    )


    private val keeperLevels = listOf(
        Player( level = 1,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 4, height = 12, strenght = 8,power =  12, skill = 13, resposne = 14,image = imageKeeper),
        Player( level = 2,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 6, height = 15, strenght = 10,power =  16, skill = 16, resposne = 17,image = imageKeeper),
        Player( level = 3,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 9, height = 17, strenght = 12,power =  19, skill = 19, resposne = 20,image = imageKeeper),
        Player( level = 4,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 11, height = 20, strenght = 14,power =  22, skill = 22, resposne = 23,image = imageKeeper),
        Player( level = 5,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 13, height = 22, strenght = 16,power =  25, skill = 25, resposne = 26,image = imageKeeper),
        Player( level = 6,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 16, height = 25, strenght = 17,power =  28, skill = 28, resposne = 28,image = imageKeeper),
        Player( level = 7,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 18, height = 27, strenght = 19,power =  31, skill = 31, resposne = 31,image = imageKeeper),
        Player( level = 8,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 30, strenght = 21,power =  34, skill = 34, resposne = 34,image = imageKeeper),
        Player( level = 9,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 32, strenght = 23,power =  37, skill = 37, resposne = 37,image = imageKeeper),
        Player( level = 10,name = KEEPER, typeOfPlayer = TYPE_NORMAL, speed = 25, height = 35, strenght = 25,power =  40, skill = 40, resposne = 40,image = imageKeeper)
    )


    private val gkSweeper = listOf(
        Player( level = 1,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 11, height = 7, strenght = 7,power =  10, skill = 12, resposne = 21,image = imageGkSweeper),
        Player( level = 2,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 14, height = 8, strenght = 8,power =  12, skill = 15, resposne = 24,image = imageGkSweeper),
        Player( level = 3,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 16, height = 10, strenght = 10,power =  14, skill = 17, resposne = 27,image = imageGkSweeper),
        Player( level = 4,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 19, height = 11, strenght = 11,power =  17, skill = 20, resposne = 31,image = imageGkSweeper),
        Player( level = 5,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 22, height = 13, strenght = 13,power =  19, skill = 22, resposne = 34,image = imageGkSweeper),
        Player( level = 6,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 24, height = 14, strenght = 14,power =  21, skill = 25, resposne = 37,image = imageGkSweeper),
        Player( level = 7,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 27, height = 16, strenght = 16,power =  23, skill = 27, resposne = 40,image = imageGkSweeper),
        Player( level = 8,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 30, height = 17, strenght = 17,power =  26, skill = 30, resposne = 44,image = imageGkSweeper),
        Player( level = 9,name = GK_SWEEPER, typeOfPlayer = TYPE_NORMAL, speed = 32, height = 19, strenght = 19,power =  28, skill = 32, resposne = 47,image = imageGkSweeper),
        Player( level = 10,name = SPEEDSTER, typeOfPlayer = TYPE_NORMAL, speed = 35, height = 20, strenght = 20,power =  30, skill = 35, resposne = 50,image = imageGkSweeper)
    )

    private val gkStopper = listOf(
        Player( level = 1,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 1, height = 17, strenght = 10,power =  17, skill = 17, resposne = 11,image = imageGkStopper),
        Player( level = 2,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 3, height = 21, strenght = 12,power =  21, skill = 21, resposne = 14,image = imageGkStopper),
        Player( level = 3,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 5, height = 24, strenght = 14,power =  24, skill = 24, resposne = 16,image = imageGkStopper),
        Player( level = 4,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 7, height = 28, strenght = 17,power =  28, skill = 28, resposne = 19,image = imageGkStopper),
        Player( level = 5,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 9, height = 32, strenght = 19,power =  32, skill = 32, resposne = 22,image = imageGkStopper),
        Player( level = 6,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 12, height = 35, strenght = 21,power =  35, skill = 35, resposne = 24,image = imageGkStopper),
        Player( level = 7,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 14, height = 39, strenght = 23,power =  39, skill = 39, resposne = 27,image = imageGkStopper),
        Player( level = 8,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 16, height = 43, strenght = 26,power =  43, skill = 43, resposne = 30,image = imageGkStopper),
        Player( level = 9,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 18, height = 46, strenght = 28,power =  46, skill = 46, resposne = 32,image = imageGkStopper),
        Player( level = 10,name = GK_STOPPER, typeOfPlayer = TYPE_NORMAL, speed = 20, height = 50, strenght = 30,power =  50, skill = 50, resposne = 35,image = imageGkStopper)
    )


}