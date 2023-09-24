package com.douglassantana.task.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.douglassantana.task.ui.home.TaskHomeDestination
import com.douglassantana.task.ui.home.TaskHomeScreen
import com.douglassantana.task.ui.register.TaskRegisterDestination
import com.douglassantana.task.ui.register.TaskRegisterScreen

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