package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.model.Skills
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuperPlayerDb @Inject constructor() {

    companion object {
        const val TYPE_SUPER = "Super"
        const val GATECRASHER = "Gatecrasher"
        const val INVADER = "Invader"
        const val POACHER = "Poacher"
        const val VOYAGER = "Voyager"
        const val WARRIOR = "Warrior"
        const val JET = "Jet"
        const val BULLDOZER = "Bulldozer"
        const val MARKSMAN = "Marksman"
        const val WIZARD = "Wizard"
    }

    private val imageGatecrasher = 1
    private val imageInvader = 1
    private val imagePoacher = 1
    private val imageVoyager = 1
    private val imageWarrior = 1
    private val imageJet = 1
    private val imageBulldozer = 1
    private val imageMarksman = 1
    private val imageWizard = 1

    fun getLevelsGatecrasherSkills(): Player {
        return gatecrasherLevels
    }

    private val gatecrasherSkills = listOf(
        Skills(speed = 4, height = 17, strenght = 13, power = 3, skill = 3, resposne = 21),
        Skills(speed = 6, height = 21, strenght = 16, power = 4, skill = 4, resposne = 24),
        Skills(speed = 9, height = 24, strenght = 19, power = 5, skill = 5, resposne = 27),
        Skills(speed = 11, height = 28, strenght = 22, power = 5, skill = 5, resposne = 31),
        Skills(speed = 13, height = 32, strenght = 25, power = 6, skill = 6, resposne = 34),
        Skills(speed = 16, height = 35, strenght = 28, power = 7, skill = 7, resposne = 37),
        Skills(speed = 18, height = 39, strenght = 31, power = 8, skill = 8, resposne = 40),
        Skills(speed = 20, height = 43, strenght = 34, power = 8, skill = 8, resposne = 44),
        Skills(speed = 23, height = 46, strenght = 37, power = 9, skill = 9, resposne = 47),
        Skills(speed = 25, height = 50, strenght = 40, power = 10, skill = 10, resposne = 50)
    )

    private val gatecrasherLevels =
        Player(0, GATECRASHER, TYPE_SUPER, imageGatecrasher, gatecrasherSkills)


}