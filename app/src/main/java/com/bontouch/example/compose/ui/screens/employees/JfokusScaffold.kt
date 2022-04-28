package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.theme.MainTheme

@ExperimentalAnimationApi
@Composable
fun JfokusScaffold(
    isShowingEmployeeDetail: Boolean,
    onBackPressed: () -> Unit,
    content: @Composable () -> Unit
) {
    MainTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = {
                    TopAppBar {
                        JfokusToolbar(
                            isShowingEmployeeDetails = isShowingEmployeeDetail,
                            onBackPressed = {
                                onBackPressed()
                            }
                        )
                    }
                }) {
                content()
            }
        }
    }
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

@Composable
fun EmployeeDetailsTitleWithBackButton(
    onBackPressed: () -> Unit
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