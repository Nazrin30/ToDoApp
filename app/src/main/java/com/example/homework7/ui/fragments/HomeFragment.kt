package com.example.homework7.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.homework7.R
import com.example.homework7.databinding.FragmentHomeBinding
import com.example.homework7.ui.adapter.ToDosAdapter
import com.example.homework7.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() , SearchView.OnQueryTextListener{
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeFragment = this
        binding.title = "To Do App"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        viewModel.toDosList.observe(viewLifecycleOwner){
            val adapter = ToDosAdapter(requireContext(), it, viewModel)
            binding.adapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        return binding.root
    }

    fun fubButtonClick (it: View){
        Navigation.findNavController(it).navigate(R.id.toSave)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onResume() {
        super.onResume()
       viewModel.loadToDos()
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
       viewModel.search(newText)
        return true
    }


}