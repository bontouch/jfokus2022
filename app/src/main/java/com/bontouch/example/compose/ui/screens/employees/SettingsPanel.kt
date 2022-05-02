package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.theme.BontouchBlue

@Composable
fun SettingsPanel() {

    val settingsPanelVisible by SettingsRepository.settingsPanelVisibleFlow
        .collectAsState(false)

    if (settingsPanelVisible) {
        val slowAnimations by SettingsRepository.slowAnimationFlow
            .collectAsState(false)

        val manyItems by SettingsRepository.manyItemsFlow
            .collectAsState(false)

        Row(
            modifier = Modifier
                .background(BontouchBlue)
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            LabelledCheckbox(
                checked = slowAnimations,
                text = "Slow Animations",
                onCheckedChange = {
                    SettingsRepository.setSlowAnimations(it)
                }
            )

            LabelledCheckbox(
                modifier = Modifier.padding(start = 42.dp),
                checked = manyItems,
                text = "Many Items",
                onCheckedChange = {
                    SettingsRepository.setManyItems(it)
                }
            )
        }
    }
}

@Composable
fun LabelledCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    text: String,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(modifier.clickable {
        onCheckedChange(!checked)
    }) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        Text(color = Color.Companion.White, text = text)
    }
}