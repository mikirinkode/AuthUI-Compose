package com.mikirinkode.authui.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikirinkode.authui.ui.theme.AuthenticationInterfaceComposeTheme

@Composable
fun CustomElevatedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonShape = MaterialTheme.shapes.medium
    Button(
        onClick = onClick,
        shape = buttonShape,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun CustomElevatedButtonPreview() {
    AuthenticationInterfaceComposeTheme {
        Column {
            CustomElevatedButton(text = "My Button", onClick = {})
        }
    }
}