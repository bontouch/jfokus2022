package com.bontouch.example.compose.ui.screens.employees

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
import androidx.compose.ui.unit.dp

@Composable
fun EmployeeView(
    employeeItem: ListItem.Employee,
    onClicked: () -> Unit,
    onPositioned: (LayoutCoordinates) -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 4.dp, start = 16.dp, end = 16.dp)
            .background(
                color = Color(0xffffffff),
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
            .onGloballyPositioned { onPositioned(it) }
            .clickable {
                onClicked()
            }

    ) {
        Row {
            Column {
                Image(
                    modifier = Modifier.size(56.dp),
                    painter = painterResource(employeeItem.imageResource),
                    contentDescription = null
                )
            }
            Column {
                Text(
                    style = MaterialTheme.typography.h5,
                    text = employeeItem.name
                )
                Text(
                    style = MaterialTheme.typography.body1,
                    text = employeeItem.role
                )
                Text(
                    style = MaterialTheme.typography.body2,
                    text = "Employed for ${employeeItem.employedSeconds} seconds"
                )
            }
        }
    }
}