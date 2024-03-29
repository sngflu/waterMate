package com.example.watermate.ui.dehydration

import androidx.lifecycle.ViewModel
import com.example.watermate.models.DehydrationLevel

class DehydrationViewModel : ViewModel() {

    fun calculateDehydration(appearanceValue: Int, eyesValue: Int, mucousValue: Int, tearsValue: Int): String {
        val eyesEvaluator: String
        val appearanceEvaluator: String
        val mucousEvaluator: String
        val tearsEvaluator: String

        when (eyesValue) {
            0 -> eyesEvaluator =  "Normal"
            1 -> eyesEvaluator = "Light sleepiness"
            2 -> eyesEvaluator = "Drowsy"
            else -> eyesEvaluator = "None"
        }
        when (appearanceValue) {
            0 -> appearanceEvaluator = "Normal"
            1 -> appearanceEvaluator = "Irritable"
            2 -> appearanceEvaluator = "Sluggish"
            else -> appearanceEvaluator = "None"
        }
        when (mucousValue) {
            0 -> mucousEvaluator = "Wet"
            1 -> mucousEvaluator = "Sticky"
            2 -> mucousEvaluator = "Dry"
            else -> mucousEvaluator = "None"
        }
        when (tearsValue) {
            0 -> tearsEvaluator = "Yes"
            1 -> tearsEvaluator = "Few"
            2 -> tearsEvaluator = "No"
            else -> tearsEvaluator = "None"
        }

        val dehydrationLevel = DehydrationLevel(eyes = eyesEvaluator,
            appearance =  appearanceEvaluator, mucous = mucousEvaluator,
            tears = tearsEvaluator)

        val points = dehydrationLevel.getPoints()

        val message = when {
            points == 0 -> "You're doing great!"
            points == 1 -> "I degree of dehydration"
            points <= 4 -> "II degree of dehydration"
            else -> "III degree of dehydration"
        }
        return "Points count: $points\n$message"
    }
}