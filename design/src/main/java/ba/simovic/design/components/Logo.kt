package ba.simovic.design.components

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ba.simovic.design.theme.ThemedPreview

@Composable
fun Logo() {
    Icon(painter = painterResource(id = com.google.android.material.R.drawable.ic_arrow_back_black_24), tint = MaterialTheme.colors.onSurface, contentDescription = null)
}

@Preview
@Composable
fun LogoPreview() {
    ThemedPreview() {
        Logo()
    }
}

@Preview
@Composable
fun LogoPreviewDark() {
    ThemedPreview(darkTheme = true) {
        Logo()
    }
}