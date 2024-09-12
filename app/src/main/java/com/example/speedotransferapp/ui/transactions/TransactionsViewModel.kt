package com.example.speedotransferapp.ui.transactions

import android.view.SurfaceControl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.speedotransferapp.R
import com.example.speedotransferapp.api.TransactionAPIService
import com.example.speedotransferapp.constant.AppConstants.FAILED
import com.example.speedotransferapp.data.ProfileSource
import com.example.speedotransferapp.data.TransactionsSource
import com.example.speedotransferapp.paging.TransactionsPagingSource
import com.example.speedotransferapp.ui.theme.Green
import com.example.speedotransferapp.ui.theme.LightGreen
import com.example.speedotransferapp.ui.theme.LightRed
import com.example.speedotransferapp.ui.theme.Red
import com.example.speedotransferapp.ui_model.TransactionItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TransactionsViewModel: ViewModel() {

    private var switchIcon = false

    private val _transactions = MutableStateFlow<List<TransactionItem>>(emptyList())
    val transactions = _transactions.asStateFlow()

    init {
        viewModelScope.launch {
            _transactions.value = TransactionsSource().getTransactions()
        }
    }

    fun getIcon(): Int {
        switchIcon = !switchIcon
        return if(switchIcon) R.drawable.bank else R.drawable.card2
    }

    fun getTextColor(status: String) = if (status == "Failed") Red else Green

    fun getBackgroundColor(status: String) = if (status == "Failed") LightRed else LightGreen
}