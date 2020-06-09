package com.example.m6_sqlite.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {hotels.class},version = 1)
public abstract class RoomConnection extends RoomDatabase {
    private static RoomConnection INSTANCE;

    public abstract hotelsDAO hotelsDAO();

    public static RoomConnection getRoomConnection(Context c){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(c,RoomConnection.class,"hotels.db").allowMainThreadQueries().build();

        }
        return INSTANCE;
    }

    public static void destroyRoomConnection() {
        INSTANCE = null;
    }
}
