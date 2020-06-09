package com.example.m6_sqlite.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface hotelsDAO {
    @Insert
    void insertAll(hotels... hotels);

    @Query("SELECT * FROM hospitals")
    List<hotels> getAll();


    @Query("SELECT * FROM hospitals where Cif= :cifmio")
    hotels getAllCif(String cifmio);

    @Delete
    void delete(hotels hotels);

    @Update
    void upadate(hotels hotels);





}
