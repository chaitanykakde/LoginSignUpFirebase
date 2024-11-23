package com.syntax.loginandsignupapp.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class RegistrationUIState(
    var firstName:String="",
    var lastName:String="",
    var email:String="",
    var password:String="",
    var privacyPolicyAccepted: Boolean=false,

    var firstNameError:Boolean=false,
    var lastNameError:Boolean=false,
    var emailError:Boolean=false,
    var passwordError:Boolean=false,
    var DirectRegistering:Boolean=false,
    var privacyPolicyError:Boolean=false,



    )
