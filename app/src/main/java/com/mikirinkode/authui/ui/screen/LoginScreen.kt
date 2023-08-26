package com.mikirinkode.authui.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikirinkode.authui.ui.components.CustomElevatedButton
import com.mikirinkode.authui.ui.components.CustomOutlinedTextField
import com.mikirinkode.authui.ui.components.PasswordOutlinedTextField
import com.mikirinkode.authui.ui.theme.AuthenticationInterfaceComposeTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    Column(
    ) {
        Text(
            text = "Selamat Datang Kembali!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        )
        Text(
            text = "Silahkan masuk terlebih dahulu dengan menggunakan email dan password anda.",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp)
        )

        CustomOutlinedTextField(
            value = emailValue,
            label = "Email",
            onValueChange = { newInput -> emailValue = newInput },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email,
        )
        PasswordOutlinedTextField(
            value = passwordValue,
            label = "Password",
            onValueChange = { newInput -> passwordValue = newInput },
            imeAction = ImeAction.Done,
        )
        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Lupa Password")
        }
        CustomElevatedButton(text = "Masuk", onClick = { /*TODO*/ })
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
        ) {
            Text(text = "Belum punya Akun?")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Daftar")
            }
        }
    }
}


//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
//    name = "Night Mode"
//)
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AuthenticationInterfaceComposeTheme {
        LoginScreen()
    }
}
