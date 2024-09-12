package com.example.speedotransferapp.data

import android.provider.ContactsContract
import com.example.speedotransferapp.model.Profile


class ProfileSource {
    fun getProfile() = Profile(
        "Eyad ", "Amr",
    )
}
