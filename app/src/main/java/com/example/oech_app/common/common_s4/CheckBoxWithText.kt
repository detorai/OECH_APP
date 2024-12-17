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
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary


@Composable
fun CheckboxWithTextColumn(
    state1: Boolean,
    onState1: (Boolean) -> Unit,
    enabled1: Boolean,
    checkedState1: ToggleableState,

    state2: Boolean,
    onState2: (Boolean) -> Unit,
    enabled2: Boolean,
    checkedState2: ToggleableState,

    state3: Boolean,
    onState3: (Boolean) -> Unit,
    enabled3: Boolean,
    checkedState3: ToggleableState,

    state4: Boolean,
    onState4: (Boolean) -> Unit,
    enabled4: Boolean,
    checkedState4: ToggleableState,

    textColor: Color,
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
                if (!enabled1) {
                    TriStateCheckbox(
                        state = checkedState1,
                        onClick = {},
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Gray,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Color.White,
                            checkedBorderColor = Primary,
                            uncheckedBorderColor = Primary,
                            disabledBorderColor = Gray,
                            disabledCheckedBoxColor = Gray,
                            disabledUncheckedBoxColor = Gray,
                            disabledUncheckedBorderColor = Gray,
                            disabledIndeterminateBorderColor = Gray,
                            disabledIndeterminateBoxColor = Gray
                        ),
                        enabled = false
                    )
                } else {
                    Checkbox(
                        checked = state1,
                        onCheckedChange = onState1,
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Color.White,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Gray,
                            checkedBorderColor = Gray,
                            uncheckedBorderColor = Gray,
                            disabledBorderColor = Primary,
                            disabledCheckedBoxColor = Primary,
                            disabledUncheckedBoxColor = Color.White,
                            disabledUncheckedBorderColor = Primary,
                            disabledIndeterminateBorderColor = Primary,
                            disabledIndeterminateBoxColor = Primary
                        ),
                        enabled = false
                    )
                }
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
                if (!enabled2) {
                    TriStateCheckbox(
                        state = checkedState2,
                        onClick = {},
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Gray,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Color.White,
                            checkedBorderColor = Primary,
                            uncheckedBorderColor = Primary,
                            disabledBorderColor = Gray,
                            disabledCheckedBoxColor = Gray,
                            disabledUncheckedBoxColor = Gray,
                            disabledUncheckedBorderColor = Gray,
                            disabledIndeterminateBorderColor = Gray,
                            disabledIndeterminateBoxColor = Gray
                        ),
                        enabled = false
                    )
                } else {
                    Checkbox(
                        checked = state2,
                        onCheckedChange = onState2,
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Color.White,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Gray,
                            checkedBorderColor = Gray,
                            uncheckedBorderColor = Gray,
                            disabledBorderColor = Primary,
                            disabledCheckedBoxColor = Primary,
                            disabledUncheckedBoxColor = Color.White,
                            disabledUncheckedBorderColor = Primary,
                            disabledIndeterminateBorderColor = Primary,
                            disabledIndeterminateBoxColor = Primary
                        ),
                        enabled = false
                    )
                }
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
                if (!enabled3) {
                    TriStateCheckbox(
                        state = checkedState3,
                        onClick = {},
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Gray,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Color.White,
                            checkedBorderColor = Primary,
                            uncheckedBorderColor = Primary,
                            disabledBorderColor = Gray,
                            disabledCheckedBoxColor = Gray,
                            disabledUncheckedBoxColor = Gray,
                            disabledUncheckedBorderColor = Gray,
                            disabledIndeterminateBorderColor = Gray,
                            disabledIndeterminateBoxColor = Gray
                        ),
                        enabled = false
                    )
                } else {
                    Checkbox(
                        checked = state3,
                        onCheckedChange = onState3,
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Color.White,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Gray,
                            checkedBorderColor = Gray,
                            uncheckedBorderColor = Gray,
                            disabledBorderColor = Primary,
                            disabledCheckedBoxColor = Primary,
                            disabledUncheckedBoxColor = Color.White,
                            disabledUncheckedBorderColor = Primary,
                            disabledIndeterminateBorderColor = Primary,
                            disabledIndeterminateBoxColor = Primary
                        ),
                        enabled = false
                    )
                }
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
                if (!enabled4) {
                    TriStateCheckbox(
                        state = checkedState4,
                        onClick = {},
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Gray,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Color.White,
                            checkedBorderColor = Primary,
                            uncheckedBorderColor = Primary,
                            disabledBorderColor = Gray,
                            disabledCheckedBoxColor = Gray,
                            disabledUncheckedBoxColor = Gray,
                            disabledUncheckedBorderColor = Gray,
                            disabledIndeterminateBorderColor = Gray,
                            disabledIndeterminateBoxColor = Gray
                        ),
                        enabled = false
                    )
                } else {
                    Checkbox(
                        checked = state4,
                        onCheckedChange = onState4,
                        colors = CheckboxColors(
                            checkedCheckmarkColor = Color.White,
                            uncheckedCheckmarkColor = Color.White,
                            checkedBoxColor = Gray,
                            uncheckedBoxColor = Gray,
                            checkedBorderColor = Gray,
                            uncheckedBorderColor = Gray,
                            disabledBorderColor = Primary,
                            disabledCheckedBoxColor = Primary,
                            disabledUncheckedBoxColor = Color.White,
                            disabledUncheckedBorderColor = Primary,
                            disabledIndeterminateBorderColor = Primary,
                            disabledIndeterminateBoxColor = Primary
                        ),
                        enabled = false
                    )
                }
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


