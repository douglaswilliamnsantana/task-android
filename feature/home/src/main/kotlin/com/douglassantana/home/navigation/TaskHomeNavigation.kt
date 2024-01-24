package com.douglassantana.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.douglassantana.home.ui.TaskHomeRoute

fun NavGraphBuilder.taskHomeScreen(
    navigateToTaskRegistration: () -> Unit
) {
    composable(route = TaskHomeDestination.route) {
        TaskHomeRoute(
            navigateToTaskRegistration = navigateToTaskRegistration
        )
    }
}