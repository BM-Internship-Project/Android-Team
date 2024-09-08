package com.example.speedo.data

import com.example.speedo.model.FavouriteItem

class FavouritesSource {
    //get from API and only last 4 digits of account
    fun getFavourites(): List<FavouriteItem> {
        val favourites = mutableListOf<FavouriteItem>().apply {
            add(
                FavouriteItem(
                    name = "Mariam Saad",
                    accountNumber = "Account xxxx4321"
                )
            )
            add(
                FavouriteItem(
                    name = "Ali Hassan",
                    accountNumber = "Account xxxx8765"
                )
            )
            add(
                FavouriteItem(
                    name = "Michael Thomas",
                    accountNumber = "Account xxxx1019"
                )
            )
            add(
                FavouriteItem(
                    name = "Sara Ahmed",
                    accountNumber = "Account xxxx1211"
                )
            )
            add(
                FavouriteItem(
                    name = "Laila Samir",
                    accountNumber = "Account xxxx1413"
                )
            )
            add(
                FavouriteItem(
                    name = "Omar El-Sayed",
                    accountNumber = "Account xxxx1615"
                )
            )
            add(
                FavouriteItem(
                    name = "Nour Khaled",
                    accountNumber = "Account xxxx1817"
                )
            )
            add(
                FavouriteItem(
                    name = "Yasmin Tawfik",
                    accountNumber = "Account xxxx2029"
                )
            )
            add(
                FavouriteItem(
                    name = "Karim Zaki",
                    accountNumber = "Account xxxx2221"
                )
            )
            add(
                FavouriteItem(
                    name = "Hesham Ali",
                    accountNumber = "Account xxxx2423"
                )
            )

        }
        return favourites
    }
}
