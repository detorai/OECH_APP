package com.example.oech_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.oech_app.ui.session_1.onboarding.ob1.Onboarding1Screen
import com.example.oech_app.ui.session_1.onboarding.ob2.OnBoarding2Screen
import com.example.oech_app.ui.session_1.onboarding.ob3.Onboarding3Screen
import com.example.oech_app.ui.session_1.splash.SplashScreen
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPasswordScreen
import com.example.oech_app.ui.session_2.newpassword.NewPasswordScreen
import com.example.oech_app.ui.session_2.otpverification.OTPScreen
import com.example.oech_app.ui.session_2.signin.SignInScreen
import com.example.oech_app.ui.session_2.signup.SignUpScreen
import com.example.oech_app.ui.session_3.home.HomeScreen
import com.example.oech_app.ui.session_3.tabs.HomeTab
import com.example.oech_app.ui.session_3.tabs.ProfileTab
import com.example.oech_app.ui.session_3.tabs.TabNavigationItem
import com.example.oech_app.ui.theme.OECH_APPTheme

class MainActivity : ComponentActivity() {

    private val viewModel: Session2ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val session1 = listOf(
            Onboarding3Screen(),
            OnBoarding2Screen(),
            Onboarding1Screen(),
            SplashScreen()
        )
        val session2 = listOf(
            HomeScreen(),
            NewPasswordScreen(viewModel),
            OTPScreen(viewModel),
            ForgotPasswordScreen(viewModel),
            SignInScreen(viewModel),
            SignUpScreen(viewModel)
        )

        setContent {
                MainContent(viewModel)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun MainContent(viewModel: Session2ViewModel) {
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
