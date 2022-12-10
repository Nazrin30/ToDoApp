package com.example.homework7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.homework7.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(var toDosRepository: ToDosRepository): ViewModel(){
    fun save(name:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.save(name)
        }
    }
}