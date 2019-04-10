package com.example.redmo.myapplication.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.redmo.myapplication.Event;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface EventDao {
    @Query("SELECT * FROM events WHERE id=:eventID")
    Flowable<Event> getEventById(int eventID);

    @Query("SELECT * FROM events")
    Flowable<List<Event>> getAllEvents();

    @Insert
    void  insertEvent(Event... events);

    @Update
    void  updateEvent(Event... events);

    @Delete
    void deleteEvent(Event event);

    @Query("DELETE FROM events")
    void deleteAllEvents();
}
