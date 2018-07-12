package com.example.zhiqi.testsql;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "employee")
public class Employee {
    @NonNull
    private String name;

    @NonNull
    @PrimaryKey
    private String id;

    public Employee(@NonNull String name, @NonNull String id) {
        this.name = name;
        this.id = id;
    }

    @Ignore
    public String toString() {
        return id + ": " + name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
