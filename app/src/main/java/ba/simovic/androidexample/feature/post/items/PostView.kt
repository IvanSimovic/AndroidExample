package ba.simovic.androidexample.feature.post.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.androidexample.data.model.Post
import ba.simovic.design.theme.ThemedPreview

@Composable
fun PostView(post: Post, onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 15.dp, end = 20.dp, bottom = 0.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = post.title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h3
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            color = MaterialTheme.colors.primary,
            text = post.text,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.body1
        )
        Divider(
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .height(1.dp)
        )
    }
}

@Composable
fun provideScreen() =
    PostView(Post(0, "Test Title", "This is a post hello nice to meet you"), {})

@Preview
@Composable
fun PostViewPreview() {
    ThemedPreview(darkTheme = false) {
        provideScreen()
    }
}

@Preview
@Composable
fun PostViewDarkPreview() {
    ThemedPreview(darkTheme = true) {
        provideScreen()
    }
}