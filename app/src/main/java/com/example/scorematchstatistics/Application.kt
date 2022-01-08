package com.example.scorematchstatistics

import android.app.Application
import com.example.scorematchstatistics.data.db.DatabasePlayersProvider
import com.example.scorematchstatistics.data.preferences.PreferencesDatabase
import com.example.scorematchstatistics.data.repository.LocalRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class Application : Application() {

    @Inject
    lateinit var localRepository: LocalRepository
    @Inject
    lateinit var preferencesDatabase: PreferencesDatabase
    @Inject
    lateinit var databasePlayersProvider: DatabasePlayersProvider

    override fun onCreate() {
        super.onCreate()
        populateDatabaseLevelPlayers()
    }


    private fun populateDatabaseLevelPlayers() {
        if (!preferencesDatabase.isPlayerDataLeveSave()) {
            CoroutineScope(Dispatchers.IO).launch {
                insertNormalPlayer()
                preferencesDatabase.savePlayerDataLevel()
            }
            return
        }
    }

    private suspend fun insertNormalPlayer(){
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


}