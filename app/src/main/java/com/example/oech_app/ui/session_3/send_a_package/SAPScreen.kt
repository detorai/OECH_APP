package com.example.oech_app.ui.session_3.send_a_package

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SAPScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val colors = viewModel.getColors(viewModel.checked.value)
        val address0 = viewModel.addressO.collectAsState().value
        val countryO = viewModel.countryO.collectAsState().value
        val phoneO = viewModel.phoneO.collectAsState().value
        val othersO = viewModel.othersO.collectAsState().value

        val addressD1 = viewModel.addressD1.collectAsState().value
        val countryD1 = viewModel.countryD1.collectAsState().value
        val phoneD1 = viewModel.phoneD1.collectAsState().value
        val othersD1 = viewModel.othersD1.collectAsState().value

        val addressD2 = viewModel.addressD2.collectAsState().value
        val countryD2 = viewModel.countryD2.collectAsState().value
        val phoneD2 = viewModel.phoneD2.collectAsState().value
        val othersD2 = viewModel.othersD2.collectAsState().value

        val items = viewModel.itemsP.collectAsState().value
        val weight = viewModel.weightP.collectAsState().value
        val worth = viewModel.worthP.collectAsState().value

        var state by remember { mutableStateOf(false) }


        SendAPackage(
                onClickBack= {},
                secondaryColor= colors.secondaryColor,

                addressO= address0,
                onAddressO= viewModel::onAddressO,

                countryO= countryO,
                onCountryO= viewModel::onCountryO,

                phoneO= phoneO,
                onPhoneO= viewModel::onPhoneO,

                othersO= othersO,
                onOthersO= viewModel::onOthersO,

                addressD1=addressD1,
                onAddressD1= viewModel:: onAddressD1,

                countryD1= countryD1,
                onCountryD1= viewModel:: onCountryD1,

                phoneD1 = phoneD1,
                onPhoneD1= viewModel:: onPhoneD1,

                othersD1= othersD1,
                onOthersD1= viewModel:: onOthersD1,

                addressD2= addressD2,
                onAddressD2= viewModel::onAddressD2,

                countryD2= countryD2,
                onCountryD2= viewModel:: onCountryD2,

                phoneD2= phoneD2,
                onPhoneD2= viewModel:: onPhoneD2,

                othersD2= othersD2,
                onOthersD2= viewModel::onOthersD2,

                items= items ,
                onItems= viewModel::onItemsP,

                weight= weight,
                onWeight= viewModel:: onWeightP,

                worth= worth,
                onWorth= viewModel::onWorthP,

                screenState = state,

                onClickPrimary = {
                    state = true
                },
                onClickSecondly = {
                    state = true
                }
        )
    }
}