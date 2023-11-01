package com.vlad.nure.workers.managers.statistical

import com.vlad.nure.models.GoldStatistical
import com.vlad.nure.workers.dao.GoldStatisticalDao
import com.vlad.nure.models.entities.GoldStatisticalEntity

class RoomGoldStatisticalManager(
    private val goldStatisticalDao: GoldStatisticalDao
) : GoldStatisticalManager {
    override suspend fun find(): List<GoldStatistical> {
        return goldStatisticalDao.find().map {
            GoldStatistical(
                points = it.points,
                timeOfPlay = it.timeOfPlay
            )
        }
    }

    override suspend fun insert(statistical: GoldStatistical) {
        goldStatisticalDao.insert(
            GoldStatisticalEntity(
                points = statistical.points,
                timeOfPlay = statistical.timeOfPlay
            )
        )
    }
}