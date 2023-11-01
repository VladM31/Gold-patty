package com.vlad.nure.workers.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vlad.nure.models.entities.GoldStatisticalEntity

@Dao
interface GoldStatisticalDao {
    @Query("SELECT * FROM gold_statistical order by timeOfPlay desc")
    fun find(): List<GoldStatisticalEntity>

    @Insert
    fun insert(entity: GoldStatisticalEntity)
}