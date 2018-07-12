package com.example.zhiqi.testsql;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "specs")
public class Specs {
    @NonNull
    @PrimaryKey
    private String id;

    @NonNull
    private String criteria;

    @NonNull
    private String choicesCSV;

    @NonNull
    private String coordinate;

    @NonNull
    private String imgpath;

    public Specs(@NonNull String id, @NonNull String criteria, @NonNull String choicesCSV, @NonNull String coordinate, @NonNull String imgpath) {
        this.id = id;
        this.criteria = criteria;
        this.choicesCSV = choicesCSV;
        this.coordinate = coordinate;
        this.imgpath = imgpath;
    }

    @Ignore
    public String toString() {
        return id + ": " + criteria + " " + choicesCSV + " " + coordinate;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(@NonNull String imgpath) {
        this.imgpath = imgpath;
    }

    @NonNull
    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(@NonNull String criteria) {
        this.criteria = criteria;
    }

    @NonNull
    public String getChoicesCSV() {
        return choicesCSV;
    }

    public void setChoicesCSV(@NonNull String choicesCSV) {
        this.choicesCSV = choicesCSV;
    }

    @NonNull
    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(@NonNull String coordinate) {
        this.coordinate = coordinate;
    }
}