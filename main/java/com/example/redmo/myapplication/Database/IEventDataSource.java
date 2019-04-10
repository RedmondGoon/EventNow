package com.example.redmo.myapplication.Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.redmo.myapplication.Event;

import java.util.List;

import io.reactivex.Flowable;

public interface IEventDataSource {

    Flowable<Event> getEventById(int eventID);

    Flowable<List<Event>> getAllEvents();

    void  insertEvent(Event... events);

    void  updateEvent(Event... events);

    void deleteEvent(Event event);

    void deleteAllEvents();
}
