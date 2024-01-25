package com.example.vapassportsample.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.vapassportsample.database.table.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    User getUser();

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
