package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.data.model.Player
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabasePlayersProvider @Inject constructor(private val normalPlayersDb: NormalPlayersDb) {


    fun dbLevelsGuard():List<Player>{
        return normalPlayersDb.getLevelsGuard()
    }


    fun dbLevelsEngine():List<Player>{
        return normalPlayersDb.getLevelsEngine()
    }

    fun dbLevelsIntruso():List<Player>{
        return normalPlayersDb.getLevelsIntruso()
    }

    fun dbLevelsInfiltrator():List<Player>{
        return normalPlayersDb.getLevelsInfiltrator()
    }

    fun dbLevelsArquitecto():List<Player>{
        return normalPlayersDb.getLevelsArquitecto()
    }

    fun dbLevelsProducer():List<Player>{
        return normalPlayersDb.getLevelsProducer()
    }

    fun dbLevelsExplorer():List<Player>{
        return normalPlayersDb.getLevelsExplorer()
    }

    fun dbLevelsProwler():List<Player>{
        return normalPlayersDb.getLevelsProwler()
    }

    fun dbLevelsMenace():List<Player>{
        return normalPlayersDb.getLevelsMenace()
    }

    fun dbLevelsSpeedsTer():List<Player>{
        return normalPlayersDb.getLevelsSpeedsTer()
    }

    fun dbLevelsHameer():List<Player>{
        return normalPlayersDb.getLevelsHameer()
    }


  fun dbLevelsKeeper():List<Player>{
      return normalPlayersDb.getLevelsKeeper()
  }

  fun dbLevelsGkSweeeper():List<Player>{
      return normalPlayersDb.getLevelsGkSweeper()
  }

  fun dbLevelsGkStopper():List<Player>{
      return normalPlayersDb.getLevelsGkStopper()
  }


}