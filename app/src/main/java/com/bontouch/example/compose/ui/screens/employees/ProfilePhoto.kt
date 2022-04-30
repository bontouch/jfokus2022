package com.bontouch.example.compose.ui.screens.employees

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R

@Preview
@Composable
fun ProfilePhotoPreview() {
    ProfilePhoto(R.drawable.photo_robert)
}

@Composable
fun ProfilePhoto(
    @DrawableRes photoResource: Int,
    modifier:Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(36.dp)),
        painter = painterResource(photoResource),
        contentDescription = null
    )
}