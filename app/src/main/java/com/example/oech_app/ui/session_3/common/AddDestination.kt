package com.example.oech_app.ui.session_3.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary
import com.example.session_1.R

@Composable
fun AddDestination(state: Boolean, onClickAdd: ()-> Unit, inputText: String, onValue: (String) -> Unit){
    if (!state){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 14.dp).wrapContentHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                IconButton(
                    onClick = onClickAdd,
                    modifier = Modifier
                        .size(14.dp)

                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "icon",
                        tint = Primary,
                        modifier = Modifier
                            .size(12.dp)
                            .border(
                                1.dp,
                                shape = RoundedCornerShape(4.dp),
                                color = Primary
                            )
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Text(
                    "Add destination",
                    color = Gray,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                )
            }
        }
    } else {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 39.dp)
        ) {
            DetailsRow(
                icon = R.drawable.mark,
                labelName = "Destination Details",
                inputText = inputText,
                onValue = onValue
            )
        }
    }
}