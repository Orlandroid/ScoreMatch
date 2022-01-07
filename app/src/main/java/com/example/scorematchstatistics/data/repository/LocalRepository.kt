package com.example.scorematchstatistics.data.repository

import com.example.scorematchstatistics.data.db.PlayerDao
import com.example.scorematchstatistics.data.model.Player
import javax.inject.Inject

class LocalRepository @Inject constructor(private val dao: PlayerDao) {

    suspend fun insertPlayerLevel(player: Player) {
        dao.insertPlayerLevel(player)
    }

    suspend fun insertManyPlayer(players: List<Player>){
        dao.insertManyPlayersLevel(players)
    }

    suspend fun getAllLevelsOfPlayers() {

    }

    suspend fun getLevelOfPlayer(namePlayer: Player) {

    }

}