package com.example.solidprincipleonandroidwithkotlin.data

import com.example.solidprincipleonandroidwithkotlin.domain.entity.User

interface UserRepository {

    fun saveUser(user: User)

    fun getUsers(): List<User>
}