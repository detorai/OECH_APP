package com.example.oech_app.common.common_s3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun DestDetails(
    address: String,
    phone: String,
    country: String,
    address1: String,
    phone1: String,
    country1: String,
    state: Boolean,
    modifier: Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            "Destination details",
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = TextLighter
            )
        if (!state) {
            Text(
                "1. $address,$country",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                phone,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
        } else {
            Text(
                "1. $address,$country",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                phone,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                "2. $address1,$country1",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                phone1,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
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
        state = true,
        modifier = Modifier
    )
}