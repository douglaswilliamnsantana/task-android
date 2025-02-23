package com.douglassantana.register.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.douglassantana.ui.theme.TaskTheme
import com.douglassantana.ui.widget.button.TaskButton
import com.douglassantana.ui.widget.input.TaskInput
import com.douglassantana.designsystem.R as DesignSystemUi

@Composable
fun TaskRegisterRoute(
    modifier: Modifier = Modifier,
    onNavigateHome: () -> Unit
) {

    val viewModel: TaskRegisterViewModel = hiltViewModel()

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    val onNavigateHomeCallback by rememberUpdatedState(newValue = onNavigateHome)

    TaskRegisterScreen(
        modifier = modifier,
        uiState = uiState,
        onValueChangeTaskTitle = viewModel::updateTaskTitle,
        onValueChangeTaskDescription = viewModel::updateTaskDescription,
        onNavigateHome = onNavigateHomeCallback,
        taskRegister = viewModel::createTask
    )
}

@Composable
private fun TaskRegisterScreen(
    modifier: Modifier = Modifier,
    uiState: TaskRegisterUiState,
    onValueChangeTaskTitle: (TextFieldValue) -> Unit,
    onValueChangeTaskDescription: (TextFieldValue) -> Unit,
    onNavigateHome: () -> Unit,
    taskRegister: () -> Unit,
) = Scaffold { paddingValues ->
    Column(
        modifier = modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        TaskRegisterHeader()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(all = dimensionResource(id = DesignSystemUi.dimen.default_margin))
                .fillMaxSize()
        ) {
            TaskInput(
                value = uiState.taskTitleText,
                onValueChange = onValueChangeTaskTitle,
                placeholder = stringResource(DesignSystemUi.string.task_title_field),
                modifier = modifier
                    .padding(top = dimensionResource(id = DesignSystemUi.dimen.default_xxmargin))
            )

            TaskInput(
                value = uiState.taskDescriptionText,
                onValueChange = onValueChangeTaskDescription,
                placeholder = stringResource(DesignSystemUi.string.task_description_field),
                modifier = modifier
                    .padding(top = dimensionResource(id = DesignSystemUi.dimen.default_xxmargin))
            )

            TaskButton(
                enabled = uiState.isEnableButton,
                title = stringResource(id = DesignSystemUi.string.task_description_button_title),
                onClick = {
                    taskRegister.invoke()
                    onNavigateHome.invoke()
                }
            )
        }
    }
}

@Composable
private fun TaskRegisterHeader(
    modifier: Modifier = Modifier,
) = Column {
    Text(
        text = stringResource(id = DesignSystemUi.string.hello_title),
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
            .padding(
                top = dimensionResource(id = DesignSystemUi.dimen.default_height),
                start = dimensionResource(id = DesignSystemUi.dimen.default_margin),
                end = dimensionResource(id = DesignSystemUi.dimen.default_margin),
            )
            .fillMaxWidth()
    )

    Text(
        text = stringResource(id = DesignSystemUi.string.register_title),
        modifier = modifier
            .padding(
                top = dimensionResource(id = DesignSystemUi.dimen.default_margin_xxsmall),
                start = dimensionResource(id = DesignSystemUi.dimen.default_margin),
                end = dimensionResource(id = DesignSystemUi.dimen.default_margin),
            )
            .fillMaxWidth()
    )
}

@Composable
@PreviewLightDark
private fun TaskRegisterPreview() {
    TaskTheme {
        TaskRegisterScreen(
            uiState = TaskRegisterUiState(),
            onValueChangeTaskTitle = {},
            onValueChangeTaskDescription = {},
            onNavigateHome = {},
            taskRegister = {}
        )
    }
}