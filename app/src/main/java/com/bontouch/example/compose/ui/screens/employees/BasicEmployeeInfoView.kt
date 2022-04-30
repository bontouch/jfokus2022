package com.bontouch.example.compose.ui.screens.employees

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.ChronoUnit

@Preview
@Composable
fun BasicEmployeeInfoViewPreview() {
    AndroidThreeTen.init(LocalContext.current) // initialize Java time Android back-port

    BasicEmployeeInfoView(
        name = "Robert Söderbjörn",
        role = "Android Developer",
        photoResource = R.drawable.photo_robert,
        employmentDate = LocalDate.parse("2017-02-27"),
        false
    )
}

@Composable
fun BasicEmployeeInfoView(
    name: String,
    role: String,
    @DrawableRes photoResource: Int,
    employmentDate: LocalDate?,
) {
    Row {
        Column {
            ProfilePhoto(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp),
                photoResource = photoResource)
        }
        Column {
            Text(
                style = MaterialTheme.typography.h5,
                text = name
            )
            Text(
                style = MaterialTheme.typography.body1,
                text = role
            )
            employmentDate?.let { date ->
                ElapsedTimeView(date.atStartOfDay(), ChronoUnit.SECONDS) {
                    Text(
                        style = MaterialTheme.typography.caption,
                        text = "Employed for ${it} seconds"
                    )
                }
            }
        }
    }
}

