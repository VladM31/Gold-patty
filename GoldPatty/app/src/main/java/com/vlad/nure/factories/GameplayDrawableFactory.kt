package com.vlad.nure.factories

import com.vlad.nure.models.GameplayDrawable

interface GameplayDrawableFactory {
    fun create(): GameplayDrawable
}