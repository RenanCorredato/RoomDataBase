package com.renancorredato.cadastroroomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.renancorredato.cadastroroomdatabase.database.dao.ClientDao
import com.renancorredato.cadastroroomdatabase.database.model.Client

@Database(entities = [Client::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao

    companion object {
        private const val DATABASE_NAME = "db"

        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {

            return if (INSTANCE != null) {
                INSTANCE !!
            } else {
                synchronized(this){
                    INSTANCE ?: buildDatabase(context).also {
                        INSTANCE = it
                    }
                }
            }
        }

        private fun buildDatabase(conttext: Context): AppDatabase =
            Room.databaseBuilder(
                conttext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}