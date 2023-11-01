package com.vlad.nure.usecases

import com.vlad.nure.workers.managers.statistical.GoldStatisticalManager
import com.vlad.nure.models.GoldStatistical
import java.util.Date

class SavePointsUseCase(
    private val repository: GoldStatisticalManager
) {

    suspend fun execute(points: Int) {
        repository.insert(
            GoldStatistical(
                points = points,
                timeOfPlay = Date().time
            )
        )
    }
}