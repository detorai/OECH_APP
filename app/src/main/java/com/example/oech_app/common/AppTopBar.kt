package com.example.oech_app.common


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary

@Composable
fun AppTopBar(
    label: String,
    secondaryColor: Color,
    onClickBack: ()-> Unit
){

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxWidth().height(108.dp).background(secondaryColor)
            .shadow(1.dp)
            .padding(15.dp, 0.dp, 15.dp, 19.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            IconButton(
                onClick = onClickBack,
                modifier = Modifier
                    .size(24.dp)

            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "icon",
                    tint = Primary,
                    modifier = Modifier
                        .size(20.dp)
                        .border(
                            1.dp,
                            shape = RoundedCornerShape(6.dp),
                            color = Primary
                        )
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                label,
                color = Gray,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                modifier = Modifier.padding(0.dp, 2.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTop(){
    AppTopBar(
        label = "Profile",
        onClickBack = {},
        secondaryColor = Color.White
    )
}