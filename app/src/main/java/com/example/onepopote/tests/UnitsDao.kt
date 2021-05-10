package com.example.onepopote.tests

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UnitsDao {

    @Query("SELECT * FROM unit")
    fun getAll(): List<Unit>

    @Query("SELECT * FROM unit WHERE selected = 1")
    fun getCurentUnit(): Unit
}