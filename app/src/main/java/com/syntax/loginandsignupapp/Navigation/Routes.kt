package com.syntax.loginandsignupapp.Navigation

import android.content.Context
import androidx.navigation.NavController

object Routes {
    val signup_screen="sign_up_screen"
    val terms_of_use_screen="terms_of_use_screen"
    val login_screen="login_screen"
    val home_screen="home_screen"
    var navController: NavController? =null
    var context:Context?=null
}