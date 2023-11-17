package ba.simovic.design.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import ba.simovic.design.theme.ThemedPreview
import ba.simovic.design.theme.*

enum class HSize {
    H1,
    H2,
    H3,
    H4,
    H5
}

enum class BodySize {
    B1,
    B2,
    B3
}

enum class TextAlpha(val alpha: Float) {
    Alpha0(1f),
    Alpha1(.95f),
    Alpha2(.92f),
    Alpha3(.88f),
    Alpha4(.84f),
    Alpha5(.76f),
}

@Composable
fun Header(text: String, size: HSize, alpha: TextAlpha = TextAlpha.Alpha0, color: Color? = null) {
    val textColor = color?.copy(alpha = alpha.alpha) ?: MaterialTheme.colors.onSurface.copy(alpha = alpha.alpha)
    Text(text = text, color = textColor,
        style = when(size) {
            HSize.H1 -> MaterialTheme.typography.h1
            HSize.H2 -> MaterialTheme.typography.h2
            HSize.H3 -> MaterialTheme.typography.h3
            HSize.H4 -> MaterialTheme.typography.hMini12()
            HSize.H5 -> MaterialTheme.typography.hMini10()
        }
    )
}

@Composable
fun Body(text: String, size: BodySize = BodySize.B2, isBold: Boolean = false, alpha: TextAlpha = TextAlpha.Alpha0, color: Color? = null) {
    val textColor = color?.copy(alpha = alpha.alpha) ?: MaterialTheme.colors.onSurface.copy(alpha = alpha.alpha)
    Text(text = text, color = textColor,
        style = if(!isBold) when(size) {
            BodySize.B1 -> MaterialTheme.typography.body1
            BodySize.B2 -> MaterialTheme.typography.body2
            BodySize.B3 -> MaterialTheme.typography.body3Bold()
        } else when(size) {
            BodySize.B1 -> MaterialTheme.typography.body1Bold()
            BodySize.B2 -> MaterialTheme.typography.body2Bold()
            BodySize.B3 -> MaterialTheme.typography.body3Bold()
        }
    )
}

@Composable
fun TextButton(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2Bold(),
        color = MaterialTheme.colors.surface
    )
}

@Composable
fun TextHint(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.onSurface.copy(alpha = .8f)
    )
}

@Composable
fun ActionText(text: String, onClick: (Int) -> Unit) {
    ClickableText(
        text = AnnotatedString(
            text = text,
            SpanStyle(color = MaterialTheme.colors.onSurface)
        ), style = MaterialTheme.typography.body3Underline(), onClick = onClick
    )
}

@Preview
@Composable
fun TextPreview() {
    ThemedPreview {
            Button(onClick = {}) {
                TextButton(text = "Button text")
            }
            TextHint(text = "Hint text")
            ActionText(text = "Action text") {}
        }
}

@Preview
@Composable
fun TextPreviewDark() {
    ThemedPreview(darkTheme = true) {
        Button(onClick = {}) {
            TextButton(text = "Button text")
        }
        TextHint(text = "Hint text")
        ActionText(text = "Action text") {}
    }
}

@Preview
@Composable
fun BodyPreview() {
    ThemedPreview {
        Body(text = "Body 1", BodySize.B1)
        Body(text = "Body 2", BodySize.B2)
        Body(text = "Body 3", BodySize.B3)
        Body(text = "Body 1 Bold", BodySize.B1, true)
        Body(text = "Body 2 Bold", BodySize.B2, true)
        Body(text = "Body 3 Bold", BodySize.B3, true)
    }
}

@Preview
@Composable
fun BodyPreviewDark() {
    ThemedPreview(darkTheme = true) {
        Body(text = "Body 1", BodySize.B1)
        Body(text = "Body 2", BodySize.B2)
        Body(text = "Body 3", BodySize.B3)
        Body(text = "Body 1 Bold", BodySize.B1, true)
        Body(text = "Body 2 Bold", BodySize.B2, true)
        Body(text = "Body 3 Bold", BodySize.B3, true)
    }
}

@Preview
@Composable
fun HeaderPreview() {
    ThemedPreview {
        Header(text = "Header 1", size = HSize.H1)
        Header(text = "Header 2", size = HSize.H2)
        Header(text = "Header 3", size = HSize.H3)
    }
}

@Preview
@Composable
fun HeaderPreviewDark() {
    ThemedPreview(darkTheme = true) {
        Header(text = "Header 1", size = HSize.H1)
        Header(text = "Header 2", size = HSize.H2)
        Header(text = "Header 3", size = HSize.H3)
    }
}


@Preview
@Composable
fun TextAlphaPreview() {
    ThemedPreview {
        Body(text = "Alpha 0", BodySize.B1, alpha = TextAlpha.Alpha0)
        Body(text = "Alpha 1", BodySize.B1, alpha = TextAlpha.Alpha1)
        Body(text = "Alpha 2", BodySize.B1, alpha = TextAlpha.Alpha2)
        Body(text = "Alpha 3", BodySize.B1, alpha = TextAlpha.Alpha3)
        Body(text = "Alpha 4", BodySize.B1, alpha = TextAlpha.Alpha4)
        Body(text = "Alpha 5", BodySize.B1, alpha = TextAlpha.Alpha5)
    }
}

@Preview
@Composable
fun TextAlphaPreviewDark() {
    ThemedPreview(darkTheme = true) {
        Body(text = "Alpha 0", BodySize.B1, alpha = TextAlpha.Alpha0)
        Body(text = "Alpha 1", BodySize.B1, alpha = TextAlpha.Alpha1)
        Body(text = "Alpha 2", BodySize.B1, alpha = TextAlpha.Alpha2)
        Body(text = "Alpha 3", BodySize.B1, alpha = TextAlpha.Alpha3)
        Body(text = "Alpha 4", BodySize.B1, alpha = TextAlpha.Alpha4)
        Body(text = "Alpha 5", BodySize.B1, alpha = TextAlpha.Alpha5)
    }
}

@Preview
@Composable
fun ErrorTextPreview() {
    ThemedPreview {
        Body(text = "Error Text", BodySize.B1, color = MaterialTheme.colors.error)
    }
}

@Preview
@Composable
fun ErrorTextPreviewDark() {
    ThemedPreview(darkTheme = true) {
        Body(text = "Error Text", BodySize.B1, color = MaterialTheme.colors.error)
    }
}