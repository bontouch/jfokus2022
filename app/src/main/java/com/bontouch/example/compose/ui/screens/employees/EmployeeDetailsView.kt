package com.bontouch.example.compose.ui.screens.employees

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.temporal.ChronoUnit

@Preview
@Composable
fun EmployeeDetailsViewPreview() {
    AndroidThreeTen.init(LocalContext.current) // initialize Java time Android back-port

    EmployeeDetailsView(
        name = "Robert Söderbjörn",
        role = "Android Developer",
        photoResource = R.drawable.photo_robert,
        employmentDate = LocalDate.parse("2017-02-27"),
        notes = "❤️ Commodore C64 / Amiga",
        onNotesTyped = {},
    )
}

@Composable
fun EmployeeDetailsView(
    modifier: Modifier = Modifier,
    name: String,
    role: String,
    @DrawableRes photoResource: Int,
    employmentDate: LocalDate?,
    notes: String,
    onNotesTyped: (String) -> Unit
) {
    val detailsOpenedSince by remember { mutableStateOf(LocalDateTime.now()) }

    RoundedCard(modifier = modifier) {
        Column {
            BasicEmployeeInfoView(name, role, photoResource, employmentDate)
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.h5,
                value = notes,
                label = { Text("Notes") },
                onValueChange = {
                    onNotesTyped(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                )
            )
            ElapsedTimeView(startTime = detailsOpenedSince, unit = ChronoUnit.SECONDS) { seconds ->
                Text(
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.body2,
                    text = "Employee details viewed for $seconds seconds"
                )
            }
        }
    }
}
