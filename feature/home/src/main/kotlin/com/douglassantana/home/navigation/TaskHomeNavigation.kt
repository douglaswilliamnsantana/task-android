package com.douglassantana.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.douglassantana.home.ui.TaskHomeRoute
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavController.navigateToHome(
    navOptions: NavOptions? = null
) = navigate(HomeRoute, navOptions)

fun NavGraphBuilder.taskHomeScreen(
    onNavigateRegisterTask: () -> Unit
) = composable<HomeRoute> {
    TaskHomeRoute(
        navigateToTaskRegistration = onNavigateRegisterTask
    )
}