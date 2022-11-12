package com.example.foodorderproject.room

import android.content.Context
import androidx.room.Database
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO?

    companion object {
        private const val dbName = "user"
        private var userDatabase: UserDatabase1? = null
        @Synchronized
        fun getUserDatabase(context: Context?): UserDatabase1? {
            if (userDatabase == null) {
                userDatabase = Room.databaseBuilder(
                    context!!,
                    UserDatabase1::class.java, dbName
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return userDatabase
        }
    }
}
