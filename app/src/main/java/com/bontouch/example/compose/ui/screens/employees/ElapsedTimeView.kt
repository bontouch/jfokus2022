package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.coroutines.delay
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.temporal.ChronoUnit
import org.threeten.bp.temporal.Temporal

@Preview
@Composable
fun ElapsedTimeViewPreview() {
    AndroidThreeTen.init(LocalContext.current) // initialize Java time Android back-port

    ElapsedTimeView(
        startTime = LocalDate.parse("2020-01-01").atStartOfDay(),
        unit = ChronoUnit.SECONDS
    ) {
        Text(it.toString())
    }
}

@Composable
fun ElapsedTimeView(
    startTime: Temporal,
    unit: ChronoUnit,
    content: @Composable (elapsedTimeSince: Long) -> Unit
) {
    var elapsedTimeSince: Long by remember { mutableStateOf(0) }

    LaunchedEffect(startTime) {
        while (true) {
            elapsedTimeSince = unit.between(startTime, LocalDateTime.now())
            delay(unit.duration.toMillis())
        }
    }

    content(elapsedTimeSince)
}
