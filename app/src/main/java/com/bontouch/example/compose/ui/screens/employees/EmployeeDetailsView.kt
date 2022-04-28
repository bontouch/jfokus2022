package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R

@Composable
fun EmployeeDetailsView(
    modifier: Modifier = Modifier,
    employeeItem: ListItem.Employee,
    onNotesChanged: (String) -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = modifier
            .background(
                color = Color(0xffffffff),
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()

    ) {
        Column {
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
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.h5,
                value = employeeItem.notes,
                label = { Text("Notes") },
                onValueChange = {
                    onNotesChanged(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                )
            )
        }
    }
}

@Preview
@Composable
fun EmployeeDetailsViewpreview() {
    EmployeeDetailsView(
        employeeItem = ListItem.Employee(
            name = "Robert Söderbjörn",
            role = "Android Developer",
            employedSeconds = 1000,
            notes = "Hoping for a Pixel Watch soon!",
            R.drawable.photo_robert
        ),
        onNotesChanged = {}
    )
}

