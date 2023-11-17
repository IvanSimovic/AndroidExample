package ba.simovic.androidexample.feature.post.post_details

import androidx.compose.runtime.Composable
import ba.simovic.androidexample.data.model.Post
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import ba.simovic.androidexample.R
import ba.simovic.androidexample.feature.post.items.PostView
import ba.simovic.design.components.LoadingScreen
import ba.simovic.design.components.Navigation

@Composable
fun PostDetailsScreen(
    viewModel: PostDetailsViewModel,
    onBack: () -> Unit,
    id: Long
) {
    val state = viewModel.state
    LaunchedEffect(Unit) {
        viewModel.getPost(id)
    }
    Navigation(title = stringResource(R.string.post_details), topIcons = listOf(), onBack = onBack, content = {
        if (state.isLoading)
            LoadingScreen()
        else
            PostDetailsScreen(state.post)
    })
}

@Composable
fun PostDetailsScreen(
    post: Post
) {
    PostView(post = post, {})
}