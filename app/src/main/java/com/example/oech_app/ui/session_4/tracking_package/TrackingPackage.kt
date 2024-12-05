package com.example.oech_app.ui.session_4.tracking_package

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.mapview.MapView


@Composable
fun TrackingPackage(){
    var mapView: MapView? by remember { mutableStateOf(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        // Отображение карты
        Box(modifier = Modifier.size(390.dp, 320.dp)) {
            YandexMap(onMapReady = { mapView = it })
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



