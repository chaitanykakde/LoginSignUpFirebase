package com.syntax.loginandsignupapp.data

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.syntax.loginandsignupapp.Navigation.Routes
import com.syntax.loginandsignupapp.rules.Validator

class LoginViewModel :ViewModel(){
 private val TAG=LoginViewModel::class.simpleName
 var loginUiState= mutableStateOf(LoginUiState())

 var allValidationsPassed= mutableStateOf(false)

 var loginINProgress= mutableStateOf(false)

  fun onEvent(event:LoginUIEvent){
      when(event){
          is LoginUIEvent.EmailChanged->{
              loginUiState.value=loginUiState.value.copy(
                  email = event.email
              )

          }
          is LoginUIEvent.PasswordChanged->{
              loginUiState.value=loginUiState.value.copy(
                  password = event.password
              )

          }
          is LoginUIEvent.LoginButtonCLicked->{
              login()

          }
      }
      validateLoginDataWithRules()
  }


    fun  validateLoginDataWithRules(){
        val emailResult= Validator.validateEmail(
            email = loginUiState.value.email
        )
        val passwordResult= Validator.validatePassword(
            password = loginUiState.value.password
        )
      
        loginUiState.value=loginUiState.value.copy(
          
            emailError = emailResult.status,
            passwordError = passwordResult.status,
          
        )
        allValidationsPassed.value= emailResult.status && passwordResult.status 


    }


    private fun login() {
        loginINProgress.value=true
        val email=loginUiState.value.email
        val password=loginUiState.value.password
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                Log.d(TAG,"inside Login succes")
                Log.d(TAG,"${it.isSuccessful}")
                if(it.isSuccessful){
                    Routes.navController?.navigate("home_screen")
                    loginINProgress.value=false
                    Toast.makeText(Routes.context,"User Logged-in Success!",Toast.LENGTH_SHORT).show()
                }

            }
            .addOnFailureListener {
                Log.d(TAG,"inside Failure Listener")
                loginINProgress.value=false
                Toast.makeText(Routes.context,"Incorrect Username or Password !",Toast.LENGTH_SHORT).show()


            }

    }


}