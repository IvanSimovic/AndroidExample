package ba.simovic.androidexample.feature.post.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ba.simovic.androidexample.R
import ba.simovic.androidexample.data.model.Post
import ba.simovic.androidexample.feature.post.items.PostView
import ba.simovic.design.components.LoadingScreen
import ba.simovic.design.components.Navigation
import ba.simovic.design.components.NavigationIcons
import ba.simovic.design.theme.ThemedPreview

@Composable
fun PostsScreen(
    viewModel: PostsViewModel,
    navigateToNewPost: () -> Unit,
    bottomNavigation: List<NavigationIcons>,
    navigateToPostDetails: (Long) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getPosts()
    }

    val state = viewModel.state

    Navigation(
        title = stringResource(R.string.posts),
        topIcons = listOf(NavigationIcons(R.drawable.ic_plus, navigateToNewPost)),
        bottomIcons = bottomNavigation,
        content = {
            if (state.isLoading)
                LoadingScreen()
            else
                PostsScreen(state.posts, navigateToPostDetails)
        })
}

@Composable
fun PostsScreen(
    posts: List<Post>,
    navigateToPostDetails: (Long) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
        ) {
            items(posts) { post ->
                PostView(post) {
                    navigateToPostDetails(post.id)
                }
            }
        }
    }
}

@Preview
@Composable
fun previewScreen() {
    ThemedPreview {
        PostsScreen(
            arrayListOf(
                Post(0, "Hi", "hello"),
                Post(0, "Hi", "hello"),
                Post(0, "Hi", "hello")
            ), {})
    }
}

@Preview
@Composable
fun previewDarkScreen() {
    ThemedPreview(darkTheme = true) {
        PostsScreen(arrayListOf(Post(0, "Hi", "hello")), {})
    }
}