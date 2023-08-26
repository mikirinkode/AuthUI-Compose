package com.mikirinkode.authui.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun RegisterScreen(
    modifier: Modifier = Modifier
) {
    var nameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var passwordConfValue by remember { mutableStateOf("") }


    Column {
        Text(
            text = "Selamat Datang!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        )
        Text(
            text = "Silahkan buat akun terlebih dahulu sebelum masuk ke aplikasi.",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp)
        )
        CustomOutlinedTextField(
            value = nameValue,
            label = "Nama",
            onValueChange = { newInput -> nameValue = newInput },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
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
            imeAction = ImeAction.Next,
        )
        PasswordOutlinedTextField(
                value = passwordValue,
        label = "Konfirmasi Password",
        onValueChange = { newInput -> passwordConfValue = newInput },
        imeAction = ImeAction.Done,
        )
        CustomElevatedButton(text = "Daftar", onClick = { /*TODO*/ })
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
        ) {
            Text(text = "Sudah punya Akun?")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Masuk")
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
fun RegisterScreenPreview() {
    AuthenticationInterfaceComposeTheme {
        RegisterScreen()
    }
}
