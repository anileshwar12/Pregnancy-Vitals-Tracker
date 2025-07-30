package com.acdevs.pregnancyvitalstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acdevs.pregnancyvitalstracker.data.local.Vitals
import com.acdevs.pregnancyvitalstracker.data.repository.VitalsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VitalsViewModel(private val repo: VitalsRepository) : ViewModel() {
    val vitals = repo.vitals.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun logVitals(entry: Vitals) = viewModelScope.launch {
        repo.addVitals(entry)
    }
}
