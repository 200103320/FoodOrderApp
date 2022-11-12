package com.example.foodorderproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    fun registerUser(userEntity: UserEntity?)

    @Query("SELECT * FROM users WHERE userId = (:userId) and password = (:password)")
    fun login(userId: String?, password: String?): UserEntity?
}