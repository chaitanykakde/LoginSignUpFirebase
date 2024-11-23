package com.syntax.loginandsignupapp.data

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.syntax.loginandsignupapp.Navigation.Routes
import com.syntax.loginandsignupapp.rules.Validator

class SignUpViewModel:ViewModel() {
    private val TAG=SignUpViewModel::class.simpleName

    var registrationUIState= mutableStateOf(RegistrationUIState())
    var allValidationsPassed= mutableStateOf(false)
    var signUpInProgress= mutableStateOf(false)

    fun onEvent(event:SignUpUIEvent){
        validateDataWithRules()
        when(event){
          is SignUpUIEvent.FirstNameChanged->{
             registrationUIState.value=registrationUIState.value.
             copy(
                 firstName = event.firstName)


          }

            is SignUpUIEvent.EmailChanged -> {
              registrationUIState.value=registrationUIState.value.copy(
                  email = event.email)


            }
            is SignUpUIEvent.LastNameChanged ->{
                registrationUIState.value=registrationUIState.value.copy(
                    lastName = event.lastName
                )

            }
            is SignUpUIEvent.PasswordChanged ->{
                registrationUIState.value=registrationUIState.value.copy(
                    password = event.password
                )

            }

            is SignUpUIEvent.PrivacyPolicyCheckBoxClicked->{
                registrationUIState.value=registrationUIState.value.copy(
                    privacyPolicyAccepted = event.status

                )
            }
            is SignUpUIEvent.RegisterButtonCLicked->{
                singUP()
            }

        }
        validateDataWithRules()
    }


    private fun singUP() {
        if(allValidationsPassed.value) {

            Log.d("SignuP", "Inside Signup 5.08")
            createUserInFireBase(
                email =registrationUIState.value.email ,
                password =registrationUIState.value.password
            )
        }

    }
   fun  validateDataWithRules(){
       val fNameResult=Validator.validateFirstName(
           fname = registrationUIState.value.firstName
       )
       val lNameResult=Validator.validateLastName(
           lname = registrationUIState.value.lastName
       )
       val emailResult=Validator.validateEmail(
           email = registrationUIState.value.email
       )
       val passwordResult=Validator.validatePassword(
           password = registrationUIState.value.password
       )
       val privacyPolicyResult=Validator.validatePrivacyPolicyAcceptance(
           statusValue = registrationUIState.value.privacyPolicyAccepted
       )
          registrationUIState.value=registrationUIState.value.copy(
           firstNameError = fNameResult.status,
           lastNameError = lNameResult.status,
           emailError = emailResult.status,
           passwordError = passwordResult.status,
              privacyPolicyError =privacyPolicyResult.status
       )
       allValidationsPassed.value=fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && privacyPolicyResult.status


   }

    private fun printState() {
        Log.d(TAG, "Inside PrintState:")
        Log.d("Login", registrationUIState.value.toString())
    }


    private fun createUserInFireBase(email:String,password:String){
        signUpInProgress.value=true
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                Log.d("User","Inside on complete listener")
                Log.d("User","${it.isSuccessful}")
                if(it.isSuccessful) {
                    signUpInProgress.value=false
                    Routes.navController?.navigate("login_screen")
                    Toast.makeText(Routes.context,"SignUp Successful!",Toast.LENGTH_SHORT).show()
                }

            }.addOnSuccessListener {


            }
            .addOnFailureListener {
                Log.d("User","Inside on Failure listener")
                Log.d("User","Exception:${it.localizedMessage}")
                Toast.makeText(Routes.context,"User Already Present!",Toast.LENGTH_SHORT).show()
                signUpInProgress.value=false

            }

    }
    fun logout(){
        var firebaseAuth=FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val authStateListener=AuthStateListener{
            if(it.currentUser==null){
                Log.d("SignOut","Inside sign out success")

            }else{
                Log.d("SignOut","Inside sign out not success")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }


}