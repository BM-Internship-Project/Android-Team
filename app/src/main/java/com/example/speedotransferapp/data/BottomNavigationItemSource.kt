package com.example.speedotransferapp.data



import androidx.core.view.OneShotPreDrawListener.add
import com.example.speedotransferapp.R
import com.example.speedotransferapp.constant.AppRoutes.CARDS_ROUTE
import com.example.speedotransferapp.constant.AppRoutes.HOME_ROUTE
import com.example.speedotransferapp.constant.AppRoutes.MORE_ROUTE
import com.example.speedotransferapp.constant.AppRoutes.TRANSACTIONS_ROUTE
import com.example.speedotransferapp.constant.AppRoutes.TRANSFER_ROUTE
import com.example.speedotransferapp.model.BottomNavigationItem

class BottomNavigationItemsSource {
    fun get(): List<BottomNavigationItem> {
        val destinations = mutableListOf<BottomNavigationItem>().apply {
            add(
                BottomNavigationItem(
                    route = HOME_ROUTE,
                    icon = R.drawable.home,
                    label = "Home"
                )
            )
            add(
                BottomNavigationItem(
                    route = TRANSFER_ROUTE,
                    icon = R.drawable.transfer,
                    label = "Transfer"
                )
            )
            add(
                BottomNavigationItem(
                    route = TRANSACTIONS_ROUTE,
                    icon = R.drawable.transaction,
                    label = "Transactions"
                )
            )
            add(
                BottomNavigationItem(
                    route = CARDS_ROUTE,
                    icon = R.drawable.my_cards,
                    label = "My cards"
                )
            )
            add(
                BottomNavigationItem(
                    route = MORE_ROUTE,
                    icon = R.drawable.more,
                    label = "More"
                )
            )
        }

        return destinations
    }
}