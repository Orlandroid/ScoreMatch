package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.data.model.Player
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabasePlayersProvider @Inject constructor(
    private val normalPlayersDb: NormalPlayersDb,
    private val superPlayerDb: SuperPlayerDb
) {


    //normal
    fun dbLevelsGuard(): List<Player> {
        return normalPlayersDb.getLevelsGuard()
    }

    fun dbLevelsEngine(): List<Player> {
        return normalPlayersDb.getLevelsEngine()
    }

    fun dbLevelsIntruso(): List<Player> {
        return normalPlayersDb.getLevelsIntruso()
    }

    fun dbLevelsInfiltrator(): List<Player> {
        return normalPlayersDb.getLevelsInfiltrator()
    }

    fun dbLevelsArquitecto(): List<Player> {
        return normalPlayersDb.getLevelsArquitecto()
    }

    fun dbLevelsProducer(): List<Player> {
        return normalPlayersDb.getLevelsProducer()
    }

    fun dbLevelsExplorer(): List<Player> {
        return normalPlayersDb.getLevelsExplorer()
    }

    fun dbLevelsProwler(): List<Player> {
        return normalPlayersDb.getLevelsProwler()
    }

    fun dbLevelsMenace(): List<Player> {
        return normalPlayersDb.getLevelsMenace()
    }

    fun dbLevelsSpeedsTer(): List<Player> {
        return normalPlayersDb.getLevelsSpeedsTer()
    }

    fun dbLevelsHameer(): List<Player> {
        return normalPlayersDb.getLevelsHameer()
    }


    fun dbLevelsKeeper(): List<Player> {
        return normalPlayersDb.getLevelsKeeper()
    }

    fun dbLevelsGkSweeeper(): List<Player> {
        return normalPlayersDb.getLevelsGkSweeper()
    }

    fun dbLevelsGkStopper(): List<Player> {
        return normalPlayersDb.getLevelsGkStopper()
    }

    //super
    fun getLevelsGatecrasher(): List<Player> {
        return listOf(superPlayerDb.getLevelsGatecrasherSkills())
    }

    fun getLevelsmayor(): List<Player> {
        return listOf(superPlayerDb.getLevelsmayorSkills())
    }

    fun getLevelsInvader(): List<Player> {
        return listOf(superPlayerDb.getInvaderSkills())
    }

    fun getPoacherLevels(): List<Player> {
        return listOf(superPlayerDb.getPoacherLevels())
    }

    fun getvoyagerLevels(): List<Player> {
        return listOf(superPlayerDb.getvoyagerLevels())
    }

    fun getWarriorLevels(): List<Player> {
        return listOf(superPlayerDb.getWarriorLevels())
    }

    fun getJetLevels(): List<Player> {
        return listOf(superPlayerDb.getJetLevels())
    }

    fun getBulldozerLevels(): List<Player> {
        return listOf(superPlayerDb.getBulldozerLevels())
    }

    fun getMarksmanLevels(): List<Player> {
        return listOf(superPlayerDb.getMarksmanLevels())
    }

    fun getWizardLevels(): List<Player> {
        return listOf(superPlayerDb.getWizardLevels())
    }




}