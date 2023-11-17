package ba.simovic.design.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.design.theme.ThemedPreview

@Composable
fun MyTextField(
    value: String,
    hint: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    isPassword: Boolean = false
) {
    var focus by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = onValueChanged,
        placeholder = { TextHint(hint) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if(isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface,
        ),
        textStyle = MaterialTheme.typography.body2,
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (focus) Color.Blue else if (isError) MaterialTheme.colors.error else MaterialTheme.colors.onSurface
            )
            .height(48.dp)
            .onFocusChanged { isInFocus -> focus = isInFocus.isFocused }
    )
}


@Composable
fun QuestionTextField(
    value: String,
    hint: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false
) {
    var focus by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = onValueChanged,
        label = { TextHint(hint) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface,
        ),
        textStyle = MaterialTheme.typography.body2,
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (focus) Color.Blue else if (isError) MaterialTheme.colors.error else MaterialTheme.colors.onSurface
            )
            .height(48.dp)
            .onFocusChanged { isInFocus -> focus = isInFocus.isFocused }
    )
}

@Preview
@Composable
fun Preview() {
    ThemedPreview() {
        MyTextField("Preview", "", {})

    }
}

@Preview
@Composable
fun PreviewError() {
    ThemedPreview() {
        MyTextField("", "Email", {})
    }
}

@Preview
@Composable
fun PreviewDark() {
    ThemedPreview(darkTheme = true) {
        MyTextField("Preview", "", {})
    }
}

@Preview
@Composable
fun PreviewDarkError() {
    ThemedPreview(darkTheme = true) {
        MyTextField("", "Email", {}, isError = true)
    }
}

@Preview
@Composable
fun QuestionHintPreview() {
    ThemedPreview(darkTheme = false) {
        QuestionTextField("", "Email", {})
    }
}

@Preview
@Composable
fun QuestionPreview() {
    ThemedPreview(darkTheme = false) {
        QuestionTextField("This is answer", "This is a question?", {})
    }
}


