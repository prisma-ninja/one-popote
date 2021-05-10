package com.example.onepopote.tests

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Unit(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "water") val water: String,
    @ColumnInfo(name = "pasta") val pasta: String,
    @ColumnInfo(name = "selected") val selected: Boolean
)