package com.syntax.loginandsignupapp

import android.app.Application
import com.google.firebase.FirebaseApp

class LoginFlowApp : Application(){
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }


}