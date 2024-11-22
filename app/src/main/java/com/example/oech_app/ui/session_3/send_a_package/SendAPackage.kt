package com.example.oech_app.ui.session_3.send_a_package

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.ui.session_3.common.AddDestination
import com.example.oech_app.ui.session_3.common.DetailsRow
import com.example.oech_app.ui.session_3.common.SelectDeliveryType
import com.example.oech_app.ui.session_3.common.TextRow
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun SendAPackage(
    onClickBack: ()-> Unit,
    secondaryColor: Color,
    inputText: String,
    onValue: (String)-> Unit
){
    var state by remember { mutableStateOf(false) }
    var offset by remember { mutableFloatStateOf(0f) }

    Scaffold(
        topBar = { AppTopBar(
            label = "Send a package",
            onClickBack = {},
            secondaryColor = secondaryColor
            )
        },
    ) {innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).verticalScroll(ScrollState(0)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 43.dp)
            ) {
                DetailsRow(
                    icon = R.drawable.sun,
                    labelName = "Origin Details",
                    inputText = inputText,
                    onValue = onValue
                )
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 39.dp)
            ) {
                DetailsRow(
                    icon = R.drawable.mark,
                    labelName = "Destination Details",
                    inputText = inputText,
                    onValue = onValue
                )
            }
            AddDestination(
                state = state,
                inputText = inputText,
                onClickAdd = {
                    state = true
                },
                onValue = onValue
            )
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(start = 24.dp, end = 24.dp, top = 24.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(bottom = 5.dp).fillMaxWidth().wrapContentHeight()
                ) {
                    Column {
                        Text(
                            "Package Details",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            color = TextLighter
                        )
                    }
                }
                TextRow(
                    inputText = inputText,
                    onValue = onValue,
                    modifier = Modifier
                )
                TextRow(
                    inputText = inputText,
                    onValue = onValue,
                    modifier = Modifier.padding(top = 5.dp)
                )
                TextRow(
                    inputText = inputText,
                    onValue = onValue,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            SelectDeliveryType(
                onClickPrimary = {},
                modifier = Modifier.padding(top = 39.dp, bottom = 15.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSend(){
    SendAPackage(
        inputText = "address",
        onClickBack = {},
        onValue = {},
        secondaryColor = Color.White
    )
}