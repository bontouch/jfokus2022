package com.bontouch.example.compose.ui.screens.employees

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.ChronoUnit

@Preview
@Composable
fun EmployeeViewPreview() {
    EmployeeView(
        name = "Robert Söderbjörn",
        role = "Android Developer",
        photoResource = R.drawable.photo_robert,
        employmentDate = LocalDate.parse("2017-02-27"),
        onClicked = {},
        onPositioned = {}
    )
}

@Composable
fun EmployeeView(
    modifier: Modifier = Modifier,
    name: String,
    role: String,
    @DrawableRes photoResource: Int,
    employmentDate: LocalDate?,
    onClicked: () -> Unit,
    onPositioned: (LayoutCoordinates) -> Unit
) {
    RoundedCard(modifier = modifier
        .onGloballyPositioned { onPositioned(it) }
        .clickable {
            onClicked()
        }
    ) {
        BasicEmployeeInfoView(
            modifier = Modifier.padding(16.dp),
            name = name,
            role = role,
            photoResource = photoResource,
            employmentDate = employmentDate
        )
    }
}
