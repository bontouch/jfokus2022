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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.theme.MainTheme

@ExperimentalAnimationApi
@Preview
@Composable
fun JfokusScaffoldPreview() {
    JfokusScaffold(
        isShowingEmployeeDetail = false,
        onBackPressed = {},
        content = @Composable {
            Text("Empty content")
        }
    )
}

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


