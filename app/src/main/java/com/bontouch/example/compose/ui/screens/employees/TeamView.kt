package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun TeamView(teamItem: ListItem.Team) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterStart),
            style = MaterialTheme.typography.h6,
            color = Color.White,
            text = teamItem.name
        )

        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(38.dp),
            painter = painterResource(teamItem.imageResource),
            contentDescription = null
        )

    }
}
