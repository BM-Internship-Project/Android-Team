package com.example.speedo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.speedo.constants.AppNavHost
import com.example.speedo.ui.home.HomeScreen
import com.example.speedo.ui.navigation.HostScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           AppNavHost()
            }
    }
}
