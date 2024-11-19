package com.example.oech_app.ui.session_3.profile.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun LogOutButton(
    modifier: Modifier
    ){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth().wrapContentHeight().shadow(1.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.a1),
                        contentDescription = "icon"
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.a2),
                        contentDescription = "icon"
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(9.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Log Out",
                    color = TextLighter,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500)
                )
            }
        }
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = "icon",
        )
    }
}
