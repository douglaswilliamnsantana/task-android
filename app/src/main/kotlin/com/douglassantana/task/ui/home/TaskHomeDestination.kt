package com.douglassantana.task.ui.home

import com.douglassantana.task.R
import com.douglassantana.task.common.Screens.SCREEN_NAME_TASK_REGISTRATION
import com.douglassantana.task.navigation.NavigationDestination

object TaskHomeDestination : NavigationDestination {
    override val route = SCREEN_NAME_TASK_REGISTRATION
    override val titleRes = R.string.app_name
}