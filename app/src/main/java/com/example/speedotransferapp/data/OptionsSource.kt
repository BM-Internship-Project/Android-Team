package com.example.speedotransferapp.data
import com.example.speedotransferapp.R
import com.example.speedotransferapp.ui_model.OptionItem

class OptionsSource {
    fun getOptions(): List<OptionItem>{
        val options = mutableListOf<OptionItem>().apply {
            add(OptionItem(R.drawable.website, "Transfer From Website"))
            add(OptionItem(R.drawable.favorite, "Favourites"))
            add(OptionItem(R.drawable.user, "Profile"))
            add(OptionItem(R.drawable.help, "Help"))
            add(OptionItem(R.drawable.logout, "logout", isLast = true))
        }
        return options
    }
}