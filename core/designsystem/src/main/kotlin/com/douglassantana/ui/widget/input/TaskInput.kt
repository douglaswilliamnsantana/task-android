package com.douglassantana.ui.widget.input

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.douglassantana.ui.theme.TaskTheme

@Composable
fun TaskInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) = OutlinedTextField(
    value = value,
    onValueChange = onValueChange,
    label = { Text(text = placeholder) },
    modifier = modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
)

@Composable
@PreviewLightDark
private fun TaskInputPreview() {
    TaskTheme {
        Surface {
            TaskInput(
                placeholder = "Title",
                value = TextFieldValue(text = ""),
                onValueChange = {}
            )
        }
    }
}