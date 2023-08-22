package com.example.diabetescontrol.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryDbModel(
    @PrimaryKey
    @ColumnInfo(name = "query")
    val query: String
)
