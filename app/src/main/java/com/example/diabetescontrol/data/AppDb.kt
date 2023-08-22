package com.example.diabetescontrol.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryDbModel::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {



    abstract fun historyDao(): HistoryDao


    companion object{
        private const val DB_NAME = "dbHistory"
        private var db: AppDb? = null
        private val LOCK = Any()

        fun getInstance(context: Context):AppDb {
            synchronized(LOCK){
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDb::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }
}