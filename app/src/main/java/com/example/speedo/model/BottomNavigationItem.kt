package com.example.speedo.model

import androidx.annotation.DrawableRes

data class BottomNavigationItem(
    val route : String,
    @DrawableRes val icon: Int,
    val label: String
)