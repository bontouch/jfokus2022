package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.bontouch.example.compose.config.SettingsRepository

@Preview
@Composable
fun BontouchLogo() {
    Image(
        alignment = Alignment.CenterEnd,
        modifier = Modifier
            .size(124.dp)
            .padding(end = 24.dp)
            .clickable {
                SettingsRepository.toggleSettingsPanelVisible()
            },
        painter = painterResource(R.drawable.bontouch_logo_white),
        contentDescription = null
    )
}