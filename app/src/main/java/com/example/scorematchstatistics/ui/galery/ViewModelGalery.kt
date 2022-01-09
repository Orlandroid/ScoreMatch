package com.example.scorematchstatistics.ui.galery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scorematchstatistics.data.Result
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ViewModelGalery @Inject constructor(
    private val localRepository: LocalRepository
) :
    ViewModel() {


    private val _players = MutableLiveData<Result<List<Player>>>()
    val players: LiveData<Result<List<Player>>> get() = _players

    init {
        getAllPlayers()
    }

    fun getAllPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _players.value = Result.Loading
            }
            val players = localRepository.getAllLevelsOfPlayers()
            withContext(Dispatchers.Main) {
                _players.value = Result.Success(players)
            }
        }
    }


}