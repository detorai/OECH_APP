package com.example.oech_app.common.common_s4

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary
import com.example.session_1.R

@Composable
fun CardChoose(
    modifier: Modifier,
    secondaryColor: Color,
    othChoose: Boolean,
    makeChoose: ()-> Unit,
    cardNumber: String,
    textColor: Color,
    state: Boolean,
    onDelete: () -> Unit
){
    if (state){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
                .height(63.dp)
                .background(secondaryColor)
                .shadow(1.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                Column {
                    RadioButton(
                        selected = othChoose,
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
                        .padding(start = 44.dp)
                ) {
                    Text(
                        cardNumber,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        color = textColor
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.CenterEnd)
                ) {
                    IconButton(
                        onClick = onDelete
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.iconoir_trash),
                            contentDescription = "icon",
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}



