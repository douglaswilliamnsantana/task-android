package com.douglassantana.ui.widget.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.douglassantana.ui.R

@Composable
fun WidgetButton(
    modifier: Modifier = Modifier,
    title: String,
    shape: Shape = ButtonDefaults.shape,
    enabled: Boolean = true,
    onAction: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onAction,
        shape = shape,
        enabled = enabled,
        content = {
            Text(
                modifier = modifier
                    .padding(top = dimensionResource(id = R.dimen.default_medium))
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                text = title,
                textAlign = TextAlign.Center
            )
        }
    )
}