package com.example.homework7.data.datasource

import com.example.homework7.data.entity.ToDos
import com.example.homework7.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDatasource (var tddao : ToDosDao){
    suspend fun loadToDos () : List<ToDos> =
        withContext(Dispatchers.IO){
            tddao.loadToDos()
        }
    suspend fun search(searchText : String) :  List<ToDos>  =
        withContext(Dispatchers.IO){
            tddao.search(searchText)
        }
    suspend fun save (name : String){
        val newToDo = ToDos(0, name)
        tddao.save(newToDo)

    }
    suspend fun update(id:Int, name: String){
        val updateToDo = ToDos(id, name)
        tddao.update(updateToDo)
    }
    suspend fun delete(id:Int){
        val deleteToDo = ToDos(id, "")
        tddao.delete(deleteToDo)
    }
}