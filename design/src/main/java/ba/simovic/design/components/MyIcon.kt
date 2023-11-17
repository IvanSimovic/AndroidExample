package ba.simovic.design.components

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ba.simovic.design.R
import ba.simovic.design.theme.ThemedPreview

@Composable
fun MyIcon(@DrawableRes id: Int, color: Color? = null) {
    val tint = color ?: contentColorFor(MaterialTheme.colors.surface)
    Icon(
        painter = painterResource(id = id),
        tint = tint,
        contentDescription = null
    )
}

@Preview
@Composable
fun MyIconPreview() {
    ThemedPreview(darkTheme = false) {
        MyIcon(id = com.google.android.material.R.drawable.ic_arrow_back_black_24, contentColorFor(MaterialTheme.colors.surface))
    }
}

@Preview
@Composable
fun MyIconPreviewDark() {
    ThemedPreview(darkTheme = true) {
        MyIcon(id = com.google.android.material.R.drawable.ic_arrow_back_black_24, contentColorFor(MaterialTheme.colors.surface))
    }
}