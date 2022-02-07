package com.example.scorematchstatistics.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.data.repository.Repository
import com.example.scorematchstatistics.data.state.ApiState
import com.example.scorematchstatistics.data.state.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    private val _posts = MutableLiveData<Result<ScorePostResponse>>()
    val posts: LiveData<Result<ScorePostResponse>> get() = _posts

    fun getPostScoreMatch() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _posts.value = Result.Loading
            }
            val response = repository.getPostScoreMatch()
            withContext(Dispatchers.Main) {
                _posts.value = Result.Success(response)
            }
        }
    }


}