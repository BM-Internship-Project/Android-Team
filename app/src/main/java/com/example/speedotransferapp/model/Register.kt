package com.example.speedotransferapp.model

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val country: String,
    val dateOfBirth: String,

    )


data class RegisterResponse(
    val id: Int,
    val token: String,
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword :String ,
    val country: String,
    val dateOfBirth: String


)