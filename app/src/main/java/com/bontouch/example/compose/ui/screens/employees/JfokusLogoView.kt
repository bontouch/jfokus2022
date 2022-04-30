package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.bontouch.example.compose.config.SettingsRepository

@Preview
@Composable
fun JfokusLogoViewPreview() {
    JfokusLogoView()
}

@Composable
fun JfokusLogoView() {

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        painter = painterResource(R.drawable.logo_jfokus),
        contentDescription = null
    )
}
