package com.example.speedotransferapp.mapper

import com.example.speedotransferapp.model.NameData
import com.example.speedotransferapp.model.Profile

object ProfileMapper {
    // Convert data model to UI model
    fun mapToView(nameData: NameData) = Profile(
        name = nameData.firstName + " " + nameData.lastName,
        initials = nameData.firstName.take(1) + nameData.lastName.take(1)
    )
}