package com.syntax.loginandsignupapp.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.syntax.loginandsignupapp.Components.ButtonComponent
import com.syntax.loginandsignupapp.Components.HeadingTextComponent
import com.syntax.loginandsignupapp.Navigation.Routes
import com.syntax.loginandsignupapp.R
import com.syntax.loginandsignupapp.data.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel= viewModel()){
    Surface(color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Home Screen")

            ButtonComponent(value= stringResource(R.string.signout), onButtonClicked = {
                signUpViewModel.logout()
                Routes.navController?.navigate("login_screen")
                Toast.makeText(Routes.context,"User logged-out !", Toast.LENGTH_SHORT).show()

            }, isEnabled = true)
        }

    }
}
