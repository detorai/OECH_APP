package com.example.oech_app.data.model

data class Users(
    val name: String,
    val phone: String,
    val email: String,
    var password: String,
    var salt: ByteArray
)
