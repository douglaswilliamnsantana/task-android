package com.douglassantana.ui.widget.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.douglassantana.ui.R
import com.douglassantana.ui.widget.button.WidgetButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WidgetBottomSheet(
    modifier: Modifier = Modifier,
    title: String,
    buttonTitle: String,
    subTitle: String? = null,
    onDismiss: () -> Unit,
    onButtonAction: () -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState()
) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.default_margin))
        ) {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = title
            )

            Text(
                modifier = modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.default_medium_margin),
                        bottom = dimensionResource(id = R.dimen.default_medium_margin)
                    ),
                style = MaterialTheme.typography.titleMedium,
                text = subTitle.orEmpty()
            )

            WidgetButton(
                title = buttonTitle,
                onAction = onButtonAction
            )
        }
    }
}