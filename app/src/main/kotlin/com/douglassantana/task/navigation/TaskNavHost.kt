package com.douglassantana.task.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.douglassantana.home.navigation.taskHomeScreen
import com.douglassantana.home.navigation.TaskHomeDestination
import com.douglassantana.register.navigation.navigateToRegister
import com.douglassantana.register.navigation.taskRegisterScreen
import com.douglassantana.register.navigation.TaskRegisterDestination

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
        taskHomeScreen(
            navigateToTaskRegistration = {
                navController.navigateToRegister(
                    destination = TaskRegisterDestination.route
                )
            }
        )

        taskRegisterScreen(
            navigateBack = { navController.popBackStack() },
            onNavigateUp = { navController.navigateUp() }
        )
    }
}