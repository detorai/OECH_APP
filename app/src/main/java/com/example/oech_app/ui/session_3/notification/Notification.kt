package com.example.oech_app.ui.session_3.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun Notification(
    onClickBack:()-> Unit,
    secondaryColor: Color
){
    Scaffold(
        topBar = { AppTopBar(
            onClickBack = onClickBack,
            secondaryColor = secondaryColor,
            label = "Notification"
        )}
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(0.dp,120.dp,0.dp,0.dp).wrapContentWidth().wrapContentHeight()
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.notification),
                    contentDescription = "image",
                    modifier = Modifier.padding(bottom = 8.dp).size(83.dp),
                    tint = Gray
                )
                Text(
                    "You have no notification",
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = TextLighter
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNot(){
    Notification(
        onClickBack = {},
        secondaryColor = Color.White
    )
}