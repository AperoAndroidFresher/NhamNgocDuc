package com.example.nhamngocduc.ui.editor.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun EditTextSector(
    modifier: Modifier = Modifier,
    value: String,
    minLines: Int = 1,
    maxLines: Int = 1,
    sectorLabelText: String,
    placeholderText: String,
    readOnly: Boolean,
    onValueChanged: (String) -> Unit,
) {


    Column(
        modifier = modifier.padding(horizontal = 4.dp, vertical = 12.dp)
    ) {
        Text(
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
            readOnly = readOnly,
            value = value,
            onValueChange = {
                onValueChanged(it)
            },
            colors = OutlinedTextFieldDefaults.colors(
                Color.Gray,
                Color.Gray,
                Color.Gray
            ),
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.bodyMedium.copy(
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