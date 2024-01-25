package com.example.vapassportsample.database.table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "birthday")
    public String birthday;
    @NonNull
    @PrimaryKey
    public String number;
}
