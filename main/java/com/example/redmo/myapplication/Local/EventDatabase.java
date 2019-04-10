package com.example.redmo.myapplication.Local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.redmo.myapplication.Event;

import static com.example.redmo.myapplication.Local.EventDatabase.DATABASE_VERSION;

@Database(entities = Event.class, version = DATABASE_VERSION)
public abstract class EventDatabase extends RoomDatabase{
    public static  final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "Database-Room";

    public abstract EventDao eventDao();

    private static EventDatabase mInstance;

    public static EventDatabase getInstance(Context context){

        if(mInstance == null){

            mInstance = Room.databaseBuilder(context,EventDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
       return mInstance;
    }


}
