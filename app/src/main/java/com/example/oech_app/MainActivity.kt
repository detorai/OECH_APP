package com.example.oech_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import com.example.oech_app.ui.session_1.splash.SplashScreen
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPassword
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPasswordScreen
import com.example.oech_app.ui.session_2.newpassword.NewPasswordScreen
import com.example.oech_app.ui.session_2.otpverification.OTPScreen
import com.example.oech_app.ui.session_2.signin.SignInScreen
import com.example.oech_app.ui.session_2.signup.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigator(SignUpScreen())
        }
    }
}
