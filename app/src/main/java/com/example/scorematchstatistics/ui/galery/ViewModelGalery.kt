package com.example.scorematchstatistics.ui.galery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scorematchstatistics.data.db.DatabasePlayersProvider
import com.example.scorematchstatistics.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelGalery @Inject constructor(
    private val localRepository: LocalRepository
) :
    ViewModel() {

    init {
        insertManyLevelOfPlayers()
    }

    private fun insertManyLevelOfPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            //localRepository.insertManyPlayer(databasePlayersProvider.getLevelsGuard())
        }
    }

}