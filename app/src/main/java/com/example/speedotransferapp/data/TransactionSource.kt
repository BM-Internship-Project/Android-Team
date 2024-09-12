package com.example.speedotransferapp.data

import com.example.speedotransferapp.R
import com.example.speedotransferapp.ui_model.TransactionItem

class TransactionsSource {

    fun getTransactions(): List<TransactionItem> {
        return mutableListOf<TransactionItem>().apply {
            add(
                TransactionItem(
                    reference = 234567,
                    recipientName = "Laila Amr",
                    recipientDigits = "1234",
                    dateTime = "Today 00:23",
                    status = "Successful",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Mastercard",
                    amount = "$100.00"
                )
            )
            add(
                TransactionItem(
                    reference = 234567,
                    recipientName = "Smith Johnson",
                    recipientDigits = "5678",
                    dateTime = "Yesterday 09:45",
                    status = "Failed",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Visa",
                    amount = "200.00 LE"
                )
            )
            add(
                TransactionItem(
                    reference = 2345672,
                    recipientName = "Chris Evans",
                    recipientDigits = "8765",
                    dateTime = "3 August 16:30",
                    status = "Successful",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Mastercard",
                    amount = "€100.00"
                )
            )
            add(
                TransactionItem(
                    reference = 2345637,
                    recipientName = "Diana Prince",
                    recipientDigits = "4321",
                    dateTime = "1 June 11:20",
                    status = "Failed",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Mastercard",
                    amount = "$100.00"
                )
            )
            add(
                TransactionItem(
                    reference = 2345367,
                    recipientName = "Bruce Wayne",
                    recipientDigits = "1234",
                    dateTime = "20 May 18:45",
                    status = "Successful",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Visa",
                    amount = "$100.00"
                )
            )
            add(
                TransactionItem(
                    reference = 2341567,
                    recipientName = "Peter Parker",
                    recipientDigits = "5678",
                    dateTime = "15 May 14:15",
                    status = "Failed",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Mastercard",
                    amount = "$100.00"
                )
            )
            add(
                TransactionItem(
                    reference = 2343567,
                    recipientName = "Tony Stark",
                    recipientDigits = "8765",
                    dateTime = "1 May 09:10",
                    status = "Successful",
                    paymentProcessorIcon = R.drawable.mastercard,
                    paymentProcessor = "Visa",
                    amount = "$100.00"
                )
            )
        }
    }

    fun getRecentTransactions(): List<TransactionItem> {
        return getTransactions().take(3)
    }
}
