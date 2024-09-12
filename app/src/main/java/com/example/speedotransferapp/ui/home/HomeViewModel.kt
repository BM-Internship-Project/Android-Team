package com.example.speedotransferapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransferapp.api.RetrofitClient
import com.example.speedotransferapp.api.TransactionAPICallable
import com.example.speedotransferapp.api.TransactionAPIService
import com.example.speedotransferapp.api.UserAPICallable
import com.example.speedotransferapp.constant.AppConstants.BEARER
import com.example.speedotransferapp.data.BalanceSource
import com.example.speedotransferapp.data.ProfileSource
import com.example.speedotransferapp.data.ServicesSource
import com.example.speedotransferapp.data.TransactionsSource
import com.example.speedotransferapp.mapper.BalanceMapper
import com.example.speedotransferapp.mapper.ProfileMapper.mapToView
import com.example.speedotransferapp.mapper.TransactionMapper
import com.example.speedotransferapp.model.BalanceResponse
import com.example.speedotransferapp.model.Profile
import com.example.speedotransferapp.model.TransactionItem
import com.example.speedotransferapp.ui_model.Transaction
import kotlinx.coroutines.Dispatchers
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
            _transactions.value = Transactions().getTransactions()
        }
    }

    fun getInitials(): String{
        val names = profile.name.split(" ")
        val initials = names.map { it.first() }.joinToString("")
        return initials
    }
}