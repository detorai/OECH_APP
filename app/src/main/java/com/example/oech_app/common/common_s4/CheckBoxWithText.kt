package com.example.oech_app.common.common_s4

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray


@Composable
fun CheckboxWithTextColumn(
    state1: Boolean,
    onState1: (Boolean) -> Unit,

    state2: Boolean,
    onState2: (Boolean) -> Unit,

    state3: Boolean,
    onState3: (Boolean) -> Unit,

    state4: Boolean,
    onState4: (Boolean) -> Unit,

    textColor: Color
) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    ) {
        Column(
            modifier = Modifier.wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = state1,
                    onCheckedChange = onState1
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Courier requested",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = textColor
                    )
            }
            VerticalLine()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = state2,
                    onCheckedChange = onState2
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Package ready for delivery",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = textColor
                )


            }
            VerticalLine()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = state3,
                    onCheckedChange = onState3
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Package in transit",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = textColor
                )


            }
            VerticalLine()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = state4,
                    onCheckedChange = onState4
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Package delivered",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = textColor
                )
            }
        }
    }
}

@Composable
fun VerticalLine() {
    Canvas(
        modifier = Modifier
        .width(3.dp)
        .height(34.dp)
        .padding(start = 24.dp)
    ) {
        drawLine(
            color = Color.Gray,
            start = androidx.compose.ui.geometry.Offset(x = size.width / 2, y = 0f),
            end = androidx.compose.ui.geometry.Offset(x = size.width / 2, y = size.height)
        )
    }
}


@Preview
@Composable
fun MainScreen() {
    CheckboxWithTextColumn(
        state1 = true,
        onState1 = {
            it
        },
        state2 = true,
        onState2 = {
            it
        },
        state3 = true,
        onState3 = {
            it
        },
        state4 = true,
        onState4 = {
            it
        },
        textColor = Gray
    )
}