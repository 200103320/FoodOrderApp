package com.example.foodorderproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "userID")
    var userID: String? = null

    @ColumnInfo(name = "password")
    var password: String? = null

    @ColumnInfo(name = "name")
    var name: String? = null


}
