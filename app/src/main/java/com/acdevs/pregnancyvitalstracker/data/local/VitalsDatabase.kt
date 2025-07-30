package com.acdevs.pregnancyvitalstracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Vitals::class], version = 1)
abstract class VitalsDatabase : RoomDatabase() {
    abstract fun vitalsDao(): VitalsDao

    companion object {
        fun create(context: Context): VitalsDatabase = Room.databaseBuilder(
            context,
            VitalsDatabase::class.java,
            "vitals_db"
        ).build()
    }
}
