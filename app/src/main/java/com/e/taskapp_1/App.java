package com.e.taskapp_1;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.e.taskapp_1.room.MyDataBase;

public class App extends Application {
    private MyDataBase myDataBase;
    public static App instance;



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myDataBase = Room.databaseBuilder(this,
                MyDataBase.class, "mydatabase")
                .allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return instance;
    }

    public MyDataBase getDataBase(){

        return myDataBase;
    }
}
