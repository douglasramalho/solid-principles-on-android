package com.example.solidprincipleonandroidwithkotlin.domain.usecase

import com.example.solidprincipleonandroidwithkotlin.data.UserRepository
import com.example.solidprincipleonandroidwithkotlin.domain.entity.User

class GetUsersUseCase(private val userRepository: UserRepository) {

    // Single Responsibility Principle
    operator fun invoke(): List<User> {
        return userRepository.getUsers()
    }
}