package com.example.vapassportsample.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.vapassportsample.database.dao.UserDao;
import com.example.vapassportsample.database.dao.VaccineHistoryDao;
import com.example.vapassportsample.database.table.User;
import com.example.vapassportsample.database.table.VaccineHistory;

@Database(entities = {User.class, VaccineHistory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract VaccineHistoryDao vaccineHistoryDao();
}
