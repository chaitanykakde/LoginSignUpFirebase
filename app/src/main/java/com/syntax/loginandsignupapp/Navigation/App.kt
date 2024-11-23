package com.syntax.loginandsignupapp.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.syntax.loginandsignupapp.screens.HomeScreen
import com.syntax.loginandsignupapp.screens.LoginScreen
import com.syntax.loginandsignupapp.screens.SignUpScreen
import com.syntax.loginandsignupapp.screens.TermsAndConditionsScreen

@Composable
fun App(){
    val navController= rememberNavController()
    Routes.navController=navController
    Routes.context= LocalContext.current
    NavHost(navController=navController, startDestination = Routes.signup_screen, builder ={
        composable(route = Routes.signup_screen,){
            SignUpScreen(navController)
        }
        composable(route= Routes.terms_of_use_screen+"/{name}",){
            val name= it.arguments?.getString("name")
            TermsAndConditionsScreen(name?:"No name")
        }
        composable(route=Routes.login_screen) {
            LoginScreen(navController)
        }
        composable(route=Routes.home_screen){
            HomeScreen()
        }
    })
}