package com.example.scorematchstatistics.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.scorematchstatistics.data.db.typeconverter.HashMapConverter
import com.example.scorematchstatistics.data.model.Player

@Database(entities = [Player::class], version = 3,exportSchema = false)
@TypeConverters(HashMapConverter::class)
abstract class ScoreMatchDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

}