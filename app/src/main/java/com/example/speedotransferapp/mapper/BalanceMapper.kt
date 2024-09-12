package com.example.speedotransferapp.mapper

import com.example.speedotransferapp.data.BalanceSource
import com.example.speedotransferapp.model.BalanceResponse



object BalanceMapper {
    // Convert data model to UI model
    fun mapToView(balanceResponse:BalanceResponse)= balanceResponse.balance.toString() +" LE"
}