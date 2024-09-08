package com.example.speedo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.speedo.constants.AppRoutes.FAVOURITES_ROUTE
import com.example.speedo.constants.AppRoutes.HOME_ROUTE
import com.example.speedo.constants.AppRoutes.TRANSFER_ROUTE
import com.example.speedo.data.BottomNavigationItemsSource
import com.example.speedo.ui.favourite.FavouriteScreen
import com.example.speedo.ui.home.HomeScreen
import com.example.speedo.ui.theme.CosmicLatte
import com.example.speedo.ui.theme.G200
import com.example.speedo.ui.theme.P20
import com.example.speedo.ui.theme.P300
import com.example.speedo.ui.transfer.TransferScreen

@Composable
fun HostScreen(navController: NavHostController) {

val viewModel: HostViewModel = viewModel()
val navController = rememberNavController()
Scaffold(
bottomBar = {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {
        Spacer(modifier = Modifier.padding(8.dp))

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        LaunchedEffect(currentRoute) {
            viewModel.updateItemIndex(currentRoute)
        }

        val destinations = BottomNavigationItemsSource().get()
        destinations.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = viewModel.selectedItemIndex == index,
                onClick = {
                    viewModel.setItemIndex(index)
                    navController.navigate(item.route)
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (viewModel.selectedItemIndex == index) P300 else G200,
                        fontSize = 9.sp
                    )
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp),
                        tint = if (viewModel.selectedItemIndex == index) P300 else G200
                    )
                },
                interactionSource = MutableInteractionSource(),
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
    }
}) { innerPadding ->
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(CosmicLatte, P20)
                )
            )
            .padding(innerPadding)
    ) {
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
        ) {
            composable(HOME_ROUTE) { HomeScreen(navController)}
            composable(TRANSFER_ROUTE) { TransferScreen(navController) }
            composable(FAVOURITES_ROUTE) { FavouriteScreen(navController) }
        }
    }
}
}