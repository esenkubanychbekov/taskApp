package com.e.taskapp_1.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.e.taskapp_1.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
   LiveData<List<Task>>getAll();

    @Insert
    void insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void  delete(Task task);

    @Query("Delete FROM task")
    void deleteAll();

}
