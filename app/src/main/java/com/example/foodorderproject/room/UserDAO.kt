package com.example.foodorderproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    fun registerUser(userEntity: UserEntity?)

    @Query("SELECT * FROM users WHERE email = (:email) and password = (:password)")
    fun login(email: String?, password: String?): UserEntity?

    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>
}