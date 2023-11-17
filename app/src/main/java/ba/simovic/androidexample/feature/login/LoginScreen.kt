package ba.simovic.androidexample.feature.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.androidexample.R
import ba.simovic.design.components.*
import ba.simovic.design.theme.ThemedPreview

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navigateToMain: () -> Unit
) {
    val state = viewModel.state
    if (state.isSuccess) {
        viewModel.signingIn()
        navigateToMain()
    }

    LoginScreen(
        email = state.email,
        setEmail = { viewModel.setData(email = it) },
        password = state.password,
        setPassword = { viewModel.setData(password = it) },
        isError = state.isError,
        setError = { viewModel.setData(isError = it) },
        login = viewModel::login
    )
}

@Composable
fun LoginScreen(
    email: String,
    setEmail: (String) -> Unit,
    password: String,
    setPassword: (String) -> Unit,
    isError: Boolean,
    setError: (Boolean) -> Unit,
    login: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    )
    {
        Spacer(modifier = Modifier.height(100.dp))
        Header(text = stringResource(R.string.sign_in), size = HSize.H2)
        Spacer(modifier = Modifier.height(20.dp))
        MyTextField(email, stringResource(R.string.email), {
            setEmail(it)
            setError(false)
        }, isError = isError, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        MyTextField(password, stringResource(R.string.password), {
            setPassword(it)
            setError(false)
        }, isError = isError, isPassword = true, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        ActionButton(modifier = Modifier.fillMaxWidth(), text = stringResource(id = R.string.sign_in)) {
            login()
        }
    }
}

@Composable
fun ProvideLoginScreenForPreview(isError: Boolean) =
    LoginScreen("test", {}, "test", {}, isError, {}, {})

@Preview
@Composable
fun LoginScreenDarkPreview() {
    ThemedPreview(darkTheme = true) {
        ProvideLoginScreenForPreview(false)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    ThemedPreview(darkTheme = false) {
        ProvideLoginScreenForPreview(false)
    }
}
