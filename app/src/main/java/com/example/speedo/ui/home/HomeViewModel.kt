package com.example.speedo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedo.data.BalanceSource
import com.example.speedo.data.ProfileSource
import com.example.speedo.data.TransactionsSource
import com.example.speedo.mapper.BalanceMapper
import com.example.speedo.model.Balance
import com.example.speedo.model.TransactionItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _transactions = MutableStateFlow<List<TransactionItem>>(emptyList())
    val transactions: StateFlow<List<TransactionItem>> = _transactions.asStateFlow()

    val profile = ProfileSource().getProfile()

    init {
        viewModelScope.launch {
            _transactions.value = TransactionsSource().getTransactions()
        }
    }

    fun getInitials(): String{
        val names = profile.name.split(" ")
        val initials = names.map { it.first() }.joinToString("")
        return initials
    }
    fun getBalance(): String {
        val balanceSource = BalanceSource()
        val balance: Balance = BalanceMapper.mapFromSource(balanceSource)
    return balance.amount
    }
}

