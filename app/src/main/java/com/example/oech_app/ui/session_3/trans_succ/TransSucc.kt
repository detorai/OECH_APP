package com.example.oech_app.ui.session_3.trans_succ

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.common_s3.CircularProgressBar
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun TransSucc(
    loaded: Boolean,
    trackNum: String,
    onBack: ()-> Unit,
    onTrack: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
    ) {
        CircularProgressBar(loading = loaded)
        Column(
            modifier = Modifier.padding(top = 75.dp)
        ) {
            when (loaded) {
                true -> Text(
                    "Transaction Successful",
                    fontWeight = FontWeight.W500,
                    fontSize = 24.sp,
                    lineHeight = 30.sp,
                    color = TextLighter,
                )

                false -> {}
            }
            Text(
                "Your rider is on the way to your destination",
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = TextLighter,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        color = TextLighter
                    )
                    ) {
                        append("Track Number ")
                    }
                    withStyle(
                        SpanStyle(
                        color = Primary,
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp
                    )
                    ) {
                        append(trackNum)
                    }
                                     },
                lineHeight = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
            Button(
                onClick = onTrack,
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Primary,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Primary
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(top = 141.dp).height(48.dp).fillMaxWidth()
            ) {
                Text(
                    "Track my item",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = Color.White
                )
            }
            Button(
                onClick = onBack,
                colors = ButtonColors(
                    contentColor = Primary,
                    containerColor = Color.White,
                    disabledContentColor = Primary,
                    disabledContainerColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(48.dp)
                    .fillMaxWidth()
                    .border(1.dp, Primary, shape = RoundedCornerShape(4.dp))
            ) {
                Text(
                    "Go back to homepage",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = Primary
                )
        }
    }
}

@Preview
@Composable
fun PreviewSuc(){
    TransSucc(
        loaded = true,
        trackNum = "12512401",
        onBack = {},
        onTrack = {}
    )
}