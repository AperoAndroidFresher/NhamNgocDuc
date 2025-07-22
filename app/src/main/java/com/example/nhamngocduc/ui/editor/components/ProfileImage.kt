package com.example.nhamngocduc.ui.editor.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.nhamngocduc.R

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    size: Dp,
    borderColor: Color
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            contentAlignment = Alignment.Center
        ) {
            Box (
                modifier = Modifier
                    .clip(CircleShape)
                    .size(size + 2.dp)
                    .background(borderColor)
            )
            Image(
                modifier = Modifier
                    .size(size),
                painter = painterResource(R.drawable.model),
                contentDescription = "Profile Image"
            )
        }
    }
}