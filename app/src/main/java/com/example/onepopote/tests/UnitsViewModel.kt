package com.example.onepopote.tests

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.onepopote.AppDatabase
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UnitsViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java,
        "db-units"
    ).build()

    var units by mutableStateOf(listOf<Unit>())
        private set

    // Load initial data from Room asynchronously.
    init {
        GlobalScope.launch {
            var items = db.units().getAll()

            if (items.isEmpty()) {
                val defaultUnit = Unit(1, "ml", "g", selected = true)
                items = listOf(defaultUnit);
            }

            viewModelScope.launch { units = items }
        }
    }
}