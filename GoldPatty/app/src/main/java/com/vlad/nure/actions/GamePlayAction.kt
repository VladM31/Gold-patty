package com.vlad.nure.actions

sealed interface GamePlayAction{
    data class Run(val count: Int) : GamePlayAction
    object End : GamePlayAction
    data class IncreasePoint(val point: Int) : GamePlayAction
}