package ba.simovic.androidexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import ba.simovic.androidexample.feature.login.LoginScreen
import ba.simovic.androidexample.feature.post.new_post.NewPostScreen
import ba.simovic.androidexample.feature.post.post_details.PostDetailsScreen
import ba.simovic.androidexample.feature.post.posts.PostsScreen
import ba.simovic.androidexample.feature.profile.ProfileScreen
import ba.simovic.androidexample.feature.profile_edit.ProfileEditScreen
import ba.simovic.design.components.NavigationIcons

object MainDestinations {
    const val PROFILE_EDIT = "profile_edit"
    const val POST_DETAILS = "post_details"
    const val POSTS = "posts"
    const val PROFILE = "profile"
    const val LOGIN = "login"
    const val NEW_POST = "new_post"
}

object DestinationGroups {
    const val POSTS = "posts_destination_group"
    const val PROFILE = "profile_destination_group"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.LOGIN
) {
    val actions = remember(navController) { MainActions(navController) }
    val bottomNavigation = listOf(
        NavigationIcons(R.drawable.ic_queue, actions.bottomNavigationPosts, stringResource(R.string.posts)),
        NavigationIcons(R.drawable.ic_settings, actions.bottomNavigationProfile, stringResource(R.string.profile))
    )

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.LOGIN) {
            LoginScreen(
                viewModel = hiltViewModel(),
                navigateToMain = actions.navigateToMain
            )
        }

        navigation(startDestination = MainDestinations.POSTS, DestinationGroups.POSTS) {
            composable(MainDestinations.POSTS) {
                PostsScreen(
                    viewModel = hiltViewModel(),
                    navigateToNewPost = actions.navigateToNewPost,
                    bottomNavigation = bottomNavigation,
                    navigateToPostDetails = actions.navigateToPostDetails
                )
            }
            composable(MainDestinations.NEW_POST) {
                NewPostScreen(
                    viewModel = hiltViewModel(),
                    navigateBack = actions.navigateBack
                )
            }
            composable(
                MainDestinations.POST_DETAILS + "/{id}",
                arguments = listOf(navArgument("id") { type = NavType.LongType })
            ) {
                PostDetailsScreen(
                    hiltViewModel(),
                    actions.navigateBack,
                    navController.currentBackStackEntry?.arguments?.getLong("id")!!
                )
            }
        }

        navigation(MainDestinations.PROFILE, DestinationGroups.PROFILE) {
            composable(MainDestinations.PROFILE) {
                ProfileScreen(
                    hiltViewModel(),
                    actions.navigateToProfileEdit,
                    bottomNavigation,
                    signOut = actions.signOut
                )
            }
            composable(MainDestinations.PROFILE_EDIT) {
                ProfileEditScreen(
                    hiltViewModel(),
                    actions.navigateBack
                )
            }
        }
    }
}

class MainActions(navController: NavHostController) {

    val navigateToMain: () -> Unit = {
        navController.navigate(DestinationGroups.POSTS) {
            popUpTo(MainDestinations.LOGIN) {
                inclusive = true
            }
        }
    }

    val navigateToNewPost: () -> Unit = {
        navController.navigate(MainDestinations.NEW_POST)
    }

    val signOut: () -> Unit = {
        navController.navigate(MainDestinations.LOGIN) {
            popUpTo(MainDestinations.LOGIN) {
                inclusive = true
            }
        }
    }

    val navigateBack: () -> Unit = {
        navController.navigateUp()
    }

    val navigateToPostDetails: (Long) -> Unit = {
        navController.navigate(MainDestinations.POST_DETAILS + "/$it")
    }

    val navigateToProfileEdit: () -> Unit = {
        navController.navigate(MainDestinations.PROFILE_EDIT)
    }

    val bottomNavigationPosts: () -> Unit = {
        if (navController.currentDestination?.route != MainDestinations.POSTS)
            navController.navigate(DestinationGroups.POSTS) {
                launchSingleTop = true
                restoreState = true
                popUpTo(MainDestinations.POSTS) {
                    saveState = true
                }
            }
    }

    val bottomNavigationProfile: () -> Unit = {
        if (navController.currentDestination?.route != MainDestinations.PROFILE)
            navController.navigate(DestinationGroups.PROFILE) {
                launchSingleTop = true
                restoreState = true
                popUpTo(MainDestinations.POSTS) {
                    saveState = true
                }
            }
    }
}
