package com.example.oech_app.ui.session_4.dev_succ

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.common_s3.CircularProgressBar
import com.example.oech_app.common.common_s4.StarRatingBar
import com.example.oech_app.ui.theme.GrayLighter
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun DevSucc(
    loaded: Boolean,
    onDone: () -> Unit,
    rating: Int,
    onRatingChange: (Int) -> Unit,
    inputText: String,
    onValue: (String)-> Unit,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(state = ScrollState(0))
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
    ) {
        CircularProgressBar(loading = loaded)
        Column(
            modifier = Modifier.padding(top = 75.dp)
        ) {
            when (loaded) {
                true -> Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Delivery Successful",
                        fontWeight = FontWeight.W500,
                        fontSize = 24.sp,
                        lineHeight = 30.sp,
                        color = TextLighter,
                    )
                    Text(
                        "Your Item has been delivered successfully",
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        color = TextLighter,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                false -> {}
            }
        }
        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Primary,
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp
                    )
                ) {
                    append("Rate Rider")
                }
            },
            lineHeight = 16.sp,
            modifier = Modifier.padding(top = 67.dp)
        )
        StarRatingBar(
            rating = rating,
            onRatingChanged = onRatingChange,
            modifier = Modifier.padding(top = 16.dp)
        )
        BasicTextField(
            value = inputText,
            modifier = Modifier.padding(top = 37.dp).fillMaxWidth().height(50.dp),
            onValueChange = onValue,
            decorationBox = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .shadow(1.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.feedback),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.align(Alignment.CenterStart).padding(13.dp).size(13.dp)
                    )
                    Text(
                    text = inputText.ifEmpty {
                        "Add feedback"
                    },
                            modifier = Modifier.align(Alignment.CenterStart).padding(start = 40.dp),
                            fontWeight = FontWeight.W400,
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            color = GrayLighter,
                    )
                }
            }
        )
        Button(
            onClick = onDone,
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
                "Done",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PreviewDevSucc(){
    var rating by remember { mutableIntStateOf(0)}
    var inputText by remember { mutableStateOf("")}
    DevSucc(
        loaded = false,
        onDone = {},
        rating = rating,
        onRatingChange = {
            rating = it
        },
        inputText = inputText,
        onValue = {
            inputText = it
        },
    )
}