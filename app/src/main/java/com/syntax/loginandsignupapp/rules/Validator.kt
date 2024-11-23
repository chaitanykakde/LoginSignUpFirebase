package com.syntax.loginandsignupapp.rules

import androidx.room.RoomOpenDelegate
import androidx.room.RoomOpenHelper

object Validator {
    fun validateFirstName(fname:String):ValidationResult {
        return ValidationResult(
            (!fname.isNullOrEmpty() && fname.length>=6)
        )
    }
    fun validateLastName(lname:String):ValidationResult {
        return ValidationResult(
            (!lname.isNullOrEmpty() && lname.length>=4)
        )

    }
    fun validateEmail(email:String):ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty()&& email.length>=6)
        )
    }
    fun validatePassword(password:String):ValidationResult {
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length>=4)
        )

    }
    fun validatePrivacyPolicyAcceptance(statusValue:Boolean):ValidationResult{
       return ValidationResult(
           statusValue
       )
    }
}
data class ValidationResult(
    val status:Boolean=false
)