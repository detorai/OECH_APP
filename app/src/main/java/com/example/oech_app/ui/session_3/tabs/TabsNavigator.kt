package com.example.oech_app.ui.session_3.tabs

import android.annotation.SuppressLint
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MainContent(viewModel: Session2ViewModel) {
    val colors = viewModel.getColors(viewModel.checked.value)
    TabNavigator(HomeTab) {
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {
                BottomNavigation {
                    TabNavigationItem(HomeTab, colors.mainColor)
                    TabNavigationItem(ProfileTab, colors.mainColor)
                }
            }
        )
    }
}