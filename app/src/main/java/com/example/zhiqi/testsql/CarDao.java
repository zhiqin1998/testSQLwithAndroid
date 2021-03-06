package com.example.zhiqi.testsql;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CarDao {
    @Query("SELECT * FROM car")
    List<CarWithProperty> getAll();

    @Query("SELECT * FROM car WHERE name = :name")
    List<CarWithProperty> loadByName(String name);

    @Query("SELECT * FROM car WHERE id = :id LIMIT 1")
    CarWithProperty loadById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CarWithProperty... cars);

    @Delete
    void delete(CarWithProperty... cars);

    @Update
    void updateUsers(CarWithProperty... cars);
}
