package com.example.passwordsaver.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.passwordsaver.models.AccountDetails;

@Database(entities = {AccountDetails.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;
    public final static String DATABASE_NAME = "project_database.db";
    public abstract Dao dao();
    public synchronized static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME)
                    .build();

        }
        return sInstance;
    }
}
