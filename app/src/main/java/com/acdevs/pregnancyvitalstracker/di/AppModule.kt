package com.acdevs.pregnancyvitalstracker.di

import androidx.room.Room
import com.acdevs.pregnancyvitalstracker.data.local.VitalsDatabase
import com.acdevs.pregnancyvitalstracker.data.repository.VitalsRepository
import com.acdevs.pregnancyvitalstracker.viewmodel.VitalsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Room.databaseBuilder(get(), VitalsDatabase::class.java, "vitals_db").build() }
    single { get<VitalsDatabase>().vitalsDao() }
    single { VitalsRepository(get()) }
    viewModel { VitalsViewModel(get()) }
}