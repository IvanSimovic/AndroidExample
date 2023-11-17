package ba.simovic.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = LightGrey4,
    secondary = Primary,
    secondaryVariant = PurpleDark,
    background = Black,
    surface = DarkGrey2,
    error = Red,
    onPrimary = Black,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    onError = White
)

private val LightColorPalette = lightColors(
    primary = Black,
    primaryVariant = DarkGrey2,
    secondary = Primary,
    secondaryVariant = PurpleDark,
    background = White,
    surface = LightGrey2,
    error = Red,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
    onError = Black
)

val Colors.navigation: Color
    @Composable
    get() = if (isLight) LightGrey2 else DarkGrey2

val Colors.navigationContent: Color
    @Composable
    get() = if (isLight) Black else White

@Composable
fun UITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}