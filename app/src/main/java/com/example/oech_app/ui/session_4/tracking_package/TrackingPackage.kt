package com.example.oech_app.ui.session_4.tracking_package

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.oech_app.common.BottomTabBar
import com.example.oech_app.common.common_s4.CheckboxWithTextColumn
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary
import com.example.session_1.R
import com.yandex.mapkit.mapview.MapView


@Composable
fun TrackingPackage(
    trackNum: String,
    state1: Boolean,
    onState1: (Boolean) -> Unit,

    state2: Boolean,
    onState2: (Boolean) -> Unit,

    state3: Boolean,
    onState3: (Boolean) -> Unit,

    state4: Boolean,
    onState4: (Boolean) -> Unit,

    textColor: Color,

    onPackInfo: ()-> Unit,

    mainColor: Color,
    onHome: ()-> Unit,
    onProfile: ()-> Unit,
    onTrack: ()-> Unit,
    onWallet: ()-> Unit,
    selectedTabIndex: Int
){
    var mapView: MapView? by remember { mutableStateOf(null) }
    Scaffold(
        bottomBar = {
            BottomTabBar(
                textColor = textColor,
                mainColor = mainColor,
                onProfile = onProfile,
                onHome = onHome,
                onTrack = onTrack,
                onWallet = onWallet,
                selectedTabIndex = selectedTabIndex
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(mainColor).padding(innerPadding)
        ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(320.dp)) {
            YandexMap(onMapReady = { mapView = it })
        }
        Text(
            "Tracking Number",
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            color = textColor,
            modifier = Modifier.padding(top = 42.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.tracksun),
                contentDescription = "",
                modifier = Modifier.background(
                    shape = CircleShape,
                    color = Primary
                ),
                tint = Color.Unspecified
            )
            Text(
                trackNum,
                color = Primary,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Text(
            "Package Status",
            color = Gray,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        CheckboxWithTextColumn(
            state1 = state1,
            onState1 = {},
            state2 = state2,
            onState2 = onState2,
            state3 = state3,
            onState3 = onState3,
            state4 = state4,
            onState4 = onState4,
            textColor = textColor,
            enabled4 = false,
            enabled3 = false,
            enabled2 = false,
            enabled1 = false,

        )
        Button(
            onClick = onPackInfo,
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Primary,
                disabledContentColor = Color.White,
                disabledContainerColor = Primary
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(top = 40.dp).height(46.dp).fillMaxWidth()
        ) {
            Text(
                "View Package Info",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                color = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun YandexMap(onMapReady: (MapView) -> Unit) {
    AndroidView(
    factory = {
        val mapView = MapView(it)
        onMapReady(mapView)
        mapView
    }
    )
}





