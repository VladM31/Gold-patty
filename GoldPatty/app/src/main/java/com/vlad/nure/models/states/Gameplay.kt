package com.vlad.nure.models.states

import android.graphics.drawable.Drawable
import com.vlad.nure.models.condition.GameplayCondition

data class Gameplay(
    val points: Int = 0,
    val time : Int = START_TIME,
    val drawables: List<Drawable?> = listOf(),
    val toActive: Map<Drawable?,Drawable?> = mapOf(),
    val condition: GameplayCondition = GameplayCondition.WAIT,
    val bonus: Drawable? = null
){
    companion object{
        const val START_TIME = 5
    }
}
