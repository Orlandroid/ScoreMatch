package com.example.scorematchstatistics.ui.galery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class ViewModelGalery @Inject constructor(
    private val localRepository: Repository
) :
    ViewModel() {


    private val _players = MutableLiveData<Result<List<Player>>>()
    val players: LiveData<Result<List<Player>>> get() = _players

    private val _playersByType = MutableLiveData<Result<List<Player>>>()
    val playersByType: LiveData<Result<List<Player>>> get() = _playersByType


    init {
        getAllPlayers()
    }

    fun getAllPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _players.value = Result.Loading
            }
            val players = localRepository.getAllLevelsOfPlayers()
            if (players.isEmpty()) {
                withContext(Dispatchers.Main) {
                    _players.value = Result.EmptyList
                }
                return@launch
            }
            withContext(Dispatchers.Main) {
                _players.value = Result.Success(players)
            }
        }
    }

    fun getAllPlayerByType(typeOfPlayer: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _playersByType.value = Result.Loading
            }
            val players = localRepository.getAllPlayersByType(typeOfPlayer)
            if (players.isEmpty()) {
                withContext(Dispatchers.Main) {
                    _playersByType.value = Result.EmptyList
                }
                return@launch
            }
            try {
                withContext(Dispatchers.Main) {
                    _playersByType.value = Result.Success(players)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _playersByType.value = Result.Error(e.message ?: "Error")
                }
            }
        }
    }


    private fun <T>doLoading(liveData: MutableLiveData<Result<T>>) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                liveData.value = Result.Loading
            }
        }
    }


}