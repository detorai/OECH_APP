package com.example.oech_app.ui.session_3.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary
import com.example.session_1.R

@Composable
fun SelectDeliveryType(
    onClickPrimary: ()-> Unit,
    modifier: Modifier
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(horizontal = 24.dp)

    ) {
        Text(
            "Select delivery type",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = onClickPrimary,
                modifier = Modifier.size(160.dp , 75.dp),
                colors = buttonColors(
                    containerColor = Primary,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Gray
                ) ,
                shape = RoundedCornerShape(8),

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.clock),
                        contentDescription = "icon"
                    )
                    Text(
                        "Instant delivery"
                    )
                }
            }
            Button(
                onClick = onClickPrimary,
                modifier = Modifier.size(160.dp , 75.dp).shadow(2.dp),
                colors = buttonColors(
                    containerColor = Color.White,
                    contentColor = Gray,
                    disabledContentColor = Gray,
                    disabledContainerColor = Color.White
                ) ,
                shape = RoundedCornerShape(8),

                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.clock),
                        contentDescription = "icon"
                    )
                    Text(
                        "Instant delivery"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewButton(){
    SelectDeliveryType(
        onClickPrimary = {},
        modifier = Modifier
    )
}