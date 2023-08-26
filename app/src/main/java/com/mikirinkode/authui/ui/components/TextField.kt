package com.mikirinkode.authui.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikirinkode.authui.R
import com.mikirinkode.authui.ui.theme.AuthenticationInterfaceComposeTheme

// Parent
@Composable
fun CustomOutlinedTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier,
) {

    val textFieldShape = MaterialTheme.shapes.medium

    // TODO
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        textColor = MaterialTheme.colorScheme.onSurface,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
        cursorColor = MaterialTheme.colorScheme.primary,
        errorCursorColor = MaterialTheme.colorScheme.error
    )


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        shape = textFieldShape,
        colors = textFieldColors,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation
    )
}


@Composable
fun PasswordOutlinedTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next,
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    val visualTransformation = if (passwordVisibility) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    CustomOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        imeAction = imeAction,
        keyboardType = KeyboardType.Password,
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    painter = painterResource(id = if (passwordVisibility) R.drawable.ic_eye_outline else R.drawable.ic_eye_fill),
                    contentDescription = if (passwordVisibility) "Hide password" else "Show password",
                    tint = Color.DarkGray
                )
            }
        },
        visualTransformation = visualTransformation
    )


}

//@Preview( showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
//    name = "Night Mode"
//)
@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    AuthenticationInterfaceComposeTheme {
        Column() {
            CustomOutlinedTextField(value = "", label = "Normal Text Field", onValueChange = {})
            PasswordOutlinedTextField(
                value = "",
                label = "Password Text Field",
                onValueChange = { value -> }
            )
        }
    }
}
