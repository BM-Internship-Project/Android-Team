package com.example.speedotransferapp.data
class LogoutData{
data class LogoutRequest(
    val token: String
)

data class LogoutResponse(
    val status: String,
    val message: String
)}