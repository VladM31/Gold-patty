package com.vlad.nure.actions

sealed interface PointsAction{
    data object LoadStatistical : PointsAction
}