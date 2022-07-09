package com.example.scorematchstatistics.data.dblvelplayers

import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.data.model.Skills
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuperPlayerDb @Inject constructor() {

    companion object {
        const val TYPE_SUPER = "Super"
        const val GATECRASHER = "Gatecrasher"
        const val MAYOR = "Wolfgang"
        const val INVADER = "Invader"
        const val POACHER = "Poacher"
        const val VOYAGER = "Voyager"
        const val WARRIOR = "Warrior"
        const val JET = "Jet"
        const val BULLDOZER = "Bulldozer"
        const val MARKSMAN = "Marksman"
        const val WIZARD = "Wizard"
    }

    private val imageGatecrasher = R.drawable.gatecrasher
    private val imageMajor = R.drawable.c_major
    private val imageInvader = R.drawable.invader
    private val imagePoacher = R.drawable.poacher
    private val imageVoyager = R.drawable.voyager
    private val imageWarrior = R.drawable.warrios
    private val imageJet = R.drawable.jet
    private val imageBulldozer = R.drawable.matsumoto
    private val imageMarksman = R.drawable.c_marksman_faustinho
    private val imageWizard = R.drawable.wizard

    fun getLevelsGatecrasherSkills(): Player {
        return gatecrasherLevels
    }

    fun getLevelsmayorSkills(): Player {
        return mayorLevels
    }

    fun getInvaderSkills(): Player {
        return invaderLevels
    }

    fun getPoacherLevels(): Player {
        return poacherLevels
    }

    fun getvoyagerLevels(): Player {
        return voyagerLevels
    }

    fun getWarriorLevels(): Player {
        return warriorLevels
    }

    fun getJetLevels(): Player {
        return jetLevels
    }

    fun getBulldozerLevels(): Player {
        return bulldozerLevels
    }

    fun getMarksmanLevels(): Player {
        return marksmanLevels
    }

    fun getWizardLevels(): Player {
        return wizardLevels
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


    private val mayorSkills = listOf(
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

    private val mayorLevels = Player(0, MAYOR, TYPE_SUPER, imageMajor, mayorSkills)


    private val invaderSkills = listOf(
        Skills(speed = 18, height = 10, strenght = 8, power = 3, skill = 7, resposne = 11),
        Skills(speed = 21, height = 12, strenght = 10, power = 4, skill = 8, resposne = 14),
        Skills(speed = 24, height = 14, strenght = 12, power = 5, skill = 10, resposne = 16),
        Skills(speed = 27, height = 17, strenght = 14, power = 5, skill = 11, resposne = 19),
        Skills(speed = 30, height = 19, strenght = 16, power = 6, skill = 13, resposne = 22),
        Skills(speed = 33, height = 21, strenght = 17, power = 7, skill = 14, resposne = 24),
        Skills(speed = 36, height = 23, strenght = 19, power = 8, skill = 16, resposne = 27),
        Skills(speed = 39, height = 26, strenght = 21, power = 8, skill = 17, resposne = 30),
        Skills(speed = 42, height = 28, strenght = 23, power = 9, skill = 19, resposne = 32),
        Skills(speed = 45, height = 30, strenght = 25, power = 10, skill = 20, resposne = 35)
    )

    private val invaderLevels = Player(0, INVADER, TYPE_SUPER, imageInvader, invaderSkills)


    private val poacherSkills = listOf(
        Skills(speed = 11, height = 7, strenght = 8, power = 10, skill = 8, resposne = 21),
        Skills(speed = 14, height = 8, strenght = 10, power = 12, skill = 10, resposne = 24),
        Skills(speed = 16, height = 10, strenght = 12, power = 14, skill = 12, resposne = 27),
        Skills(speed = 19, height = 11, strenght = 14, power = 17, skill = 14, resposne = 31),
        Skills(speed = 22, height = 13, strenght = 16, power = 19, skill = 16, resposne = 34),
        Skills(speed = 24, height = 14, strenght = 17, power = 21, skill = 17, resposne = 37),
        Skills(speed = 27, height = 16, strenght = 19, power = 23, skill = 19, resposne = 40),
        Skills(speed = 30, height = 17, strenght = 21, power = 26, skill = 21, resposne = 44),
        Skills(speed = 32, height = 19, strenght = 23, power = 28, skill = 23, resposne = 47),
        Skills(speed = 35, height = 20, strenght = 25, power = 30, skill = 25, resposne = 50)
    )

    private val poacherLevels = Player(0, POACHER, TYPE_SUPER, imagePoacher, poacherSkills)


    private val voyagerSkills = listOf(
        Skills(speed = 14, height = 12, strenght = 8, power = 3, skill = 5, resposne = 14),
        Skills(speed = 17, height = 15, strenght = 10, power = 4, skill = 6, resposne = 17),
        Skills(speed = 20, height = 17, strenght = 12, power = 5, skill = 7, resposne = 20),
        Skills(speed = 23, height = 20, strenght = 14, power = 5, skill = 8, resposne = 23),
        Skills(speed = 26, height = 22, strenght = 16, power = 6, skill = 9, resposne = 26),
        Skills(speed = 28, height = 25, strenght = 17, power = 7, skill = 11, resposne = 28),
        Skills(speed = 31, height = 27, strenght = 19, power = 8, skill = 12, resposne = 31),
        Skills(speed = 34, height = 30, strenght = 21, power = 8, skill = 13, resposne = 34),
        Skills(speed = 37, height = 32, strenght = 23, power = 9, skill = 14, resposne = 37),
        Skills(speed = 40, height = 35, strenght = 25, power = 10, skill = 15, resposne = 40)
    )

    private val voyagerLevels = Player(0, VOYAGER, TYPE_SUPER, imageVoyager, voyagerSkills)


    private val warriorSkills = listOf(
        Skills(speed = 7, height = 8, strenght = 12, power = 5, skill = 7, resposne = 14),
        Skills(speed = 10, height = 10, strenght = 16, power = 6, skill = 8, resposne = 17),
        Skills(speed = 12, height = 12, strenght = 17, power = 7, skill = 10, resposne = 20),
        Skills(speed = 15, height = 14, strenght = 20, power = 8, skill = 11, resposne = 23),
        Skills(speed = 17, height = 16, strenght = 22, power = 9, skill = 13, resposne = 26),
        Skills(speed = 20, height = 17, strenght = 25, power = 11, skill = 14, resposne = 28),
        Skills(speed = 22, height = 19, strenght = 27, power = 12, skill = 16, resposne = 31),
        Skills(speed = 25, height = 21, strenght = 30, power = 13, skill = 17, resposne = 34),
        Skills(speed = 27, height = 23, strenght = 32, power = 14, skill = 19, resposne = 37),
        Skills(speed = 30, height = 25, strenght = 35, power = 15, skill = 20, resposne = 40)
    )

    private val warriorLevels = Player(0, WARRIOR, TYPE_SUPER, imageWarrior, warriorSkills)


    private val jetSkills = listOf(
        Skills(speed = 21, height = 7, strenght = 8, power = 8, skill = 5, resposne = 4),
        Skills(speed = 24, height = 8, strenght = 10, power = 10, skill = 6, resposne = 6),
        Skills(speed = 27, height = 10, strenght = 12, power = 12, skill = 7, resposne = 9),
        Skills(speed = 31, height = 11, strenght = 14, power = 14, skill = 8, resposne = 11),
        Skills(speed = 34, height = 13, strenght = 16, power = 16, skill = 9, resposne = 13),
        Skills(speed = 37, height = 14, strenght = 17, power = 17, skill = 11, resposne = 16),
        Skills(speed = 40, height = 16, strenght = 19, power = 19, skill = 12, resposne = 18),
        Skills(speed = 44, height = 17, strenght = 21, power = 21, skill = 13, resposne = 20),
        Skills(speed = 47, height = 19, strenght = 23, power = 23, skill = 14, resposne = 23),
        Skills(speed = 50, height = 20, strenght = 25, power = 25, skill = 15, resposne = 25)
    )

    private val jetLevels = Player(0, JET, TYPE_SUPER, imageJet, jetSkills)


    private val bulldozerSkills = listOf(
        Skills(speed = 5, height = 13, strenght = 15, power = 13, skill = 5, resposne = 4),
        Skills(speed = 7, height = 16, strenght = 18, power = 16, skill = 6, resposne = 6),
        Skills(speed = 9, height = 19, strenght = 22, power = 19, skill = 7, resposne = 9),
        Skills(speed = 12, height = 22, strenght = 25, power = 22, skill = 8, resposne = 11),
        Skills(speed = 14, height = 25, strenght = 28, power = 25, skill = 9, resposne = 13),
        Skills(speed = 16, height = 28, strenght = 32, power = 28, skill = 11, resposne = 16),
        Skills(speed = 18, height = 31, strenght = 35, power = 31, skill = 12, resposne = 18),
        Skills(speed = 20, height = 34, strenght = 38, power = 34, skill = 13, resposne = 20),
        Skills(speed = 22, height = 37, strenght = 42, power = 37, skill = 14, resposne = 23),
        Skills(speed = 25, height = 40, strenght = 45, power = 40, skill = 15, resposne = 25)
    )

    private val bulldozerLevels = Player(0, BULLDOZER, TYPE_SUPER, imageBulldozer, bulldozerSkills)


    private val marksmanSkills = listOf(
        Skills(speed = 11, height = 8, strenght = 10, power = 10, skill = 13, resposne = 4),
        Skills(speed = 14, height = 10, strenght = 12, power = 12, skill = 16, resposne = 6),
        Skills(speed = 16, height = 12, strenght = 14, power = 14, skill = 19, resposne = 9),
        Skills(speed = 19, height = 14, strenght = 17, power = 17, skill = 22, resposne = 11),
        Skills(speed = 22, height = 16, strenght = 19, power = 19, skill = 25, resposne = 13),
        Skills(speed = 24, height = 17, strenght = 21, power = 21, skill = 28, resposne = 16),
        Skills(speed = 27, height = 19, strenght = 23, power = 23, skill = 31, resposne = 18),
        Skills(speed = 30, height = 21, strenght = 26, power = 26, skill = 34, resposne = 20),
        Skills(speed = 32, height = 23, strenght = 28, power = 28, skill = 37, resposne = 23),
        Skills(speed = 35, height = 25, strenght = 30, power = 30, skill = 40, resposne = 25)
    )

    private val marksmanLevels = Player(0, MARKSMAN, TYPE_SUPER, imageMarksman, marksmanSkills)


    private val wizardSkills = listOf(
        Skills(speed = 7, height = 7, strenght = 7, power = 5, skill = 17, resposne = 4),
        Skills(speed = 10, height = 8, strenght = 8, power = 6, skill = 21, resposne = 6),
        Skills(speed = 12, height = 10, strenght = 10, power = 7, skill = 24, resposne = 9),
        Skills(speed = 15, height = 11, strenght = 11, power = 8, skill = 28, resposne = 11),
        Skills(speed = 17, height = 13, strenght = 13, power = 9, skill = 32, resposne = 13),
        Skills(speed = 20, height = 14, strenght = 14, power = 11, skill = 35, resposne = 16),
        Skills(speed = 22, height = 16, strenght = 16, power = 12, skill = 39, resposne = 18),
        Skills(speed = 25, height = 17, strenght = 17, power = 13, skill = 43, resposne = 20),
        Skills(speed = 27, height = 19, strenght = 19, power = 14, skill = 46, resposne = 23),
        Skills(speed = 30, height = 20, strenght = 20, power = 15, skill = 50, resposne = 25)
    )

    private val wizardLevels = Player(0, WIZARD, TYPE_SUPER, imageWizard, wizardSkills)


}