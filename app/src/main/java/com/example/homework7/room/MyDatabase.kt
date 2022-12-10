package com.example.homework7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework7.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getToDosDao() : ToDosDao
}