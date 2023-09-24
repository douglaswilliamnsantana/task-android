package com.douglassantana.task.ui.register

import com.douglassantana.task.R
import com.douglassantana.task.common.Screens.SCREEN_NAME_HOME
import com.douglassantana.task.navigation.NavigationDestination

object TaskRegisterDestination : NavigationDestination {
    override val route = SCREEN_NAME_HOME
    override val titleRes = R.string.app_name
}