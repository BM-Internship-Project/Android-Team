package com.example.speedotransferapp.data

import com.example.speedotransferapp.ui_model.User

class UserSource {
    fun getUsers() :List<User>{
        val users = mutableListOf<User>().apply {
            add( User("laila", "lola@gmail.com", "12345678Aa.", "","" ,listOf(), listOf()))

        }
        return users
    }
}