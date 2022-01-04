package com.example.solidprincipleonandroidwithkotlin.framework.local

import com.example.solidprincipleonandroidwithkotlin.domain.entity.User

class MemoryDataSource {

    private var users = mutableSetOf<User>()

    fun saveUser(user: User) {
        users.add(user)
    }

    fun getUsers(): List<User> {
        return users.toList()
    }
}