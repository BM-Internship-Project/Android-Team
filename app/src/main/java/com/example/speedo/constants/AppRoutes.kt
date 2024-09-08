package com.example.speedo.constants

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.speedo.constants.AppRoutes.HOME_ROUTE
import com.example.speedo.ui.home.HomeScreen
import com.example.speedo.ui.navigation.HostScreen


object AppRoutes {
    const val HOME_ROUTE = "home"
    const val TRANSFER_ROUTE = "transfer"
    const val TRANSACTIONS_ROUTE = "transactions"
    const val CARDS_ROUTE = "my cards"
    const val MORE_ROUTE = "more"
    const val FAVOURITES_ROUTE = "favourites"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME_ROUTE){
        composable(route = HOME_ROUTE){
            HomeScreen(navController)
        }

        composable(route = AppRoutes.HOME_ROUTE){
           HostScreen(navController)
        }
    }
}