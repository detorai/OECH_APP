package com.example.oech_app.data

data class Users(
    val name: String,
    val phone: String,
    val email: String,
    val password: String,
    val salt: ByteArray
)
