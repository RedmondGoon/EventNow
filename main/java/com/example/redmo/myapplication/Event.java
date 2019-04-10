package com.example.redmo.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "events")
public class Event {
    @NonNull
    //@PrimaryKey(autoGenerate = true)
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "category")
    private String category; //change to enum

    @ColumnInfo(name = "startdate")
    private String startdatetime;

    @ColumnInfo(name = "enddate")
    private String enddatetime;

    @ColumnInfo(name = "imgurl")
    private String img;


    public Event(){
    }

    @Ignore
    public Event(int id, String name, String location, String category, String startdatetime, String enddatetime, String img) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
        this.startdatetime = startdatetime;
        this.enddatetime = enddatetime;

        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartdatetime() {
        return startdatetime;
    }

    public void setStartdatetime(String startdatetime) {
        this.startdatetime = startdatetime;
    }

    public String getEnddatetime() {
        return enddatetime;
    }

    public void setEnddatetime(String enddatetime) {
        this.enddatetime = enddatetime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return new StringBuilder(name).append("\n").append(location).append("\n")
                .append(category).append("\n").append(startdatetime).append("\n")
                .append(enddatetime).append("\n").append(img).append("\n").toString();
    }
}
