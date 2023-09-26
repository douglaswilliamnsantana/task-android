package com.douglassantana.task.ui.register

import com.douglassantana.ui.R as CoreUi
import com.douglassantana.task.common.Screens.SCREEN_NAME_HOME
import com.douglassantana.task.navigation.NavigationDestination

object TaskRegisterDestination : NavigationDestination {
    override val route = SCREEN_NAME_HOME
    override val titleRes = CoreUi.string.app_name
}