package com.example.speedotransferapp.data

import com.example.speedotransferapp.R
import com.example.speedotransferapp.model.ServiceItem

class ServicesSource {
    fun getServices(): List<ServiceItem> {
        val services = mutableListOf<ServiceItem>().apply {
            add(
                ServiceItem(
                    R.drawable.transfer,
                    "Transfer"
                )
            )
            add(
                ServiceItem(
                    R.drawable.transaction,
                    "Transactions"
                )
            )
            add(
                ServiceItem(
                    R.drawable.my_cards,
                    "Cards"
                )
            )
            add(
                ServiceItem(
                    R.drawable.account,
                    "Account"
                )
            )
        }
        return services
    }
}