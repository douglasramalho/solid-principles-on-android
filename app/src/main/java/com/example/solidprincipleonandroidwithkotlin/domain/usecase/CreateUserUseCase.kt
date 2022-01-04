package com.example.solidprincipleonandroidwithkotlin.domain.usecase

import android.util.Log
import com.example.solidprincipleonandroidwithkotlin.data.UserRepository
import com.example.solidprincipleonandroidwithkotlin.dto.UserDto
import com.example.solidprincipleonandroidwithkotlin.dto.toUser

class CreateUserUseCase(private val userRepository: UserRepository) {

    // Single Responsibility Principle
    operator fun invoke(userDto: UserDto) {
        try {
            userRepository.saveUser(userDto.toUser())
        } catch (e: Exception) {
            Log.d(this::class.java.toString(), e.toString())
        }
    }
}