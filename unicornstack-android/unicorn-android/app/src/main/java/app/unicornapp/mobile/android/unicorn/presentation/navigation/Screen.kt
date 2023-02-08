package app.unicornapp.mobile.android.unicorn.presentation.navigation

/**
 * Created by Das on 2022-11-05.
 */
sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object ContactScreen: Screen(route = "contact_screen")
    object NotificationScreen: Screen(route = "notification_screen")
    object HomeDetailScreen: Screen(route = "home_detail_screen")
}
