package com.example.scorematchstatistics.data.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesDatabase @Inject constructor(sharedPreferences: SharedPreferences) :
    PreferencesManager(sharedPreferences) {

    fun savePlayerDataLevel() {
        savePreferenceKey(IS_PLAYERS_LEVEL_SAVE, true)
    }

    fun getIsPlayerDataLeveSave(): Boolean {
        return preferences.getBoolean(IS_PLAYERS_LEVEL_SAVE, false)
    }

}