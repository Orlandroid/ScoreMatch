package com.example.scorematchstatistics.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.scorematchstatistics.data.model.Skills
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken

class HashMapConverter {

    @TypeConverter
    fun toHashMap(value: JsonElement): Map<Int, List<Skills>> =
        Gson().fromJson(value, object : TypeToken<Map<Int, List<Skills>>>() {}.type)

    @TypeConverter
    fun fromHashMap(value: Map<Int, List<Skills>>): String =
        Gson().toJson(value)


}