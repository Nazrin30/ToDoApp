package com.example.homework7.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework7.data.datasource.ToDosDatasource
import com.example.homework7.data.repo.ToDosRepository
import com.example.homework7.room.MyDatabase
import com.example.homework7.room.ToDosDao
import com.example.homework7.ui.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
class AppModule {


    @Provides
    @Singleton
    fun provideToDosRepository(toDosDatasource: ToDosDatasource) : ToDosRepository{
        return ToDosRepository(toDosDatasource)
        Log.e("function working", "provideTodosRepository")
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(tddao : ToDosDao) : ToDosDatasource{
        return ToDosDatasource(tddao)
        Log.e("function working", "provideTodosDatasource")
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context): ToDosDao{
        var db = Room.databaseBuilder(context, MyDatabase::class.java, "toDos.sqlite")
            .createFromAsset("toDos.sqlite").build()
        return db.getToDosDao()
        Log.e("function working", "provideTodosRepository")
    }
}