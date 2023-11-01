package com.vlad.nure.workers.managers.statistical

import com.vlad.nure.models.GoldStatistical

interface GoldStatisticalManager {
    suspend fun find() : List<GoldStatistical>

    suspend fun insert(statistical: GoldStatistical)
}