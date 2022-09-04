package com.example.scorematchstatistics.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.scorematchstatistics.data.dblvelplayers.DatabasePlayersProvider
import com.example.scorematchstatistics.data.preferences.PreferencesDatabase
import com.example.scorematchstatistics.data.repository.Repository
import com.example.scorematchstatistics.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var localRepository: Repository

    @Inject
    lateinit var preferencesDatabase: PreferencesDatabase

    @Inject
    lateinit var databasePlayersProvider: DatabasePlayersProvider

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateDatabaseLevelPlayers()
    }

    private fun populateDatabaseLevelPlayers() {
        if (!preferencesDatabase.isPlayerDataLeveSave()) {
            lifecycleScope.launch(Dispatchers.IO) {
                insertNormalPlayer()
                insertSuperPlayer()
                preferencesDatabase.savePlayerDataLevel()
            }
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

    private suspend fun insertSuperPlayer() {
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