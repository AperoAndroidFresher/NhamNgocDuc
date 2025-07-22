package com.example.nhamngocduc.ui.editor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nhamngocduc.ui.editor.components.EditScreenDialog
import com.example.nhamngocduc.ui.editor.components.EditTextSector
import com.example.nhamngocduc.ui.editor.components.ProfileImage
import kotlinx.coroutines.delay

@Composable
fun EditScreenBody(
    modifier: Modifier = Modifier,
    name: String,
    phoneNumber: String,
    schoolName: String,
    description: String,
    isEditable: Boolean,
    onSubmitClick: () -> Unit,
    onNameChanged: (String) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onSchoolNameChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit
) {
    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }

    var showDialogContent by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(showDialog) {
        if (showDialog) {
            showDialogContent = true
            delay(2000L)
            showDialogContent = false
            delay(500L)
            showDialog = false
        }
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 16.dp)
        ) {
            ProfileImage(
                modifier = Modifier.fillMaxWidth(),
                size = 128.dp,
                borderColor = Color.Black
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                EditTextSector(
                    modifier = Modifier.weight(1f),
                    value = name,
                    sectorLabelText = "NAME",
                    placeholderText = "Enter your name...",
                    readOnly = !isEditable,
                    onValueChanged = onNameChanged,
                )

                EditTextSector(
                    modifier = Modifier.weight(1f),
                    value = phoneNumber,
                    sectorLabelText = "PHONE NUMBER",
                    placeholderText = "Your phone number...",
                    readOnly = !isEditable,
                    onValueChanged = onPhoneChanged,
                )
            }

            EditTextSector(
                modifier = Modifier.fillMaxWidth(),
                value = schoolName,
                sectorLabelText = "UNIVERSITY NAME",
                placeholderText = "Your university name...",
                readOnly = !isEditable,
                onValueChanged = onSchoolNameChanged,
            )

            EditTextSector(
                modifier = Modifier.fillMaxWidth(),
                value = description,
                minLines = 8,
                maxLines = 8,
                sectorLabelText = "DESCRIBE YOUR SELF",
                placeholderText = "Enter a description about yoursself...",
                readOnly = !isEditable,
                onValueChanged = onDescriptionChanged
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    visible = isEditable
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = ShapeDefaults.Medium,
                        onClick = {
                            onSubmitClick()
                            showDialog = true
                        }
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            text = "Submit",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }

        EditScreenDialog(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            showDialog = showDialog,
            visibleDialogContent = showDialogContent,
        )
    }
}