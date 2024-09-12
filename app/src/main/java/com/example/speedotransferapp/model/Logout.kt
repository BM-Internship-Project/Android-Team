package com.example.speedotransferapp.model

data class LogoutRequest(
    val token: String
)

data class LogoutResponse(
    val status: String,
    val message: String
)