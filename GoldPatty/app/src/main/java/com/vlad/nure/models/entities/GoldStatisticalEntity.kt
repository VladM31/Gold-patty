package com.vlad.nure.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "gold_statistical"
)
data class GoldStatisticalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val points: Int,
    val timeOfPlay: Long
)