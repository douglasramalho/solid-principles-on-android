package com.example.solidprincipleonandroidwithkotlin.data

import com.example.solidprincipleonandroidwithkotlin.domain.entity.User

interface LocalDataSource {

    fun saveUser(user: User)

    fun getUsers(): List<User>
}