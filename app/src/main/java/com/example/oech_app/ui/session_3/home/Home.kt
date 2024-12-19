package com.example.oech_app.ui.session_3.home

//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.BottomTabBar
import com.example.oech_app.common.common_s5.HomePage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    textColor: Color,
    mainColor: Color,
    onHome: ()-> Unit,
    onProfile: ()-> Unit,
    onWallet: ()-> Unit,
    selectedTabIndex: Int,
    onTrack: ()-> Unit,
    inputText: String,
    onValue: (String) -> Unit
){
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
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(mainColor)
                .padding(innerPadding)
                .verticalScroll(ScrollState(0))
        ) {
            HomePage(
                inputText = inputText,
                onValue = onValue
            )
        }
    }
}




