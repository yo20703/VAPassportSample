package com.example.vapassportsample.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vaccine_history")
public class VaccineHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "is_check")
    public Boolean isCheck;
    @ColumnInfo(name = "status1")
    public String status1;
    @ColumnInfo(name = "status2")
    public String status2;

    public VaccineHistory(Boolean isCheck, String status1, String status2) {
        this.isCheck = isCheck;
        this.status1 = status1;
        this.status2 = status2;
    }
}
