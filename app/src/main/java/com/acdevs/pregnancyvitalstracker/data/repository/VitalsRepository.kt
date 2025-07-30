package com.acdevs.pregnancyvitalstracker.data.repository

import com.acdevs.pregnancyvitalstracker.data.local.Vitals
import com.acdevs.pregnancyvitalstracker.data.local.VitalsDao
import kotlinx.coroutines.flow.Flow

class VitalsRepository(private val dao: VitalsDao) {
    val vitals: Flow<List<Vitals>> = dao.getAllVitals()
    suspend fun addVitals(entry: Vitals) = dao.insertVitals(entry)
}
