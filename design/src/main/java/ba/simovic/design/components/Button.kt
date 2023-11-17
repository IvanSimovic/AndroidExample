package ba.simovic.design.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.design.theme.ThemedPreview

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(modifier = modifier.height(48.dp), onClick = onClick) {
        TextButton(text = text)
    }
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    text: String = "",
    onClick: () -> Unit,
    color: Color? = null
) {
    Column(
        modifier = modifier.clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyIcon(id = image, color)
        if (text.isNotBlank())
            Body(text = text, size = BodySize.B2, isBold = true, color = color)
    }
}

@Composable
fun ProvideScreen(text: String = "") = IconButton(text = text, image = com.google.android.material.R.drawable.ic_arrow_back_black_24,
    color = contentColorFor(MaterialTheme.colors.primarySurface), onClick = {})

@Preview
@Composable
fun IconButtonPreview() {
    ThemedPreview {
        ProvideScreen()
    }
}

@Preview
@Composable
fun IconButtonDarkPreview() {
    ThemedPreview(darkTheme = true) {
        ProvideScreen()
    }
}

@Preview
@Composable
fun IconTextButtonPreview() {
    ThemedPreview {
        ProvideScreen("Test")
    }
}

@Preview
@Composable
fun IconTextButtonDarkPreview() {
    ThemedPreview(darkTheme = true) {
        ProvideScreen("Test")
    }
}

@Preview
@Composable
fun MyButtonPreview() {
    ThemedPreview {
        ActionButton(text = "Click me") {}
    }
}

@Preview
@Composable
fun MyButtonPreviewDark() {
    ThemedPreview(darkTheme = true) {
        ActionButton(text = "Click me") {}
    }
}