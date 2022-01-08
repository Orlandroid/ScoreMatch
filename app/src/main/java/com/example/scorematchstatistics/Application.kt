package com.example.scorematchstatistics

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.example.scorematchstatistics.data.db.DatabasePlayersProvider
import com.example.scorematchstatistics.data.preferences.PreferencesDatabase
import com.example.scorematchstatistics.data.repository.LocalRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class Application : Application(){

    @Inject lateinit var localRepository: LocalRepository
    @Inject lateinit var preferencesDatabase: PreferencesDatabase
    @Inject lateinit var databasePlayersProvider: DatabasePlayersProvider

    override fun onCreate() {
        super.onCreate()
        populateDatabaseLevelPlayers()
        Toast.makeText(this,"DATOS",Toast.LENGTH_SHORT).show()
    }

    private fun populateDatabaseLevelPlayers(){
        if(!preferencesDatabase.isPlayerDataLeveSave()){
            CoroutineScope(Dispatchers.IO).launch{
                localRepository.insertManyPlayer(databasePlayersProvider.getLevelsGuard())
                preferencesDatabase.savePlayerDataLevel()
            }
            return
        }
        CoroutineScope(Dispatchers.IO).launch{
            val level = localRepository.getAllLevelsOfPlayers()
            level.forEach {
                Log.w("JUGADOR",it.toString())
            }
        }
    }

}