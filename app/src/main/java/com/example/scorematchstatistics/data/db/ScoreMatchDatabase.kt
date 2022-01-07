package com.example.scorematchstatistics.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.scorematchstatistics.data.model.Player

@Database(entities = [Player::class], version = 2,exportSchema = false)
abstract class ScoreMatchDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

}