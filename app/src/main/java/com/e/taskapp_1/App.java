package com.e.taskapp_1;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.e.taskapp_1.room.MyDataBase;

public class App extends Application {
    private static MyDataBase myDataBase;
    public static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myDataBase = Room.databaseBuilder(this,
                MyDataBase.class, "mydatabase").allowMainThreadQueries().build();
    }

    public static MyDataBase getDataBase(){

        return myDataBase;
    }
}
