package com.example.oech_app.ui.session_3.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DestDetails(
    address: String,
    phone: String,
    country: String,
    address1: String,
    phone1: String,
    country1: String,
    state: Boolean
){
    Column {
        Text("Destination details",
            )
        when (state){
            false ->
                Text("1. $address,$country\n$phone")
            true ->
                Text("1. $address,$country\n$phone\n2. $address1,$country1\n$phone1")
        }

    }
}

@Preview
@Composable
fun PreviewDest(){
    DestDetails(
        address = "asdaw qwerty",
        phone = "+1241212",
        country = "Russian Fed",
        address1 = "zxcvq",
        country1 = "Mexico",
        phone1 = "+1241245",
        state = true
    )
}