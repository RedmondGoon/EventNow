package com.example.redmo.myapplication.Database;

import com.example.redmo.myapplication.Event;

import java.util.List;

import io.reactivex.Flowable;

public class EventRepository implements IEventDataSource{

    private IEventDataSource mLocalDataSource;

    private static EventRepository mInstance;

    public EventRepository(IEventDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }


    public static EventRepository getmInstance(IEventDataSource mLocalDataSource){

        if(mInstance == null){
            mInstance = new EventRepository(mLocalDataSource);
        }
        return mInstance;
    }
    @Override
    public Flowable<Event> getEventById(int eventID) {
        return mLocalDataSource.getEventById(eventID);
    }

    @Override
    public Flowable<List<Event>> getAllEvents() {
        return mLocalDataSource.getAllEvents();
    }

    @Override
    public void insertEvent(Event... events) {
        mLocalDataSource.insertEvent(events);
    }

    @Override
    public void updateEvent(Event... events) {
        mLocalDataSource.updateEvent(events);
    }

    @Override
    public void deleteEvent(Event event) {
        mLocalDataSource.deleteEvent(event);
    }

    @Override
    public void deleteAllEvents() {
        mLocalDataSource.deleteAllEvents();
    }
}
