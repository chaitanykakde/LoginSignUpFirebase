package com.syntax.loginandsignupapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syntax.loginandsignupapp.Components.HeadingTextComponent
import com.syntax.loginandsignupapp.Components.NormalTextComponent
import com.syntax.loginandsignupapp.R

@Composable
fun TermsAndConditionsScreen(name:String){
    Surface(modifier = Modifier.fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {
        Column (modifier = Modifier.padding(20.dp).fillMaxWidth()){
            HeadingTextComponent(value = stringResource(id = R.string.termsAndConditions))
            NormalTextComponent(value = name)
        }

    }
}

