package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.model.Skills
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NormalPlayersDb @Inject constructor() {

    companion object {
        const val TYPE_NORMAL = "normal"
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
    private val imageProducer = R.drawable.c_productor_santos
    private val imageExplorer = R.drawable.c_explorador_cabrera
    private val imageProwler = R.drawable.c_medoreador_badr
    private val imageMenace = R.drawable.c_amenaza
    private val imageSpeedsTer = R.drawable.c_velocista
    private val imageHammer = R.drawable.c_mazo
    private val imageKeeper = R.drawable.c_portero_schimidt
    private val imageGkSweeper = R.drawable.c_portero_lechner
    private val imageGkStopper = R.drawable.c_portero_taylor


    fun getLevelsGuard(): List<Player> {
        return guardLevels
    }


    fun getLevelsEngine(): List<Player> {
        return engineLevels
    }

    fun getLevelsIntruso(): List<Player> {
        return intrusoLevels
    }

    fun getLevelsInfiltrator(): List<Player> {
        return infiltratorLevels
    }

    fun getLevelsArquitecto(): List<Player> {
        return arquitectoLevels
    }

    fun getLevelsProducer(): List<Player> {
        return producerLevels
    }

    fun getLevelsExplorer(): List<Player> {
        return explorerLevels
    }

    fun getLevelsProwler(): List<Player> {
        return prowlerLevels
    }

    fun getLevelsMenace(): List<Player> {
        return menaceLevels
    }

    fun getLevelsSpeedsTer(): List<Player> {
        return speedsTerLevers
    }

    fun getLevelsHameer(): List<Player> {
        return hameerLevels
    }

    fun getLevelsKeeper():List<Player>{
        return keeperLevels
    }

    fun getLevelsGkSweeper():List<Player>{
        return gkSweeperLevels
    }


    fun getLevelsGkStopper():List<Player>{
        return gkStopperLevels
    }

    private val guardSkills = listOf(
        Skills(speed = 7, height = 5, strenght = 5, power = 3, skill = 17, resposne = 1),
        Skills(speed = 10, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 17, height = 9, strenght = 9, power = 6, skill = 32, resposne = 32),
        Skills(speed = 20, height = 11, strenght = 11, power = 7, skill = 35, resposne = 35),
        Skills(speed = 22, height = 12, strenght = 12, power = 8, skill = 39, resposne = 39),
        Skills(speed = 25, height = 13, strenght = 13, power = 8, skill = 43, resposne = 43),
        Skills(speed = 27, height = 14, strenght = 14, power = 9, skill = 46, resposne = 46),
        Skills(speed = 30, height = 15, strenght = 15, power = 10, skill = 50, resposne = 50),
    )

    private val guardLevels = listOf(
        Player(0, GUARD, TYPE_NORMAL, imageGuard, guardSkills)
    )

    private val engineSkills = listOf(
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 10, height = 10, strenght = 8, power = 8, skill = 8, resposne = 10),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 15, height = 14, strenght = 11, power = 11, skill = 11, resposne = 15),
        Skills(speed = 17, height = 16, strenght = 13, power = 13, skill = 13, resposne = 17),
        Skills(speed = 20, height = 17, strenght = 14, power = 14, skill = 14, resposne = 20),
        Skills(speed = 22, height = 19, strenght = 16, power = 16, skill = 16, resposne = 22),
        Skills(speed = 25, height = 21, strenght = 17, power = 17, skill = 17, resposne = 25),
        Skills(speed = 27, height = 23, strenght = 19, power = 19, skill = 19, resposne = 27),
        Skills(speed = 30, height = 25, strenght = 20, power = 20, skill = 20, resposne = 30)
    )

    private val engineLevels = listOf(
        Player(0, ENGINE, TYPE_NORMAL, imageEngine, engineSkills)
    )


    private val intrusoSkills = listOf(
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 21, height = 6, strenght = 8, power = 4, skill = 6, resposne = 10),
        Skills(speed = 24, height = 7, strenght = 10, power = 5, skill = 7, resposne = 12),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 30, height = 9, strenght = 13, power = 6, skill = 9, resposne = 17),
        Skills(speed = 33, height = 11, strenght = 14, power = 7, skill = 11, resposne = 20),
        Skills(speed = 36, height = 12, strenght = 16, power = 8, skill = 12, resposne = 22),
        Skills(speed = 39, height = 13, strenght = 17, power = 8, skill = 13, resposne = 25),
        Skills(speed = 42, height = 14, strenght = 19, power = 9, skill = 14, resposne = 27),
        Skills(speed = 45, height = 15, strenght = 20, power = 10, skill = 15, resposne = 30)

    )

    private val intrusoLevels = listOf(
        Player(0, INTRUSO, TYPE_NORMAL, imageInstruso, intrusoSkills)
    )


    private val infiltratorSkills = listOf(
        Skills(speed = 14, height = 7, strenght = 5, power = 5, skill = 8, resposne = 1),
        Skills(speed = 17, height = 8, strenght = 6, power = 6, skill = 10, resposne = 3),
        Skills(speed = 20, height = 10, strenght = 7, power = 7, skill = 12, resposne = 5),
        Skills(speed = 23, height = 11, strenght = 8, power = 8, skill = 14, resposne = 7),
        Skills(speed = 26, height = 13, strenght = 9, power = 9, skill = 16, resposne = 9),
        Skills(speed = 28, height = 14, strenght = 11, power = 11, skill = 17, resposne = 12),
        Skills(speed = 31, height = 16, strenght = 12, power = 12, skill = 19, resposne = 14),
        Skills(speed = 34, height = 17, strenght = 13, power = 13, skill = 21, resposne = 16),
        Skills(speed = 37, height = 19, strenght = 14, power = 14, skill = 23, resposne = 18),
        Skills(speed = 40, height = 20, strenght = 15, power = 15, skill = 25, resposne = 20),
    )

    private val infiltratorLevels = listOf(
        Player(0, INFILTRADOR, TYPE_NORMAL, imageInfiltrator, infiltratorSkills)
    )


    private val arquitectoSkills = listOf(
        Skills(speed = 7, height = 5, strenght = 5, power = 3, skill = 17, resposne = 1),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 17, height = 9, strenght = 9, power = 6, skill = 32, resposne = 9),
        Skills(speed = 20, height = 11, strenght = 11, power = 7, skill = 35, resposne = 12),
        Skills(speed = 22, height = 12, strenght = 12, power = 8, skill = 39, resposne = 14),
        Skills(speed = 25, height = 13, strenght = 13, power = 8, skill = 43, resposne = 16),
        Skills(speed = 27, height = 14, strenght = 14, power = 9, skill = 46, resposne = 18),
        Skills(speed = 30, height = 15, strenght = 15, power = 10, skill = 50, resposne = 20),
    )

    private val arquitectoLevels = listOf(
        Player(0, ARQUITECTO, TYPE_NORMAL, imageArquitecto, arquitectoSkills)
    )


    private val producerSkills = listOf(
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 10, height = 8, strenght = 10, power = 10, skill = 16, resposne = 3),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 15, height = 11, strenght = 14, power = 14, skill = 22, resposne = 7),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 20, height = 14, strenght = 17, power = 17, skill = 28, resposne = 12),
        Skills(speed = 22, height = 16, strenght = 19, power = 19, skill = 31, resposne = 14),
        Skills(speed = 25, height = 17, strenght = 21, power = 21, skill = 34, resposne = 16),
        Skills(speed = 27, height = 19, strenght = 23, power = 23, skill = 37, resposne = 18),
        Skills(speed = 30, height = 20, strenght = 25, power = 25, skill = 40, resposne = 20),
    )

    private val producerLevels = listOf(
        Player(0, PRODUCER, TYPE_NORMAL, imageProducer, producerSkills)
    )


    private val explorerSkills = listOf(
        Skills(speed = 14, height = 8, strenght = 7, power = 3, skill = 3, resposne = 11),
        Skills(speed = 14, height = 10, strenght = 8, power = 4, skill = 4, resposne = 14),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 26, height = 16, strenght = 13, power = 6, skill = 6, resposne = 22),
        Skills(speed = 28, height = 17, strenght = 14, power = 7, skill = 7, resposne = 24),
        Skills(speed = 31, height = 19, strenght = 16, power = 8, skill = 8, resposne = 27),
        Skills(speed = 34, height = 21, strenght = 17, power = 8, skill = 8, resposne = 30),
        Skills(speed = 37, height = 23, strenght = 19, power = 9, skill = 9, resposne = 32),
        Skills(speed = 40, height = 25, strenght = 20, power = 10, skill = 10, resposne = 35),
    )

    private val explorerLevels = listOf(
        Player(0, EXPLORER, TYPE_NORMAL, imageExplorer, explorerSkills)
    )


    private val prowlerSkills = listOf(
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 22, height = 9, strenght = 9, power = 16, skill = 9, resposne = 34),
        Skills(speed = 24, height = 11, strenght = 11, power = 17, skill = 11, resposne = 37),
        Skills(speed = 27, height = 12, strenght = 12, power = 19, skill = 12, resposne = 40),
        Skills(speed = 30, height = 13, strenght = 13, power = 21, skill = 13, resposne = 44),
        Skills(speed = 32, height = 14, strenght = 14, power = 23, skill = 14, resposne = 47),
        Skills(speed = 35, height = 15, strenght = 15, power = 25, skill = 15, resposne = 50),
    )

    private val prowlerLevels = listOf(
        Player(0, PROWLER, TYPE_NORMAL, imageProwler, prowlerSkills)
    )


    private val menaceSkills = listOf(
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 16, height = 12, strenght = 14, power = 14, skill = 10, resposne = 12),
        Skills(speed = 19, height = 14, strenght = 17, power = 17, skill = 11, resposne = 15),
        Skills(speed = 22, height = 16, strenght = 19, power = 19, skill = 13, resposne = 17),
        Skills(speed = 24, height = 17, strenght = 21, power = 21, skill = 14, resposne = 20),
        Skills(speed = 27, height = 19, strenght = 23, power = 23, skill = 16, resposne = 22),
        Skills(speed = 30, height = 21, strenght = 26, power = 26, skill = 17, resposne = 25),
        Skills(speed = 32, height = 23, strenght = 28, power = 28, skill = 19, resposne = 27),
        Skills(speed = 35, height = 25, strenght = 30, power = 30, skill = 20, resposne = 30),
    )

    private val menaceLevels = listOf(
        Player(0, MENACE, TYPE_NORMAL, imageMenace, menaceSkills)
    )


    private val speedtesrSkills = listOf(
        Skills(speed = 21, height = 3, strenght = 5, power = 5, skill = 3, resposne = 1),
        Skills(speed = 24, height = 4, strenght = 6, power = 6, skill = 4, resposne = 3),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 34, height = 6, strenght = 9, power = 9, skill = 6, resposne = 9),
        Skills(speed = 37, height = 7, strenght = 11, power = 11, skill = 7, resposne = 12),
        Skills(speed = 40, height = 8, strenght = 12, power = 12, skill = 8, resposne = 14),
        Skills(speed = 44, height = 8, strenght = 13, power = 13, skill = 8, resposne = 16),
        Skills(speed = 0, height = 0, strenght = 0, power = 0, skill = 0, resposne = 0),
        Skills(speed = 50, height = 10, strenght = 15, power = 15, skill = 10, resposne = 20)
    )

    private val speedsTerLevers = listOf(
        Player(0, SPEEDSTER, TYPE_NORMAL, imageSpeedsTer, speedtesrSkills)
    )


    private val hammerSkills = listOf(
        Skills(speed = 1, height = 13, strenght = 15, power = 13, skill = 2, resposne = 1),
        Skills(speed = 3, height = 16, strenght = 18, power = 16, skill = 2, resposne = 13),
        Skills(speed = 5, height = 19, strenght = 22, power = 19, skill = 3, resposne = 5),
        Skills(speed = 7, height = 22, strenght = 25, power = 22, skill = 3, resposne = 7),
        Skills(speed = 9, height = 25, strenght = 28, power = 13, skill = 2, resposne = 9),
        Skills(speed = 12, height = 28, strenght = 32, power = 28, skill = 4, resposne = 12),
        Skills(speed = 14, height = 31, strenght = 35, power = 31, skill = 4, resposne = 14),


        Skills(speed = 16, height = 34, strenght = 38, power = 34, skill = 4, resposne = 16),
        Skills(speed = 18, height = 37, strenght = 42, power = 37, skill = 5, resposne = 18),
        Skills(speed = 20, height = 40, strenght = 45, power = 40, skill = 5, resposne = 20),

        )

    private val hameerLevels = listOf(
        Player(0, HAMMER, TYPE_NORMAL, imageHammer, hammerSkills)
    )

    private val keeperSkills = listOf(
        Skills(speed = 4, height = 12, strenght = 8, power = 12, skill = 13, resposne = 14),
        Skills(speed = 6, height = 15, strenght = 10, power = 16, skill = 16, resposne = 17),
        Skills(speed = 9, height = 17, strenght = 12, power = 19, skill = 19, resposne = 20),
        Skills(speed = 11, height = 20, strenght = 14, power = 22, skill = 22, resposne = 23),
        Skills(speed = 13, height = 22, strenght = 16, power = 25, skill = 25, resposne = 26),
        Skills(speed = 16, height = 25, strenght = 17, power = 28, skill = 28, resposne = 28),
        Skills(speed = 18, height = 27, strenght = 19, power = 31, skill = 31, resposne = 31),
        Skills(speed = 20, height = 30, strenght = 21, power = 34, skill = 34, resposne = 34),
        Skills(speed = 22, height = 32, strenght = 23, power = 37, skill = 37, resposne = 37),
        Skills(speed = 25, height = 35, strenght = 25, power = 40, skill = 40, resposne = 40)
    )

    private val keeperLevels = listOf(
        Player(0, KEEPER, TYPE_NORMAL, imageKeeper, keeperSkills)
    )


    private val gkSweeperSkills = listOf(
        Skills(speed = 11, height = 7, strenght = 7, power = 10, skill = 12, resposne = 21),
        Skills(speed = 14, height = 8, strenght = 8, power = 12, skill = 15, resposne = 24),
        Skills(speed = 16, height = 10, strenght = 10, power = 14, skill = 17, resposne = 27),
        Skills(speed = 19, height = 11, strenght = 11, power = 17, skill = 20, resposne = 31),
        Skills(speed = 22, height = 13, strenght = 13, power = 19, skill = 22, resposne = 34),
        Skills(speed = 24, height = 14, strenght = 14, power = 21, skill = 25, resposne = 37),
        Skills(speed = 27, height = 16, strenght = 16, power = 23, skill = 27, resposne = 40),
        Skills(speed = 30, height = 17, strenght = 17, power = 26, skill = 30, resposne = 44),
        Skills(speed = 32, height = 19, strenght = 19, power = 28, skill = 32, resposne = 47),
        Skills(speed = 35, height = 20, strenght = 20, power = 20, skill = 35, resposne = 50)
    )

    private val gkSweeperLevels = listOf(
        Player(0, GK_SWEEPER, TYPE_NORMAL, imageGkSweeper, gkSweeperSkills)
    )

    private val gkStopperSkills = listOf(
        Skills(speed = 1, height = 17, strenght = 10, power = 17, skill = 17, resposne = 11),
        Skills(speed = 3, height = 21, strenght = 12, power = 21, skill = 21, resposne = 14),
        Skills(speed = 5, height = 24, strenght = 14, power = 24, skill = 24, resposne = 16),
        Skills(speed = 7, height = 28, strenght = 17, power = 28, skill = 28, resposne = 19),
        Skills(speed = 9, height = 32, strenght = 19, power = 32, skill = 32, resposne = 22),
        Skills(speed = 12, height = 35, strenght = 21, power = 35, skill = 35, resposne = 24),
        Skills(speed = 14, height = 39, strenght = 23, power = 39, skill = 39, resposne = 27),
        Skills(speed = 16, height = 43, strenght = 26, power = 43, skill = 43, resposne = 30),
        Skills(speed = 18, height = 46, strenght = 28, power = 46, skill = 46, resposne = 32),
        Skills(speed = 20, height = 50, strenght = 30, power = 50, skill = 50, resposne = 35)
    )

    private val gkStopperLevels = listOf(
        Player(0, GK_STOPPER, TYPE_NORMAL, imageGkStopper, gkStopperSkills)
    )

}