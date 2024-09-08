package com.example.speedo.data

import android.provider.ContactsContract
import com.example.speedo.model.Profile


class ProfileSource {
    fun getProfile() = Profile(
        "Yasmine Atef", "YA",
    )
}