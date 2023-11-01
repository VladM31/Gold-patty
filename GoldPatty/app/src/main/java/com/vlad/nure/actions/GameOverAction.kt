package com.vlad.nure.actions

sealed interface GameOverAction{
    data class SavePoints(val points: Int) : GameOverAction
}