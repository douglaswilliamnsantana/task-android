package com.douglassantana.ui.widget.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.douglassantana.designsystem.R
import com.douglassantana.ui.theme.TaskTheme

@Composable
fun TaskButton(
    title: String,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) = Button(
    onClick = onClick,
    shape = RoundedCornerShape(dimensionResource(id = R.dimen.default_xxmargin)),
    enabled = enabled,
    modifier = modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(id = R.dimen.default_margin))
        .height(dimensionResource(id = R.dimen.default_height)),
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = dimensionResource(id = R.dimen.default_xxmargin)),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right_alt),
            contentDescription = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
@PreviewLightDark
private fun TaskButtonPreview() {
    TaskTheme {
        TaskButton(
            title = "Register",
            onClick = {}
        )
    }
}