package com.example.solidprincipleonandroidwithkotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solidprincipleonandroidwithkotlin.domain.dto.UserDto
import com.example.solidprincipleonandroidwithkotlin.domain.dto.toUser
import com.example.solidprincipleonandroidwithkotlin.framework.local.MemoryDataSource
import com.expertsclub.solidprincipleonandroidwithkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usersAdapter = MainAdapter()
    private val memoryDataSource = MemoryDataSource()

    // private lateinit var viewModel: MainViewModel
    // private lateinit var viewModelFactory: MainViewModel.MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initViewModel()
        initUsersList()
        // observeData()
        setListeners()
    }

    /*private fun initViewModel() {
        viewModelFactory = MainViewModel.MainViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }*/

    private fun initUsersList() {
        binding.recyclerUsers.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = usersAdapter
        }
    }

    /*private fun observeData() {
        viewModel.usersData.observe(this) {
            usersAdapter.submitList(it)
        }
    }*/

    private fun setListeners() {
        binding.buttonSave.setOnClickListener {
            val name = binding.inputTextName.text.toString()
            val email = binding.inputTextEmail.text.toString()
            val userDto = UserDto(name, email)

            // Camada de infra muito acoplada à UI
            memoryDataSource.saveUser(userDto.toUser())
            usersAdapter.submitList(memoryDataSource.getUsers())

            // viewModel.onSaveButtonClicked(userDto)
        }
    }
}