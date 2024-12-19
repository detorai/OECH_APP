package com.example.oech_app.common.common_s5

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session_1.R


@Composable
fun NameAndImageRow(
    @DrawableRes image: Int,
    backgroundColor: Color,
    @DrawableRes trailingIcon: Int,
    modifier: Modifier,
    welcomeText: String,
    description: String,
    textColor: Color,
    textSizeWelc: Int,
    textSizeDesc: Int,
    boxHeight: Int
    ){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.fillMaxWidth().wrapContentHeight().background(
            color = backgroundColor,
            shape = RoundedCornerShape(8.dp)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(boxHeight.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Profile Photo",
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 10.dp).size(60.dp)
                    .background(shape = RoundedCornerShape(60.dp), color = Color.White)
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 80.dp).wrapContentHeight()
            ) {
                Text(
                    welcomeText,
                    fontSize = textSizeWelc.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 30.sp,
                    color = textColor
                )
                Text(
                    description,
                    fontSize = textSizeDesc.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.sp,
                    color = textColor
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(trailingIcon),
                tint = Color.White,
                contentDescription = "trailing icon",
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 10.dp).size(24.dp)
            )
        }
    }
}
/*@Preview
@Composable
fun PrevName(){
    NameAndImageRow(
        image = R.drawable.profile_image,
        backgroundColor = Primary,
        trailingIcon = R.drawable.wallet_3,
        modifier = Modifier.height(91.dp),
        welcomeText = "Hello Ken!",
        description = "We trust you are having a great time",
        textColor = Color.White,
        textSizeDesc = 12,
        textSizeWelc = 24
    )
}*/
