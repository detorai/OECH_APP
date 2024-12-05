package com.example.oech_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import cafe.adriel.voyager.navigator.Navigator
import com.example.oech_app.ui.session_1.onboarding.ob1.Onboarding1Screen
import com.example.oech_app.ui.session_1.onboarding.ob2.OnBoarding2Screen
import com.example.oech_app.ui.session_1.onboarding.ob3.Onboarding3Screen
import com.example.oech_app.ui.session_1.splash.SplashScreen
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPasswordScreen
import com.example.oech_app.ui.session_2.newpassword.NewPasswordScreen
import com.example.oech_app.ui.session_2.otpverification.OTPScreen
import com.example.oech_app.ui.session_2.signin.SignInScreen
import com.example.oech_app.ui.session_2.signup.SignUpScreen
import com.example.oech_app.ui.session_3.home.HomeScreen
import com.example.oech_app.ui.session_3.profile.ProfileScreen
import com.example.oech_app.ui.session_3.send_a_package.SAPScreen
import com.example.oech_app.ui.session_4.tracking_package.TrackingPackageScreen
import com.yandex.mapkit.MapKitFactory

class MainActivity : ComponentActivity() {

    private val viewModel: OechAppViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("6cae8543-2d4f-4600-8707-7927d6a632fc")
        MapKitFactory.initialize(this)
        MapKitFactory.getInstance().onStart()

        val session1 = listOf(
            Onboarding3Screen(),
            OnBoarding2Screen(),
            Onboarding1Screen(),
            SplashScreen()
        )
        val session2 = listOf(
            HomeScreen(viewModel),
            NewPasswordScreen(viewModel),
            OTPScreen(viewModel),
            ForgotPasswordScreen(viewModel),
            SignInScreen(viewModel),
            SignUpScreen(viewModel)
        )
        val session3 = listOf(
            SAPScreen(viewModel),
            ProfileScreen(viewModel),
            HomeScreen(viewModel),
        )

        setContent {
            Navigator(TrackingPackageScreen())
        }
    }
    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}


