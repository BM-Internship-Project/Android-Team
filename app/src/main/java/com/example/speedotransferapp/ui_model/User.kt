package com.example.speedotransferapp.ui_model

import android.view.SurfaceControl

data class User(

    val name: String,
    val email: String,
    val password: String,
    val country: String,
    val birthDate: String,
    val favourites: List<String>,
    val transactions: List<SurfaceControl.Transaction>
) {
}