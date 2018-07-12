package com.example.zhiqi.testsql;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "car")
public class CarWithProperty {
    @NonNull
    private String model;

    @NonNull
    @PrimaryKey
    private String variation;

    @ColumnInfo
    private String someSpecs;

    @ColumnInfo
    private String someOtherSpecs;

    public CarWithProperty(String model, String variation, String someSpecs, String someOtherSpecs) {
        this.model = model;
        this.variation = variation;
        this.someSpecs = someSpecs;
        this.someOtherSpecs = someOtherSpecs;
    }

    @Ignore
    public String toString() {
        return model + "  " + variation + " " + someSpecs + " " + someOtherSpecs;
    }

    @NonNull
    public String getModel() {
        return model;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    @NonNull
    public String getVariation() {
        return variation;
    }

    public void setVariation(@NonNull String variation) {
        this.variation = variation;
    }

    public String getSomeSpecs() {
        return someSpecs;
    }

    public void setSomeSpecs(String someSpecs) {
        this.someSpecs = someSpecs;
    }

    public String getSomeOtherSpecs() {
        return someOtherSpecs;
    }

    public void setSomeOtherSpecs(String someOtherSpecs) {
        this.someOtherSpecs = someOtherSpecs;
    }
}
