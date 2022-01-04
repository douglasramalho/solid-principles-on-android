package com.example.solidprincipleonandroidwithkotlin.framework.local

import com.example.solidprincipleonandroidwithkotlin.data.LocalDataSource
import com.example.solidprincipleonandroidwithkotlin.domain.entity.User

class MemoryDataSource : LocalDataSource {

    private var users = mutableSetOf<User>()

    override fun saveUser(user: User) {
        users.add(user)
    }

    override fun getUsers(): List<User> {
        return users.toList()
    }
}