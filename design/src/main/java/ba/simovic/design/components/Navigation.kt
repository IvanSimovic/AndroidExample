package ba.simovic.design.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.simovic.design.R
import ba.simovic.design.theme.ThemedPreview
import ba.simovic.design.theme.navigation
import ba.simovic.design.theme.navigationContent

@Composable
fun Navigation(
    title: String,
    topIcons: List<NavigationIcons>,
    content: @Composable () -> Unit,
    onBack: (() -> Unit)? = null,
    bottomIcons: List<NavigationIcons>? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        NavigationHeader(onBack, title, topIcons)
        Box(Modifier.weight(1f).background(MaterialTheme.colors.background)) {
            content()
        }
        if (bottomIcons?.isNotEmpty() == true)
            BottomNavigation(bottomIcons)
    }
}

data class NavigationIcons(
    @DrawableRes val image: Int,
    val onClick: () -> Unit,
    val text: String = ""
)

@Composable
fun NavigationHeader(
    onBack: (() -> Unit)?,
    title: String,
    icons: List<NavigationIcons>
) {
    Surface(
        color = MaterialTheme.colors.navigation,
        contentColor = MaterialTheme.colors.navigationContent,
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            if (onBack != null) {
                IconButton(
                    image = R.drawable.ic_back, onClick = onBack,
                    color = MaterialTheme.colors.navigationContent
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
            Header(
                text = title, size = HSize.H3,
                color = MaterialTheme.colors.navigationContent
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                for (icon in icons) {
                    Spacer(modifier = Modifier.width(20.dp))
                    IconButton(
                        image = icon.image, onClick = icon.onClick,
                        color = MaterialTheme.colors.navigationContent
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@Composable
fun BottomNavigation(icons: List<NavigationIcons>) {
    Surface(
        color = MaterialTheme.colors.navigation,
        contentColor = MaterialTheme.colors.navigationContent,
        elevation = BottomNavigationDefaults.Elevation
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (icon in icons) {
                IconButton(
                    modifier = Modifier.weight(1f),
                    image = icon.image,
                    text = icon.text,
                    onClick = icon.onClick,
                    color = MaterialTheme.colors.navigationContent
                )
            }
        }
    }
}

@Composable
fun ProvideScreen() = Navigation(
    title = "Notes",
    topIcons = listOf(
        NavigationIcons(R.drawable.ic_settings, {}),
        NavigationIcons(R.drawable.ic_sign_out, {})
    ),
    content = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            ActionButton(text = "Content") {}
        }
    },
    onBack = {},
    bottomIcons = listOf(
        NavigationIcons(R.drawable.ic_queue, {}, "Notes"),
        NavigationIcons(R.drawable.ic_settings, {}, "Profile"),
    )
)

@Preview
@Composable
fun navigationPreview() {
    ThemedPreview(darkTheme = false) {
        ProvideScreen()
    }
}

@Preview
@Composable
fun navigationPreviewDark() {
    ThemedPreview(darkTheme = true) {
        ProvideScreen()
    }
}
