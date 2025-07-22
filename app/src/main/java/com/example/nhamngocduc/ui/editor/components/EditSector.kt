package com.example.nhamngocduc.ui.editor.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun EditTextSector(
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    minLines: Int = 1,
    maxLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text,
    value: String,
    sectorLabelText: String,
    placeholderText: String,
    enabled: Boolean,
    onValueChanged: (String) -> Unit,
) {


    Column(
        modifier = modifier.padding(horizontal = 4.dp, vertical = 12.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = sectorLabelText,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .background(color = Color.White, shape = MaterialTheme.shapes.medium)
                .fillMaxWidth(),
            enabled = !enabled,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            ),
            isError = isError,
            value = value,
            onValueChange = onValueChanged,
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            },
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            ),
            shape = MaterialTheme.shapes.medium,
            minLines = minLines,
            maxLines = maxLines
        )
    }
}