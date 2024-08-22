package com.capstone.peopleconnect.Classes

data class User(
    val name: String = "",
    val email: String = "",
    val address: String = "",
    val profileImageUrl: String = "",
    val roles: List<String> = listOf()
)