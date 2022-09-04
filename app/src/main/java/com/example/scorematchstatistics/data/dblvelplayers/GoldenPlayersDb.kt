package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.model.Skills
import javax.inject.Singleton

@Singleton
class GoldenPlayersDb constructor() {

    companion object {
        const val TYPE_GOLDEN = "Golden"
        const val THUNDER = "Thunder"
        const val HITMAN = "Hitman"
        const val LIGHTNING = "Lightning"
        const val RAIDER = "Raider"
        const val MAGICIAN = "Magician"
        const val COMPOSER = "Composer"
    }

    private val imageGuard = R.drawable.c_guardia_bechet

    fun getLevelsThunder(): List<Player> = thunderLevels

    fun getLevelshitman(): List<Player> = hitmanLevels

    fun getLevelslightning(): List<Player> = lightningLevels

    fun getLevelsraider(): List<Player> = raiderLevels


    private val thunderSkills = listOf(
        Skills(speed = 4, height = 13, strenght = 15, power = 13, skill = 3, resposne = 1),
        Skills(speed = 6, height = 16, strenght = 18, power = 16, skill = 4, resposne = 3),
        Skills(speed = 9, height = 19, strenght = 22, power = 19, skill = 5, resposne = 5),
        Skills(speed = 11, height = 22, strenght = 25, power = 22, skill = 5, resposne = 7),
        Skills(speed = 13, height = 25, strenght = 28, power = 25, skill = 6, resposne = 9),
        Skills(speed = 16, height = 28, strenght = 32, power = 28, skill = 7, resposne = 12),
        Skills(speed = 18, height = 31, strenght = 35, power = 31, skill = 8, resposne = 14),
        Skills(speed = 20, height = 34, strenght = 38, power = 34, skill = 8, resposne = 16),
        Skills(speed = 23, height = 37, strenght = 42, power = 37, skill = 9, resposne = 18),
        Skills(speed = 25, height = 40, strenght = 45, power = 40, skill = 10, resposne = 20)
    )

    private val thunderLevels = listOf(
        Player(0, THUNDER, TYPE_GOLDEN, imageGuard, thunderSkills)
    )

    private val hitmanSkills = listOf(
        Skills(speed = 11, height = 10, strenght = 8, power = 8, skill = 13, resposne = 1),
        Skills(speed = 14, height = 12, strenght = 10, power = 10, skill = 16, resposne = 3),
        Skills(speed = 16, height = 14, strenght = 12, power = 12, skill = 19, resposne = 5),
        Skills(speed = 19, height = 17, strenght = 14, power = 14, skill = 22, resposne = 7),
        Skills(speed = 22, height = 19, strenght = 16, power = 16, skill = 25, resposne = 9),
        Skills(speed = 24, height = 21, strenght = 17, power = 17, skill = 28, resposne = 12),
        Skills(speed = 27, height = 23, strenght = 19, power = 19, skill = 31, resposne = 14),
        Skills(speed = 30, height = 26, strenght = 21, power = 21, skill = 34, resposne = 16),
        Skills(speed = 32, height = 28, strenght = 23, power = 23, skill = 37, resposne = 18),
        Skills(speed = 35, height = 30, strenght = 25, power = 25, skill = 40, resposne = 20)
    )

    private val hitmanLevels = listOf(
        Player(0, HITMAN, TYPE_GOLDEN, imageGuard, hitmanSkills)
    )


    private val lightningSkills = listOf(
        Skills(speed = 21, height = 13, strenght = 7, power = 7, skill = 5, resposne = 1),
        Skills(speed = 24, height = 16, strenght = 8, power = 8, skill = 6, resposne = 3),
        Skills(speed = 27, height = 19, strenght = 10, power = 10, skill = 7, resposne = 5),
        Skills(speed = 31, height = 22, strenght = 11, power = 11, skill = 8, resposne = 7),
        Skills(speed = 34, height = 25, strenght = 13, power = 13, skill = 9, resposne = 9),
        Skills(speed = 37, height = 28, strenght = 14, power = 14, skill = 11, resposne = 12),
        Skills(speed = 40, height = 31, strenght = 16, power = 16, skill = 12, resposne = 14),
        Skills(speed = 44, height = 34, strenght = 17, power = 17, skill = 13, resposne = 16),
        Skills(speed = 47, height = 37, strenght = 19, power = 19, skill = 14, resposne = 18),
        Skills(speed = 50, height = 40, strenght = 20, power = 20, skill = 15, resposne = 20)
    )

    private val lightningLevels = listOf(
        Player(0, LIGHTNING, TYPE_GOLDEN, imageGuard, lightningSkills)
    )


    private val raiderSkills = listOf(
        Skills(speed = 18, height = 13, strenght = 10, power = 3, skill = 7, resposne = 11),
        Skills(speed = 21, height = 16, strenght = 12, power = 4, skill = 8, resposne = 14),
        Skills(speed = 24, height = 19, strenght = 14, power = 5, skill = 10, resposne = 16),
        Skills(speed = 27, height = 22, strenght = 17, power = 5, skill = 11, resposne = 19),
        Skills(speed = 30, height = 25, strenght = 19, power = 6, skill = 13, resposne = 22),
        Skills(speed = 33, height = 28, strenght = 21, power = 7, skill = 14, resposne = 24),
        Skills(speed = 36, height = 31, strenght = 23, power = 8, skill = 16, resposne = 27),
        Skills(speed = 39, height = 34, strenght = 26, power = 8, skill = 17, resposne = 30),
        Skills(speed = 42, height = 37, strenght = 28, power = 9, skill = 19, resposne = 32),
        Skills(speed = 45, height = 30, strenght = 30, power = 10, skill = 20, resposne = 35)
    )

    private val raiderLevels = listOf(
        Player(0, RAIDER, TYPE_GOLDEN, imageGuard, raiderSkills)
    )


}