package com.example.composemultitheming.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorSchemePicker(
    modifier: Modifier = Modifier,
    color: Color,
    colorSchemeName: String,
    isSelected: String,
    onClick: (String) -> Unit
) {
    Box(modifier = modifier
        .clip(RoundedCornerShape(100.dp))
        .clickable { onClick(colorSchemeName) }) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(color)
                .padding(12.dp)
        )
        if (isSelected==colorSchemeName) {
            Icon(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp),
                imageVector = Icons.Outlined.Check,
                contentDescription = null, tint = Color.Black
            )
        }

    }
}
