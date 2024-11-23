package com.syntax.loginandsignupapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.syntax.loginandsignupapp.Components.ButtonComponent

import com.syntax.loginandsignupapp.Components.CheckBoxComponent
import com.syntax.loginandsignupapp.Components.ClickableLoginTextComponent
import com.syntax.loginandsignupapp.Components.DividerTextComponent
import com.syntax.loginandsignupapp.Components.HeadingTextComponent
import com.syntax.loginandsignupapp.Components.NormalTextComponent

import com.syntax.loginandsignupapp.Components.myPasswordTextFiled
import com.syntax.loginandsignupapp.Components.myTextFiled
import com.syntax.loginandsignupapp.Navigation.Routes
import com.syntax.loginandsignupapp.R
import com.syntax.loginandsignupapp.data.SignUpViewModel
import com.syntax.loginandsignupapp.data.SignUpUIEvent

@Composable
fun SignUpScreen(navController: NavController, signUpViewModel: SignUpViewModel= viewModel()){

    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){


        Surface(color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)) {
            Column (modifier = Modifier.fillMaxSize()){
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier =Modifier.height(20.dp))
                myTextFiled(labelValue = stringResource(R.string.fristname), imageVector = Icons.Outlined.Person,
                    onTextChanged = {
                        signUpViewModel.onEvent(SignUpUIEvent.FirstNameChanged(it))


                    },signUpViewModel.registrationUIState.value.firstNameError)
                myTextFiled(labelValue = stringResource(R.string.lastname), imageVector = Icons.Outlined.Person,
                    onTextChanged = {
                        signUpViewModel.onEvent(SignUpUIEvent.LastNameChanged(it))

                    },signUpViewModel.registrationUIState.value.lastNameError)
                myTextFiled(labelValue = stringResource(R.string.email),Icons.Outlined.Email,
                    onTextChanged = {
                        signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
                    },signUpViewModel.registrationUIState.value.emailError)
                myPasswordTextFiled(labelValue = stringResource(R.string.password),Icons.Outlined.Lock,
                    onTextChanged = {
                        signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))

                    },signUpViewModel.registrationUIState.value.passwordError)

                CheckBoxComponent(value = stringResource(R.string.termsAndConditions),
                    onTextSelected = { selectedText ->
                        Log.d("SignUpScreen",   ":Selected text: $selectedText ")
                        if (selectedText == "Terms of Use" || selectedText== "Privacy Policy") {
                            navController.navigate("terms_of_use_screen"+"/john")
                        }
                    } , onCheckChange ={
                        signUpViewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))

                    } )
                Spacer(Modifier.height(40.dp))
                ButtonComponent(value = stringResource(R.string.register), onButtonClicked = {
                    signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonCLicked)

                }, isEnabled = signUpViewModel.allValidationsPassed.value)
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = true,
                    onTextSelected = { selectedText->
                        navController.navigate(Routes.login_screen)

                    },
                    value = stringResource(R.string.go_to_login)
                )




            }
        }
        if(signUpViewModel.signUpInProgress.value){
            CircularProgressIndicator()

        }
    }
    }




