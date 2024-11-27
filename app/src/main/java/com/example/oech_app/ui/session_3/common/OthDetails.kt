package com.example.oech_app.ui.session_3.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Secondary
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun OthDetails(
    pItems: String,
    weightP: String,
    worthP: String,
    trackNum: String
){
    Column {
        Text(
            "Other details",
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = TextLighter,
            modifier = Modifier.padding(top = 8.dp)
        )
        DetRow(
            "Package Items",
            pItems
            )
        DetRow(
            "Weight of Items",
            weightP
        )
        DetRow(
            "Worth of Items",
            worthP
        )
        DetRow(
            "Tracking Number",
            trackNum
        )
    }
}

@Composable
fun DetRow(
    label: String,
    det: String,

){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            label,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Gray,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            det,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Secondary,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
fun PrewOthDet(){
    OthDetails(
        pItems = "black duck",
        weightP = "10000kg",
        worthP = "N12421,12",
        trackNum = "R-1247-8921-4921"
    )
}