package com.example.speedo.mapper

import com.example.speedo.data.BalanceSource
import com.example.speedo.model.Balance

object BalanceMapper {
    fun mapFromSource(source: BalanceSource): Balance {
        // Here you can access the data from BalanceSource
        // and map it to the Balance model as needed.
        return source.getBalance()
    }
}