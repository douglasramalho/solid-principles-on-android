package com.example.solidprincipleonandroidwithkotlin.domain.dto

import com.example.solidprincipleonandroidwithkotlin.domain.entity.User
import java.util.*

data class UserDto(
    val name: String,
    val email: String
)

fun UserDto.toUser() = User(
    id = UUID.randomUUID().toString(),
    name = this.name,
    email = this.email
)
