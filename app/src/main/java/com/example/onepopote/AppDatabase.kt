package com.example.onepopote

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.onepopote.tests.UnitsDao

@Database(entities = arrayOf(com.example.onepopote.tests.Unit::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun units(): UnitsDao

}
