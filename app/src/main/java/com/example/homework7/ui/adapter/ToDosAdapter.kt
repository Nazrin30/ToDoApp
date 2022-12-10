package com.example.homework7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.R
import com.example.homework7.data.entity.ToDos
import com.example.homework7.databinding.CardDesignBinding
import com.example.homework7.ui.fragments.HomeFragmentDirections
import com.example.homework7.ui.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter( var mContext: Context, var toDosList: List<ToDos>, var viewModel: HomeViewModel)
    : RecyclerView.Adapter<ToDosAdapter.CardDesignHolder>() {
    inner class CardDesignHolder (var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding : CardDesignBinding =
            DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design,  parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val toDo = toDosList.get(position)
        val b = holder.binding
        b.toDo = toDo

        b.cardViewToDo.setOnClickListener{
            val transition = HomeFragmentDirections.toDetail(toDo=toDo)
            Navigation.findNavController(it).navigate(transition)
        }

        b.imageButton.setOnClickListener{
            Snackbar.make(it, "Do you want to delete ${toDo.name}?", Snackbar.LENGTH_LONG)
                .setAction("Yes"){
                    viewModel.deleteToDos(toDo.id)
                }.show()
        }


    }

    override fun getItemCount(): Int {
        return toDosList.size
    }
}