package com.douglassantana.task.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.douglassantana.home.ui.TaskHomeDestination
import com.douglassantana.home.ui.TaskHomeScreen
import com.douglassantana.register.ui.TaskRegisterDestination
import com.douglassantana.register.ui.TaskRegisterScreen

@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = TaskHomeDestination.route,
        modifier = modifier
    ) {
        composable(route = TaskHomeDestination.route) {
            TaskHomeScreen(
                navigateToTaskRegistration = {
                    navController.navigate(TaskRegisterDestination.route)
                }
            )
        }

        composable(route = TaskRegisterDestination.route) {
            TaskRegisterScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}