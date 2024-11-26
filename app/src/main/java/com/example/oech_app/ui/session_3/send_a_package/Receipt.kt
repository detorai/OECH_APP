package com.example.oech_app.ui.session_3.send_a_package

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary

@Composable
fun Receipt(
    addressO: String,
    phoneO: String,
    countryO: String
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(24.dp)
    ) {
        Column {
            Text(
                "Package Information",
                color = Primary,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                lineHeight = 16.sp
            )
            Text(
                "Origin details",
            )
            Text(
                text = "$addressO,$countryO\n$phoneO",
            )
        }
    }
}
