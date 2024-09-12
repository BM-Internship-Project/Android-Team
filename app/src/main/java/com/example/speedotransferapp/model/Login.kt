package com.example.speedotransferapp.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val status: String,
    val message: String,
    val token: String?,
    val tokenType: String?
)