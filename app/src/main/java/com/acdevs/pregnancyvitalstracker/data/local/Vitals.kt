package com.acdevs.pregnancyvitalstracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class Vitals(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val heartRate: Int,
    val systolicBP: Int,
    val diastolicBP: Int,
    val weight: Float,
    val kicks: Int,
    val timestamp: Long = System.currentTimeMillis()
)
