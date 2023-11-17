package ba.simovic.androidexample.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.androidexample.R
import ba.simovic.design.components.ActionButton
import ba.simovic.design.components.HSize
import ba.simovic.design.components.Header
import ba.simovic.design.components.Navigation
import ba.simovic.design.components.NavigationIcons
import ba.simovic.design.theme.ThemedPreview
import ba.simovic.design.theme.bottomNavigation

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    navigateToEditProfile: () -> Unit,
    bottomNavigation: List<NavigationIcons>,
    signOut: () -> Unit
) {
    val state = viewModel.state

    ProfileScreen(
        state.email,
        navigateToEditProfile,
        bottomNavigation,
        signOut
    )
}

@Composable
fun ProfileScreen(
    email: String,
    navigateToEditProfile: () -> Unit,
    bottomNavigation: List<NavigationIcons>,
    signOut: () -> Unit
) {
    Navigation(
        title = stringResource(R.string.profile),
        topIcons = listOf(NavigationIcons(R.drawable.ic_settings, navigateToEditProfile)),
        bottomIcons = bottomNavigation,
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(20.dp)
            )
            {
                Header(text = email, size = HSize.H3)
                Spacer(modifier = Modifier.weight(1.0f))
                ActionButton(text = stringResource(R.string.sign_out), modifier = Modifier.fillMaxWidth()) {
                    signOut()
                }
            }
        }
    )
}

@Composable
fun ProvideScreen() =
    ProfileScreen("test", {}, bottomNavigation, {})

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
