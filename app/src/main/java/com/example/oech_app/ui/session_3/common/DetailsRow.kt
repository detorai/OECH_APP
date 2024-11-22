package com.example.oech_app.ui.session_3.common

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun DetailsRow(
    @DrawableRes icon: Int,
    labelName: String,
    inputText: String,
    onValue: (String) -> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(bottom = 5.dp).fillMaxWidth().wrapContentHeight()
        ) {
            Column {
                Icon(
                    imageVector = ImageVector.vectorResource(icon),
                    contentDescription = "icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Column {
                Text(
                    labelName,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = TextLighter
                )
            }
        }
        TextRow(
            inputText = inputText,
            onValue = onValue,
            modifier = Modifier
        )
        TextRow(
            inputText = inputText,
            onValue = onValue,
            modifier = Modifier.padding(top = 5.dp)
        )
        TextRow(
            inputText = inputText,
            onValue = onValue,
            modifier = Modifier.padding(top = 5.dp)
        )
        TextRow(
            inputText = inputText,
            onValue = onValue,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Preview
@Composable
fun PreviewDetails(){

    var inputText by remember { mutableStateOf("")}

    DetailsRow(
        inputText = inputText,
        onValue = {inputText = it},
        icon = R.drawable.sun,
        labelName = "Origins Details"
    )
}
