package com.example.oech_app.ui.session_3.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.oech_app.ui.session_3.home.HomeScreen
import com.example.session_1.R

object HomeTab: Tab {
    private fun readResolve(): Any = HomeTab
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(ImageVector.vectorResource(R.drawable.house_2))
            val title = "Home"

            return remember {
                TabOptions(
                    icon = icon,
                    title = title,
                    index = 0u
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = HomeScreen())
    }
}