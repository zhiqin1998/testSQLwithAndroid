package com.example.zhiqi.testsql;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CarWithProperty.class, Employee.class, Specs.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CarDao getCarDao();

    public abstract EmployeeDao getEmployeeDao();

    public abstract SpecsDao getSpecsDao();

}