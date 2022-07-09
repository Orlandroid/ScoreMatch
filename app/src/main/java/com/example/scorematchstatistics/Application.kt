package com.example.scorematchstatistics

import android.app.Application
import android.util.Log
import com.example.scorematchstatistics.data.dblvelplayers.DatabasePlayersProvider
import com.example.scorematchstatistics.data.preferences.PreferencesDatabase
import com.example.scorematchstatistics.data.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import timber.log.Timber.Forest.plant
import javax.inject.Inject


@HiltAndroidApp
class Application : Application() {

    @Inject
    lateinit var localRepository: Repository

    @Inject
    lateinit var preferencesDatabase: PreferencesDatabase

    @Inject
    lateinit var databasePlayersProvider: DatabasePlayersProvider

    override fun onCreate() {
        super.onCreate()
        plant(Timber.DebugTree())
        populateDatabaseLevelPlayers()
    }

    private fun populateDatabaseLevelPlayers() {
        if (!preferencesDatabase.isPlayerDataLeveSave()) {
            CoroutineScope(Dispatchers.IO).launch {
                insertNormalPlayer()
                insertSuperPlayer()
                preferencesDatabase.savePlayerDataLevel()
            }
            return
        }

    }

    private suspend fun insertNormalPlayer() {
        Timber.i("insertando jugadores")
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsGuard())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsEngine())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsIntruso())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsInfiltrator())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsArquitecto())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsProducer())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsExplorer())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsProwler())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsMenace())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsSpeedsTer())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsHameer())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsKeeper())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsGkSweeeper())
        localRepository.insertManyPlayer(databasePlayersProvider.dbLevelsGkStopper())
    }

    private suspend fun insertSuperPlayer(){
        Timber.i("insertando super jugadores")
        localRepository.insertManyPlayer(databasePlayersProvider.getLevelsGatecrasher())
        localRepository.insertManyPlayer(databasePlayersProvider.getLevelsmayor())
        localRepository.insertManyPlayer(databasePlayersProvider.getLevelsInvader())
        localRepository.insertManyPlayer(databasePlayersProvider.getPoacherLevels())
        localRepository.insertManyPlayer(databasePlayersProvider.getvoyagerLevels())
        localRepository.insertManyPlayer(databasePlayersProvider.getWarriorLevels())
        localRepository.insertManyPlayer(databasePlayersProvider.getJetLevels())
        localRepository.insertManyPlayer(databasePlayersProvider.getBulldozerLevels())
        localRepository.insertManyPlayer(databasePlayersProvider.getMarksmanLevels())
        localRepository.insertManyPlayer(databasePlayersProvider.getWizardLevels())
    }




}