package com.example.oech_app.ui.session_3.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary

@Composable
fun RowScope.TabNavigationItem(tab: Tab, mainColor: Color) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        label = {
            Text(text = tab.options.title)
        },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription = tab.options.title
                )
            }
        },
        selectedContentColor = Primary,
        unselectedContentColor = Gray,
        modifier = Modifier.background(mainColor)
    )
}