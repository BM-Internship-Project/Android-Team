package com.example.speedotransferapp.ui.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.speedotransferapp.R
import com.example.speedotransferapp.api.TransactionAPIService
import com.example.speedotransferapp.constant.AppConstants.FAILED
import com.example.speedotransferapp.paging.TransactionsPagingSource
import com.example.speedotransferapp.ui.theme.Green
import com.example.speedotransferapp.ui.theme.LightGreen
import com.example.speedotransferapp.ui.theme.LightRed
import com.example.speedotransferapp.ui.theme.Red
import com.example.speedotransferapp.ui_model.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionsViewModel() : ViewModel() {

    private var switchIcon = false

    val transactions: Flow<PagingData<Transaction>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 10,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { TransactionsPagingSource(token,TransactionAPIService) }
    ).flow.cachedIn(viewModelScope)

    fun getIcon(): Int {
        switchIcon = !switchIcon
        return if (switchIcon) R.drawable.bank else R.drawable.card2
    }

    fun getTextColor(status: String) = if (status == FAILED) Red else Green

    fun getBackgroundColor(status: String) = if (status == FAILED) LightRed else LightGreen

    fun getCardDetails(transaction: Transaction) = transaction.paymentProcessor + " . " +
            transaction.recipientDigits.takeLast(4)
}