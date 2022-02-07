package com.example.scorematchstatistics.data.repository


import com.example.scorematchstatistics.data.Result
import com.example.scorematchstatistics.data.api.Api
import com.example.scorematchstatistics.data.db.PlayerDao
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.model.ScorePostResponse
import javax.inject.Inject

class Repository @Inject constructor(private val dao: PlayerDao, private val api: Api) {

    suspend fun getPostScoreMatch(): ScorePostResponse {
        return api.getPostScoreMatch()
    }

    suspend fun insertPlayerLevel(player: Player) {
        dao.insertPlayerLevel(player)
    }

    suspend fun insertManyPlayer(players: List<Player>) {
        dao.insertManyPlayersLevel(players)
    }

    suspend fun getAllLevelsOfPlayers(): List<Player> {
        return dao.getAllPlayer()
    }

    suspend fun getLevelOfPlayer(level: Int, name: String): Player {
        return dao.getLevelOfPlayer(level, name)
    }

}