package ba.simovic.design.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import ba.simovic.design.R


private val neue_haas = FontFamily(
    Font(R.font.neue_haas_display_roman),
    Font(R.font.neue_haas_medium, FontWeight.W500)
)

// Set of Material typography styles to start with


fun Typography.hMini12() = TextStyle(
    fontFamily = neue_haas,
    fontWeight = FontWeight.W500,
    fontSize = 12.sp
)

fun Typography.hMini10() = TextStyle(
    fontFamily = neue_haas,
    fontWeight = FontWeight.W500,
    fontSize = 10.sp
)

fun Typography.body3Underline() = TextStyle(
    fontFamily = neue_haas,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp,
    textDecoration = TextDecoration.Underline
)

fun Typography.body1Bold() = TextStyle(
    fontFamily = neue_haas,
    fontWeight = FontWeight.W500,
    fontSize = 15.sp
)

fun Typography.body2Bold() = TextStyle(
    fontFamily = neue_haas,
    fontWeight = FontWeight.W500,
    fontSize = 12.sp
)

fun Typography.body3Bold() = TextStyle(
    fontFamily = neue_haas,
    fontWeight = FontWeight.W500,
    fontSize = 10.sp
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = neue_haas,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    body2 = TextStyle(
        fontFamily = neue_haas,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = neue_haas,
        fontWeight = FontWeight.W500,
        fontSize = 48.sp
    ),
    h2 = TextStyle(
        fontFamily = neue_haas,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = neue_haas,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)