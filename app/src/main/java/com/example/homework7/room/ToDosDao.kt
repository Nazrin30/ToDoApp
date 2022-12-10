package com.example.homework7.room

import androidx.room.*
import com.example.homework7.data.entity.ToDos

@Dao
interface ToDosDao {
@Query("SELECT * FROM toDos")
suspend fun loadToDos() : List<ToDos>

@Query("SELECT * FROM toDos where name like '%' || :searchText ||'%'")
suspend fun search(searchText : String) : List<ToDos>

@Insert
suspend fun save(toDo: ToDos)

@Update
suspend fun update(toDo: ToDos)

@Delete
suspend fun delete(toDo: ToDos)
}

