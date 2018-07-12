package com.example.zhiqi.testsql;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "car")
public class CarWithProperty {
    @NonNull
    private String name;

    @NonNull
    @PrimaryKey
    private String id;

    @NonNull
    private String suffix;

    @NonNull
    private String chassis;

    @NonNull
    private String imgpath;

    @NonNull
    private String specsCSV;

    public CarWithProperty(@NonNull String name, @NonNull String id, @NonNull String suffix, @NonNull String chassis, @NonNull String imgpath, @NonNull String specsCSV) {
        this.name = name;
        this.id = id;
        this.suffix = suffix;
        this.chassis = chassis;
        this.imgpath = imgpath;
        this.specsCSV = specsCSV;
    }

    @Ignore
    public String toString() {
        return id + ": " + name + " " + suffix + " " + specsCSV;
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

    @NonNull
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(@NonNull String suffix) {
        this.suffix = suffix;
    }

    @NonNull
    public String getChassis() {
        return chassis;
    }

    public void setChassis(@NonNull String chassis) {
        this.chassis = chassis;
    }

    @NonNull
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(@NonNull String imgpath) {
        this.imgpath = imgpath;
    }

    @NonNull
    public String getSpecsCSV() {
        return specsCSV;
    }

    public void setSpecsCSV(@NonNull String specsCSV) {
        this.specsCSV = specsCSV;
    }
}
