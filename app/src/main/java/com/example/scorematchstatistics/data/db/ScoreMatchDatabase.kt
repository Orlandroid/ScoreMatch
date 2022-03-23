package com.example.scorematchstatistics.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.scorematchstatistics.data.db.typeconverter.ListSkillConverter
import com.example.scorematchstatistics.data.model.Player

@Database(entities = [Player::class], version = 3,exportSchema = false)
@TypeConverters(ListSkillConverter::class)
abstract class ScoreMatchDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

}