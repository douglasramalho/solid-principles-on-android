package com.example.solidprincipleonandroidwithkotlin.presentation

/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.solidprincipleonandroidwithkotlin.data.UserRepositoryImpl
import com.example.solidprincipleonandroidwithkotlin.domain.entity.User
import com.example.solidprincipleonandroidwithkotlin.domain.usecase.CreateUserUseCase
import com.example.solidprincipleonandroidwithkotlin.domain.usecase.GetUsersUseCase
import com.example.solidprincipleonandroidwithkotlin.domain.dto.UserDto
import com.example.solidprincipleonandroidwithkotlin.framework.local.MemoryDataSource

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _usersData = MutableLiveData<List<User>>()
    val usersData: LiveData<List<User>> get() = _usersData

    fun onSaveButtonClicked(userDto: UserDto) {
        saveUser(userDto)
        updateUsersList()
    }

    private fun saveUser(userDto: UserDto) {
        createUserUseCase(userDto)
    }

    private fun updateUsersList() {
        _usersData.value = getUsersUseCase()
    }

    class MainViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val localDataSource = MemoryDataSource()
            val repository = UserRepositoryImpl(localDataSource)
            return MainViewModel(
                CreateUserUseCase(repository),
                GetUsersUseCase(repository)
            ) as T
        }

    }
}*/
