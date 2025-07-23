package com.example.nhamngocduc.ui.editor

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    modifier: Modifier = Modifier
) {
    var isEditable by rememberSaveable {
        mutableStateOf(false)
    }

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var phoneNumber by rememberSaveable {
        mutableStateOf("")
    }

    var schoolName by rememberSaveable {
        mutableStateOf("")
    }

    var description by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        modifier = modifier,
        containerColor = Color(0xFFF5FAFC),
        topBar = {
            EditScreenTopBar(
                isEditable = isEditable,
                onActionClick = {
                    isEditable = true
                }
            )
        },
        content = {
            EditScreenBody(
                modifier = Modifier
                    .padding(it),
                name = name,
                phoneNumber = phoneNumber,
                schoolName = schoolName,
                description = description,
                isEditable = isEditable,
                onSubmitClick = {
                    isEditable = false
                },
                onNameChanged = {
                    name = it
                },
                onPhoneChanged = {
                    phoneNumber = it
                },
                onSchoolNameChanged = {
                     schoolName= it
                },
                onDescriptionChanged = {
                    description = it
                },
            )
        }
    )
}

@Preview
@Composable
fun ComposablePreview() {
    EditScreen()
}

