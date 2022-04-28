package com.bontouch.example.compose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import org.threeten.bp.LocalDateTime
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JfokusScreen() {
    var clickedTimes by remember { mutableStateOf(0) }

    Column {
        Button(
            modifier = Modifier.padding(4.dp),
            onClick = {
                clickedTimes++
            }
        ) {
            Text("Click me!")
        }
        ClickCounter(modifier = Modifier.padding(start = 4.dp),times = clickedTimes)
    }
}

@Composable
fun ClickCounter(times: Int, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = if (times > 0) {
            "You clicked the button $times times!"
        } else {
            "You have not clicked the button yet!"
        },
        style = MaterialTheme.typography.h6
    )
}

@Composable
fun Hello(index: Int) {
    var time by remember {
        mutableStateOf(LocalDateTime.now())
    }

    Text(
        text = "Hello, Jfokus $index! $time",
        style = MaterialTheme.typography.h6
    )
}