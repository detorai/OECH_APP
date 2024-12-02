package com.example.oech_app.ui.session_3.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.oech_app.common.BottomTabBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    textColor: Color,
    mainColor: Color,
    onHome: ()-> Unit,
    onProfile: ()-> Unit,
    onWallet: ()-> Unit,
    selectedTabIndex: Int
){
    Scaffold(
        bottomBar = {
            BottomTabBar(
                textColor = textColor,
                mainColor = mainColor,
                onProfile = onProfile,
                onHome = onHome,
                onTrack = {},
                onWallet = onWallet,
                selectedTabIndex = selectedTabIndex
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(mainColor).padding(innerPadding)
        ) {
            Text("Hello World")
        }
    }
}
