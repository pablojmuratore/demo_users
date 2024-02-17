package com.pablojmuratore.demousers.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pablojmuratore.demousers.room.daos.IUsersDao
import com.pablojmuratore.demousers.room.models.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
                instance!!
            }
        }
    }

    abstract fun usersDao(): IUsersDao
}

