package com.example.homework7.data.repo

import com.example.homework7.data.datasource.ToDosDatasource
import com.example.homework7.data.entity.ToDos

class ToDosRepository (var toDosDatasource : ToDosDatasource) {
     suspend fun loadToDos () : List<ToDos> = toDosDatasource.loadToDos()
     suspend fun search(searchText:String) : List<ToDos> = toDosDatasource.search(searchText)
     suspend fun save(name : String) = toDosDatasource.save(name)
     suspend fun update(id:Int, name: String) = toDosDatasource.update(id, name)
     suspend fun delete(id:Int) = toDosDatasource.delete(id)
}