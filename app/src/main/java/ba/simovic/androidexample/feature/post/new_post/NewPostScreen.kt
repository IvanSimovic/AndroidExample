package ba.simovic.androidexample.feature.post.new_post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.androidexample.R
import ba.simovic.design.components.ActionButton
import ba.simovic.design.components.LoadingScreen
import ba.simovic.design.components.MyTextField
import ba.simovic.design.components.Navigation
import ba.simovic.design.theme.ThemedPreview

@Composable
fun NewPostScreen(
    viewModel: NewPostViewModel,
    navigateBack: () -> Unit
) {
    val state = viewModel.state

    if (state.navigation == NewPostViewModel.NewPostNavigation.NAVIGATE_UP) {
        viewModel.navigationFinished()
        navigateBack()
    }

    Navigation(
        title = stringResource(R.string.new_note),
        topIcons = listOf(),
        onBack = navigateBack,
        content = {
            if (state.isLoading)
                LoadingScreen()
            else
                NewPostScreen(
                    title = state.title,
                    setTitle = { viewModel.setData(title = it) },
                    text = state.text,
                    setText = { viewModel.setData(text = it) },
                    addNewPost = viewModel::addNewPost,
                    isError = state.isError,
                    setError = { viewModel.setData(isError = it) },
                )
        })
}

@Composable
fun NewPostScreen(
    title: String,
    setTitle: (String) -> Unit,
    text: String,
    setText: (String) -> Unit,
    addNewPost: () -> Unit,
    isError: Boolean,
    setError: (Boolean) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(title, stringResource(R.string.title), {
                setTitle(it)
                setError(false)
            }, isError = isError, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(15.dp))
            MyTextField(
                text, stringResource(R.string.text), {
                    setText(it)
                    setError(false)
                }, isError = isError, modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            ActionButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.add)
            ) {
                addNewPost()
            }
        }
    }
}


@Preview
@Composable
fun NewPostScreenDarkPreview() {
    ThemedPreview(darkTheme = true) {
        NewPostScreen("title", {}, "text", {}, {}, false, {})
    }
}

@Preview
@Composable
fun NewPostScreenPreview() {
    ThemedPreview(darkTheme = false) {
        NewPostScreen("title", {}, "text", {}, {}, false, {})
    }
}
