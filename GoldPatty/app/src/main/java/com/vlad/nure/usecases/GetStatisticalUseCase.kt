package com.vlad.nure.usecases

import com.vlad.nure.models.GoldStatistical
import com.vlad.nure.workers.managers.statistical.GoldStatisticalManager

class GetStatisticalUseCase(
    private val goldStatisticalManager: GoldStatisticalManager
) {

    suspend fun execute() : List<GoldStatistical> {
       return goldStatisticalManager.find()
    }
}