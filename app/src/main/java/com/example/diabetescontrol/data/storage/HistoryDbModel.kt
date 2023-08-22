package com.example.diabetescontrol.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//History item
@Entity(tableName = "history")
data class HistoryDbModel(
    @PrimaryKey
    @ColumnInfo(name = "query")
    val query: String
)
