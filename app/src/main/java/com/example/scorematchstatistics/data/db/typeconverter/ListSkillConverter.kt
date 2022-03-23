package com.example.scorematchstatistics.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.scorematchstatistics.data.model.Skills
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class ListSkillConverter {

    var gson = Gson()

    @TypeConverter
    fun stringToSkilltList(data: String?): List<Skills>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Skills?>?>() {}.type
        return gson.fromJson<List<Skills>>(data, listType)
    }

    @TypeConverter
    fun skillsListToString(someObjects: List<Skills>?): String? {
        return gson.toJson(someObjects)
    }

}