package com.example.scorematchstatistics.data.api

import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.data.state.ApiState
import retrofit2.http.GET

interface Api {

    @GET("/score")
    suspend fun getPostScoreMatch(): ScorePostResponse


}