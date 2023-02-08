package app.unicornapp.mobile.android.unicorn.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.unicornapp.mobile.android.unicorn.presentation.screens.ContactScreen
import app.unicornapp.mobile.android.unicorn.presentation.screens.HomeScreen
import app.unicornapp.mobile.android.unicorn.presentation.screens.HomeDetailScreen
import app.unicornapp.mobile.android.unicorn.presentation.screens.NotificationScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.HomeDetailScreen.route
        ) {
            HomeDetailScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.ContactScreen.route
        ) {
            ContactScreen(
                navController = navController
            )
        }
    }
}