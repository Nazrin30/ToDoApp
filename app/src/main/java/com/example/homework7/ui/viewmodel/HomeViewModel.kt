package com.example.homework7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework7.data.entity.ToDos
import com.example.homework7.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( var toDosRepository: ToDosRepository) : ViewModel(){
    var toDosList = MutableLiveData<List<ToDos>>()
    init {
        loadToDos()
    }

    fun deleteToDos(id:Int){
       CoroutineScope(Dispatchers.Main).launch {
           toDosRepository.delete(id)
           loadToDos()
       }
    }

    fun loadToDos (){
        CoroutineScope(Dispatchers.Main).launch {
           toDosList.value =  toDosRepository.loadToDos()
        }

    }

    fun search (searchText : String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.search(searchText)
        }
    }
}