package com.vlad.nure.models

import android.graphics.drawable.Drawable

data class GameplayDrawable(
    val elements: List<Drawable?>,
    val activeElements: List<Drawable?>,
    val toActive: Map<Drawable?,Drawable?>,
    val bonus: Drawable?
)
