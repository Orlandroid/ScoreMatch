package com.example.scorematchstatistics.data.api
import com.example.scorematchstatistics.data.model.ScorePostResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/score")
    suspend fun getPostScoreMatch(): ScorePostResponse

    @GET("/score")
    suspend fun getNextPage(@Query("after") after: String): ScorePostResponse


}