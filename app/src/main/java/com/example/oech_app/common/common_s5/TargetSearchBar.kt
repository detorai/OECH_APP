package com.example.oech_app.common.common_s5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.GrayLighter
import com.example.session_1.R

@Composable
fun TargetSearchBar(
    inputText: String,
    onValue: (String)-> Unit,
    modifier: Modifier,
    placeholder: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        BasicTextField(
            value = inputText,
            modifier = Modifier.padding(top = 37.dp).fillMaxWidth().height(40.dp),
            onValueChange = onValue,
            decorationBox = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(
                            shape = RoundedCornerShape(4.dp),
                            color = GrayLighter
                            ),
                    contentAlignment = Alignment.Center,

                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.search_normal),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.align(Alignment.CenterEnd).padding(end = 12.dp).size(12.dp)
                    )
                    Text(
                        text = inputText.ifEmpty {
                            placeholder
                        },
                        modifier = Modifier.align(Alignment.CenterStart).padding(start = 12.dp),
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = Gray,
                    )
                }
            }
        )
    }
}



/*
@Preview
@Composable
fun PrevSearch(){
    var inputText by remember { mutableStateOf("")}
    TargetSearchBar(
        inputText = inputText,
        onValue = {
            inputText = it
        },
        modifier = Modifier,
        placeholder = "Search for a driver"
    )
}*/
