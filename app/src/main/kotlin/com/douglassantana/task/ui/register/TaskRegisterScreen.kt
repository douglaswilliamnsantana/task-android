package com.douglassantana.task.ui.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import com.douglassantana.task.R
import com.douglassantana.task.ui.widget.TaskToolbar
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskRegisterScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    taskRegisterViewModel: TaskRegisterViewModel = getViewModel()
) {

    val name by taskRegisterViewModel.name.collectAsState()
    val isEnableButton by taskRegisterViewModel.isEnableButton.collectAsState()
    val error by taskRegisterViewModel.error.collectAsState()

    Scaffold(
        topBar = {
            TaskToolbar(
                title = stringResource(TaskRegisterDestination.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        }
    ) { paddingValues ->
        Surface {

            if (error)
                Toast.makeText(
                    LocalContext.current,
                    stringResource(id = R.string.default_error_title),
                    Toast.LENGTH_LONG
                ).show()

            TaskRegisterBody(
                paddingValues = paddingValues,
                isEnableButton = isEnableButton,
                value = name,
                onValueChange = taskRegisterViewModel::onChangeName,
                onSaveClick = { taskRegisterViewModel.onSave() },
                navigateBack = { navigateBack() }
            )
        }
    }
}

@Composable
private fun TaskRegisterBody(
    modifier: Modifier = Modifier,
    isEnableButton: Boolean,
    paddingValues: PaddingValues,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onSaveClick: () -> Unit,
    navigateBack: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TaskRegisterInput(
                value = value,
                onValueChange = onValueChange
            )

            TaskButtonRegister(
                onSaveClick = {
                    onSaveClick()
                    navigateBack()
                },
                isEnableButton = isEnableButton
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TaskRegisterInput(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .padding(all = dimensionResource(id = R.dimen.default_margin))
            .width(dimensionResource(id = R.dimen.button_with))
            .fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.default_margin)),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = stringResource(id = R.string.task_register_name_field))
        }
    )
}

@Composable
private fun TaskButtonRegister(
    modifier: Modifier = Modifier,
    onSaveClick: () -> Unit,
    isEnableButton: Boolean
) {
    Button(
        modifier = modifier
            .padding(all = dimensionResource(id = R.dimen.default_margin))
            .width(dimensionResource(id = R.dimen.button_with))
            .height(dimensionResource(id = R.dimen.button_height)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.default_margin)),
        onClick = onSaveClick,
        enabled = isEnableButton
    ) {
        Text(
            text = stringResource(id = R.string.task_register_button_title),
            textAlign = TextAlign.Center
        )
    }
}