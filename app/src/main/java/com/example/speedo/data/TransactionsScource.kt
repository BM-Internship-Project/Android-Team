package com.example.speedo.data

import com.example.speedo.R
import com.example.speedo.model.TransactionItem

class TransactionsSource {
    fun getTransactions(): List<TransactionItem> {
        val transactions = mutableListOf<TransactionItem>().apply {
            add(
                TransactionItem(
                    recipientName = "Emily Clark",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "4321",
                    dateTime = "Today 09:00",
                    status = "Received",
                    cardHolderName = "Emily Clark",
                    amount = "$120.00",
                    currency = "USD",
                    id = "TXN123457",
                    cvv = "321",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
            add(
                TransactionItem(
                    recipientName = "James Wilson",
                    paymentMethod = "PayPal",
                    lastFourDigits = "5678",
                    dateTime = "Today 10:30",
                    status = "Declined",
                    cardHolderName = "James Wilson",
                    amount = "$250.00",
                    currency = "USD",
                    id = "TXN123458",
                    cvv = "654",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "PayPal"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Olivia Brown",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "6789",
                    dateTime = "Yesterday 15:00",
                    status = "Received",
                    cardHolderName = "Olivia Brown",
                    amount = "$300.00",
                    currency = "USD",
                    id = "TXN123459",
                    cvv = "987",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
            add(
                TransactionItem(
                    recipientName = "William Davis",
                    paymentMethod = "PayPal",
                    lastFourDigits = "7890",
                    dateTime = "7 September 11:00",
                    status = "Received",
                    cardHolderName = "William Davis",
                    amount = "€350.00",
                    currency = "EUR",
                    id = "TXN123460",
                    cvv = "456",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "PayPal"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Sophia Johnson",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "8901",
                    dateTime = "6 September 14:00",
                    status = "Received",
                    cardHolderName = "Sophia Johnson",
                    amount = "$400.00",
                    currency = "USD",
                    id = "TXN123461",
                    cvv = "678",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Liam Harris",
                    paymentMethod = "PayPal",
                    lastFourDigits = "9012",
                    dateTime = "5 September 16:30",
                    status = "Declined",
                    cardHolderName = "Liam Harris",
                    amount = "€500.00",
                    currency = "EUR",
                    id = "TXN123462",
                    cvv = "890",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "PayPal"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Ava Martin",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "0123",
                    dateTime = "4 September 13:00",
                    status = "Received",
                    cardHolderName = "Ava Martin",
                    amount = "$550.00",
                    currency = "USD",
                    id = "TXN123463",
                    cvv = "123",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Mason Clark",
                    paymentMethod = "PayPal",
                    lastFourDigits = "2345",
                    dateTime = "3 September 10:00",
                    status = "Received",
                    cardHolderName = "Mason Clark",
                    amount = "$600.00",
                    currency = "USD",
                    id = "TXN123464",
                    cvv = "456",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "PayPal"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Isabella Lewis",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "3456",
                    dateTime = "2 September 12:30",
                    status = "Declined",
                    cardHolderName = "Isabella Lewis",
                    amount = "€700.00",
                    currency = "EUR",
                    id = "TXN123465",
                    cvv = "789",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Ethan Rodriguez",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "4567",
                    dateTime = "1 September 14:00",
                    status = "Received",
                    cardHolderName = "Ethan Rodriguez",
                    amount = "€800.00",
                    currency = "EUR",
                    id = "TXN123466",
                    cvv = "012",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
        }
        return transactions
    }

    fun getRecentTransactions(): List<TransactionItem> {
        val transactions = mutableListOf<TransactionItem>().apply {
            add(
                TransactionItem(
                    recipientName = "Emily Clark",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "4321",
                    dateTime = "Today 09:00",
                    status = "Received",
                    cardHolderName = "Emily Clark",
                    amount = "$120.00",
                    currency = "USD",
                    id = "TXN123457",
                    cvv = "321",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
            add(
                TransactionItem(
                    recipientName = "James Wilson",
                    paymentMethod = "PayPal",
                    lastFourDigits = "5678",
                    dateTime = "Today 10:30",
                    status = "Declined",
                    cardHolderName = "James Wilson",
                    amount = "$250.00",
                    currency = "USD",
                    id = "TXN123458",
                    cvv = "654",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "PayPal"
                )
            )
            add(
                TransactionItem(
                    recipientName = "Olivia Brown",
                    paymentMethod = "Credit Card",
                    lastFourDigits = "6789",
                    dateTime = "Yesterday 15:00",
                    status = "Received",
                    cardHolderName = "Olivia Brown",
                    amount = "$300.00",
                    currency = "USD",
                    id = "TXN123459",
                    cvv = "987",
                    paymentProcessorIcon = R.drawable.mastercard,
                    cardType = "MasterCard"
                )
            )
        }
        return transactions
    }
}
