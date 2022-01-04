package com.example.solidprincipleonandroidwithkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solidprincipleonandroidwithkotlin.dto.UserDto
import com.expertsclub.solidprincipleonandroidwithkotlin.R
import com.expertsclub.solidprincipleonandroidwithkotlin.databinding.ActivityMainBinding
import com.expertsclub.solidprincipleonandroidwithkotlin.databinding.ItemUserBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usersAdapter = MainAdapter()
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModel.MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initUsersList()
        observeData()
        setListeners()
    }

    private fun initViewModel() {
        viewModelFactory = MainViewModel.MainViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

    private fun initUsersList() {
        binding.recyclerUsers.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = usersAdapter
        }
    }

    private fun observeData() {
        viewModel.usersData.observe(this) {
            usersAdapter.submitList(it)
        }
    }

    private fun setListeners() {
        binding.buttonSave.setOnClickListener {
            viewModel.onSaveButtonClicked(
                UserDto(
                    binding.inputTextName.text.toString(),
                    binding.inputTextEmail.text.toString(),
                )
            )
        }
    }
}