package com.polstat.ukmesport.auth

data class Session(
    val user: User,
    val token: String,
)

data class User(
    val name: String,
    val email: String
)

