package com.syntax.loginandsignupapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.syntax.loginandsignupapp.Navigation.App
import com.syntax.loginandsignupapp.Navigation.Routes

import com.syntax.loginandsignupapp.screens.SignUpScreen
import com.syntax.loginandsignupapp.screens.TermsAndConditionsScreen
import com.syntax.loginandsignupapp.ui.theme.LoginAndSignUpAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAndSignUpAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                  App()
                }
            }
        }
    }
}
