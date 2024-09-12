package com.example.speedotransferapp.data

import com.example.speedotransferapp.R
import com.example.speedotransferapp.ui_model.TransactionDetails

class TransactionDetailsSource {
    fun getTransaction() = TransactionDetails(
        recipientName = "Eyad Amr",
        recipientAccount = "Account xxxx5678",
        dateTime = "15 May 14:15",
        status = "Failed",
        paymentProcessor = "Mastercard",
        senderName = "Mary Jane",
        amount = "175.00",
        currency = "USD",
        reference = 234567,
        senderAccount = "Account xxxx1234",
        header="Failed Transaction",
        largeIcon = R.drawable.failed,
        smallIcon = R.drawable.failed_small
    )
}