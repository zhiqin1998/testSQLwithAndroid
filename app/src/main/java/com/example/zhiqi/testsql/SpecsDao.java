package com.example.zhiqi.testsql;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface SpecsDao {
    @Query("SELECT * FROM specs")
    List<Specs> getAll();

    @Query("SELECT * FROM specs WHERE id = :id LIMIT 1")
    Specs loadById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Specs... specs);

    @Delete
    void delete(Specs... specs);

    @Update
    void updateUsers(Specs... specs);
}
