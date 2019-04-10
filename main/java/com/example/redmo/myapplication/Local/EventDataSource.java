package com.example.redmo.myapplication.Local;

import com.example.redmo.myapplication.Database.IEventDataSource;
import com.example.redmo.myapplication.Event;

import java.util.List;

import io.reactivex.Flowable;

public class EventDataSource implements IEventDataSource {

    private EventDao eventDao;
    private static EventDataSource mInstance;

    public EventDataSource(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public static  EventDataSource getInstance(EventDao eventDao){

        if(mInstance == null){

            mInstance = new EventDataSource(eventDao);

        }
        return mInstance;
    }

    @Override
    public Flowable<Event> getEventById(int eventID) {
        return eventDao.getEventById(eventID);
    }

    @Override
    public Flowable<List<Event>> getAllEvents() {
        return eventDao.getAllEvents();
    }

    @Override
    public void insertEvent(Event... events) {
        eventDao.insertEvent(events);
    }

    @Override
    public void updateEvent(Event... events) {
        eventDao.updateEvent(events);
    }

    @Override
    public void deleteEvent(Event event) {
        eventDao.deleteEvent(event);
    }

    @Override
    public void deleteAllEvents() {
        eventDao.deleteAllEvents();
    }
}
