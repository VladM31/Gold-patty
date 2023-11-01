package com.vlad.nure.utils.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vlad.nure.models.entities.GoldStatisticalEntity
import com.vlad.nure.workers.dao.GoldStatisticalDao

@Database(
    version = 1,
    entities = [
        GoldStatisticalEntity::class
    ]
)
abstract class GoldDataBase : RoomDatabase() {
    abstract fun goldStatisticalDao(): GoldStatisticalDao
}