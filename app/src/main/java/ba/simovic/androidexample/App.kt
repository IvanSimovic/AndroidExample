package ba.simovic.androidexample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import ba.simovic.design.theme.UITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterialApi
@Composable
fun App(
) {
    UITheme {
        val systemUiController = rememberSystemUiController()
        val isDarkTheme = isSystemInDarkTheme()
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = !isDarkTheme)
        }

        val navController = rememberNavController()
        NavGraph(
            navController = navController
        )
    }
}
