package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.ui.theme.BontouchBlue

@Composable
fun EmployeesListView(
    items: List<ListItem>,
    onListViewPositioned: (LayoutCoordinates) -> Unit,
    onEmployeeViewClicked: (itemIndex: Int) -> Unit,
    onEmployeeViewPositioned: (itemIndex: Int, LayoutCoordinates) -> Unit
) {

    val scrollState = rememberScrollState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .onGloballyPositioned { onListViewPositioned(it) }
            .padding(bottom = 16.dp)
            .animateContentSize()
    ) {

        itemsIndexed(items = items) { itemIndex, item ->
            when (item) {
                is ListItem.JfokusLogo -> JfokusLogoView()
                is ListItem.Team -> TeamView(item.name, item.logoResource)
                is ListItem.Employee -> EmployeeView(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ),
                    name = item.name,
                    role = item.role,
                    photoResource = item.photoResource,
                    employmentDate = item.employmentDate,
                    onClicked = {
                        onEmployeeViewClicked(itemIndex)
                    },
                    onPositioned = { coords ->
                        onEmployeeViewPositioned(itemIndex, coords)
                    }
                )
            }
        }
    }
}