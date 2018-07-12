package com.example.zhiqi.testsql;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("SELECT * FROM employee WHERE id = :id LIMIT 1")
    Employee loadById(String id);

    @Query("SELECT * FROM employee WHERE name = :name")
    List<Employee> loadByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Employee... employees);

    @Delete
    void delete(Employee... employees);

    @Update
    void updateUsers(Employee... employees);
}
