package com.syntax.loginandsignupapp.screens

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.syntax.loginandsignupapp.Components.ButtonComponent
import com.syntax.loginandsignupapp.Components.ClickableLoginTextComponent
import com.syntax.loginandsignupapp.Components.DividerTextComponent
import com.syntax.loginandsignupapp.Components.HeadingTextComponent
import com.syntax.loginandsignupapp.Components.NormalTextComponent
import com.syntax.loginandsignupapp.Components.UnderlinedNormalTextComponent
import com.syntax.loginandsignupapp.Components.myPasswordTextFiled
import com.syntax.loginandsignupapp.Components.myTextFiled
import com.syntax.loginandsignupapp.Navigation.Routes
import com.syntax.loginandsignupapp.R
import com.syntax.loginandsignupapp.data.LoginUIEvent
import com.syntax.loginandsignupapp.data.LoginViewModel

@Composable
fun LoginScreen(navController: NavController,loginViewModel: LoginViewModel= viewModel()){
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        Surface(
            modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp),

            ) {
            Column (modifier = Modifier.fillMaxSize().background(Color.White)){
                NormalTextComponent(value = stringResource(R.string.hello))
                HeadingTextComponent(value = stringResource(R.string.welcome_back))
                Spacer(modifier = Modifier.height(20.dp))
                myTextFiled(labelValue = stringResource(R.string.email),Icons.Outlined.Email,
                    onTextChanged = {
                        loginViewModel.onEvent((LoginUIEvent.EmailChanged(it)))

                    }, errorStatus =loginViewModel.loginUiState.value.emailError )
                myPasswordTextFiled(labelValue = stringResource(R.string.password),Icons.Outlined.Lock, onTextChanged = {
                    loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))

                }, errorStatus = loginViewModel.loginUiState.value.passwordError)
                Spacer(modifier = Modifier.height(40.dp))
                UnderlinedNormalTextComponent(value = stringResource(R.string.forgot_passowrd))
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(value = stringResource(R.string.login), onButtonClicked = {

                   loginViewModel.onEvent(LoginUIEvent.LoginButtonCLicked)
                },loginViewModel.allValidationsPassed.value)
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = false, stringResource(R.string.go_to_login)) {
                    navController.navigate(route= Routes.signup_screen)
                }


            }



        }
       if(loginViewModel.loginINProgress.value) {
           CircularProgressIndicator()
       }
    }

}

