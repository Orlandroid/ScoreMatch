package com.example.scorematchstatistics.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.data.repository.Repository
import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.util.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.Exception


@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: Repository,
    private val networkHelper: NetworkHelper
) : ViewModel() {


    private val _posts = MutableLiveData<Result<ScorePostResponse>>()
    val posts: LiveData<Result<ScorePostResponse>> get() = _posts

    fun getPostScoreMatch() {
        if (!networkHelper.isNetworkConnected()) {
            _posts.value = Result.ErrorNetwork(
                error = "Verifica tu conexion de internet"
            )
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _posts.value = Result.Loading
            }
            try {
                val response = repository.getPostScoreMatch()
                withContext(Dispatchers.Main) {
                    _posts.value = Result.Success(response)
                }
            } catch (error: Exception) {
                withContext(Dispatchers.Main) {
                    _posts.value = Result.Error(
                        error = error.toString()
                    )
                }
            }
        }
    }

    private fun getNextPage(after: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _posts.value = Result.Loading
            }
        }
    }


}