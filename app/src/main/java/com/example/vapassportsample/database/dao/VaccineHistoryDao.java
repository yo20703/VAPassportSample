package com.example.vapassportsample.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.vapassportsample.database.table.VaccineHistory;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface VaccineHistoryDao {
    @Query("SELECT * FROM vaccine_history")
    List<VaccineHistory> getVaccineHistory();

    @Insert
    void addVaccineHistory(VaccineHistory vaccineHistory);

    @Update
    void updateVaccineHistory(VaccineHistory vaccineHistory);

    @Delete
    void deleteVaccineHistory(VaccineHistory vaccineHistory);
}
