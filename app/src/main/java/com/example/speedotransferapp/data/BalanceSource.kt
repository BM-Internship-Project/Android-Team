package com.example.speedotransferapp.data

import com.example.speedotransferapp.model.BalanceResponse

class BalanceSource {
    fun getBalance(): BalanceResponse {
        return BalanceResponse(
            "Available",
             200000)
    }
}

