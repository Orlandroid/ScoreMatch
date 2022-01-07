package com.example.scorematchstatistics.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.scorematchstatistics.data.model.Player

@Dao
interface PlayerDao {

    @Insert()
    suspend fun insertPlayerLevel(player: Player)

    @Insert()
    suspend fun insertManyPlayersLevel(player: List<Player>)



}