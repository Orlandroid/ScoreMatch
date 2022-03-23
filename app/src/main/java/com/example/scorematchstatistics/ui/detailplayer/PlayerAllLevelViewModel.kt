package com.example.scorematchstatistics.ui.detailplayer

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
import javax.inject.Inject

@HiltViewModel
class PlayerAllLevelViewModel @Inject constructor(
    private val localRepository: Repository
) : ViewModel() {


    private val _player = MutableLiveData<Result<Player>>()
    val player: LiveData<Result<Player>> get() = _player

    fun getLevelOfPlayer(name: String) {
        _player.value = Result.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val reponse = localRepository.getLevelOfPlayer(name)
            withContext(Dispatchers.Main) {
                _player.value = Result.Success(reponse)
                Log.w("RESPONSE",reponse.toString())
            }
        }
    }

}