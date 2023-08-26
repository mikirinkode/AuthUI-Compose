package com.mikirinkode.authui.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikirinkode.authui.ui.components.CustomElevatedButton
import com.mikirinkode.authui.ui.components.CustomOutlinedTextField
import com.mikirinkode.authui.ui.components.PasswordOutlinedTextField
import com.mikirinkode.authui.ui.theme.AuthenticationInterfaceComposeTheme

@Composable
fun ResetPasswordScreen(
    modifier: Modifier = Modifier
) {
    var passwordValue by remember {
        mutableStateOf("")
    }
    var passwordConfValue by remember {
        mutableStateOf("")
    }

    Column {
        SmallTopAppBar(
            title = { Text("Ubah Password") },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            })
        Text(
            text = "Silahkan masukkan password yang baru",
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        PasswordOutlinedTextField(
            value = passwordValue,
            label = "Password",
            imeAction = ImeAction.Next,
            onValueChange = { newValue -> passwordValue = newValue })
        PasswordOutlinedTextField(
            value = passwordValue,
            label = "Konfirmasi Password",
            imeAction = ImeAction.Done,
            onValueChange = { newValue -> passwordConfValue = newValue })
        CustomElevatedButton(
            text = "Ubah Password",
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordPreview() {
    AuthenticationInterfaceComposeTheme {
        ResetPasswordScreen()
    }
}