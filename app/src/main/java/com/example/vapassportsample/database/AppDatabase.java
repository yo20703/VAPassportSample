package com.example.vapassportsample.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.vapassportsample.database.dao.UserDao;
import com.example.vapassportsample.database.table.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
