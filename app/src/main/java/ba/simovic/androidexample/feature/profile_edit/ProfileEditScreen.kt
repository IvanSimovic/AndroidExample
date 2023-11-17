package ba.simovic.androidexample.feature.profile_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.androidexample.R
import ba.simovic.design.components.ActionButton
import ba.simovic.design.components.MyTextField
import ba.simovic.design.components.Navigation
import ba.simovic.design.theme.ThemedPreview

@Composable
fun ProfileEditScreen(
    viewModel: ProfileEditViewModel,
    navigateBack: () -> Unit
) {
    val state = viewModel.state

    ProfileEditScreen(
        email = state.email,
        { viewModel.setEmail(it) },
        navigateBack
    )
}

@Composable
fun ProfileEditScreen(
    email: String,
    setEmail: (String) -> Unit,
    navigateBack: () -> Unit
) {
    Navigation(
        title = stringResource(R.string.profile_edit),
        topIcons = listOf(),
        onBack = navigateBack,
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(20.dp)
            )
            {
                MyTextField(email, stringResource(R.string.email), setEmail, modifier = Modifier.fillMaxWidth())
            }
        }
    )
}

@Composable
fun ProvideScreen() =
    ProfileEditScreen("test", {}, {})

@Preview
@Composable
fun LoginScreenDarkPreview() {
    ThemedPreview(darkTheme = true) {
        ProvideScreen()
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    ThemedPreview(darkTheme = false) {
        ProvideScreen()
    }
}
