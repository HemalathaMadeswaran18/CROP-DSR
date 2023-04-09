package com.example.fyp_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RemedyDAO {
    @Query("SELECT * FROM Remedy")
    List<Remedy> getAll();

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    List<Remedy> loadAllByIds(int[] userIds);
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    Remedy findByName(String first, String last);

    @Insert
    void insert(Remedy... remedys);

    @Delete
    void delete(Remedy user);
}