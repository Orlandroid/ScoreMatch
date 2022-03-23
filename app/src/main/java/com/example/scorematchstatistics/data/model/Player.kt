package com.example.scorematchstatistics.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.scorematchstatistics.data.db.typeconverter.ListSkillConverter
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val typeOfPlayer: String,
    val image:Int,
    @TypeConverters(ListSkillConverter::class)
    val skills: List<Skills>,
): Parcelable