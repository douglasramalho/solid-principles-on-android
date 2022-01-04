package com.example.solidprincipleonandroidwithkotlin.data

import com.example.solidprincipleonandroidwithkotlin.domain.entity.User

class UserRepositoryImpl(private val localDataSource: LocalDataSource) : UserRepository {

    override fun saveUser(user: User) {
        localDataSource.saveUser(user)
    }

    override fun getUsers(): List<User> {
        return localDataSource.getUsers()
    }
}