package com.example.speedo.data

import com.example.speedo.model.Balance

class BalanceSource {
    fun getBalance(): Balance {
        return Balance(
            amount = "20000 EGP"
        )
    }
}
