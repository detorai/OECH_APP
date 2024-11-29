package com.example.oech_app.ui.session_3.tabs


import android.annotation.SuppressLint
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainEvent(
    mainColor: Color,
    viewModel: Session2ViewModel,
) {
    TabNavigator(HomeTab(viewModel)){
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {
                BottomNavigation {
                    TabNavigationItem(HomeTab(viewModel), mainColor)
                    TabNavigationItem(ProfileTab(viewModel), mainColor)
                }
            }
        )
    }
}
