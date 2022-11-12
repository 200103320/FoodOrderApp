package com.example.foodorderproject.room

import android.content.Context
import androidx.room.*


@Database(entities = [UserEntity::class], version = 2)

abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO?

    companion object {
        private const val dbName = "user"
        private var userDatabase: UserDatabase? = null
        @Synchronized
        fun getUserDatabase(context: Context?): UserDatabase? {
            if (userDatabase == null) {
                userDatabase = Room.databaseBuilder(
                    context!!,
                    UserDatabase::class.java, dbName
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return userDatabase
        }
    }
}
