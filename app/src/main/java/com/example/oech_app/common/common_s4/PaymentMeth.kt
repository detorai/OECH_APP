package com.example.oech_app.common.common_s4

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary

@Composable
fun PaymentMeth(
    modifier: Modifier,
    label: String,
    desc: String,
    textColor: Color,
    secondaryColor: Color,
    makeChoose: () -> Unit,
    choose: Boolean,
    height: Int,
    onDelete1: () -> Unit,
    onDelete2: () -> Unit,
    othChoose: Boolean,
    state1: Boolean,
    makeChooseCard1: ()-> Unit,
    state2: Boolean,
    makeChooseCard2: ()-> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .background(secondaryColor)
            .shadow(1.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(vertical = 24.dp, horizontal = 8.dp)
        ) {
            Row(
            ) {
                Column {
                    RadioButton(
                        selected = choose,
                        onClick = makeChoose,
                        colors = RadioButtonColors(
                            selectedColor = Primary,
                            unselectedColor = Primary,
                            disabledSelectedColor = Color.White,
                            disabledUnselectedColor = Color.White
                        )
                    )
                }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .wrapContentWidth()
            ) {
                Text(
                    label,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = textColor
                )
                Text(
                    desc,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Gray
                    )
                }
            }
            CardChoose(
                modifier = Modifier.padding(top = 8.dp),
                onDelete = onDelete1,
                state = state1,
                cardNumber = "**** **** 3124",
                makeChoose = makeChooseCard1,
                othChoose = othChoose,
                textColor = textColor,
                secondaryColor = secondaryColor
            )
            CardChoose(
                modifier = Modifier.padding(top = 8.dp),
                onDelete = onDelete2,
                state = state2,
                cardNumber = "**** **** 7345",
                makeChoose = makeChooseCard2,
                othChoose = othChoose,
                textColor = textColor,
                secondaryColor = secondaryColor
            )
        }
    }
}
