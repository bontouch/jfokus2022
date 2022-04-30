package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.config.SettingsRepository

@ExperimentalAnimationApi
@Preview
@Composable
fun JfokusToolbarMainPreview() {
    MainTitle()
}

@ExperimentalAnimationApi
@Preview
@Composable
fun JfokusToolbarEmployeeDetailsPreview() {
    EmployeeDetailsTitleWithBackButton(onBackPressed = {})
}

@ExperimentalAnimationApi
@Composable
fun JfokusToolbar(
    isShowingEmployeeDetails: Boolean,
    onBackPressed: () -> Unit
) {
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Crossfade(
                targetState = isShowingEmployeeDetails,
                animationSpec = tween(SettingsRepository.animationTimeMillis)
            ) { employeeDetails ->
                if (employeeDetails) {
                    EmployeeDetailsTitleWithBackButton(onBackPressed = onBackPressed)
                } else {
                    MainTitle()
                }
            }
            BontouchLogo()
        }
    }
}

@Preview
@Composable
fun MainTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp),
            style = MaterialTheme.typography.h6,
            text = "Jfokus Booth Team"
        )
    }
}

@Composable
fun EmployeeDetailsTitleWithBackButton(
    onBackPressed: () -> Unit = {}
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = {
            onBackPressed()
        }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
            )
        }
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                style = MaterialTheme.typography.h6,
                text = "Employee Details"
            )
        }
    }
}
