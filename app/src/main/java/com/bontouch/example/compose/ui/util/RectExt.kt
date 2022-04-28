package com.bontouch.example.compose.ui.util

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset

@Composable
fun Rect.asBoundsModifier(density: Density): Modifier {

    val renderOffset = IntOffset(
        x = left.toInt(),
        y = top.toInt()
    )

    val renderWidth = with(LocalDensity.current) { width.toDp() }
    val renderHeight = with(LocalDensity.current) { height.toDp() }

    return Modifier
        .offset { renderOffset }
        .size(
            width = renderWidth,
            height = renderHeight
        )
}