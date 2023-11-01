package com.vlad.nure.factories

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import com.vlad.nure.R
import com.vlad.nure.models.GameplayDrawable

class GameplayDrawableFactoryImpl(
    private val context: Context
) : GameplayDrawableFactory {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun create(): GameplayDrawable {
        val letters = listOf(
            context.getDrawable(R.drawable.letter_a),
            context.getDrawable(R.drawable.letter_ten),
            context.getDrawable(R.drawable.letter_j),
            context.getDrawable(R.drawable.letter_q),
            context.getDrawable(R.drawable.letter_k),
        )

        val activeLetters = listOf(
            context.getDrawable(R.drawable.letter_a_active),
            context.getDrawable(R.drawable.letter_ten_active),
            context.getDrawable(R.drawable.letter_j_active),
            context.getDrawable(R.drawable.letter_q_active),
            context.getDrawable(R.drawable.letter_k_active),
        )

        val map = mutableMapOf<Drawable?,Drawable?>()

        activeLetters.forEachIndexed { index, drawable ->
            map[letters[index]] = drawable
        }
        val bonus = context.getDrawable(R.drawable.bonus)
        map[bonus] = context.getDrawable(R.drawable.super_shine)

        return GameplayDrawable(
            elements = letters,
            activeElements = activeLetters,
            toActive = map,
            bonus = bonus
        )
    }
}