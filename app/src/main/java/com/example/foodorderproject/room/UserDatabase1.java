package com.example.foodorderproject.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase1 extends RoomDatabase {
    private static final String dbName = "user";
    private static UserDatabase1 userDatabase;

    public static synchronized UserDatabase1 getUserDatabase(Context context) {

        if(userDatabase == null){
            userDatabase = Room.databaseBuilder(context, UserDatabase1.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return userDatabase;

    }
    public abstract UserDAO userDao();
}
