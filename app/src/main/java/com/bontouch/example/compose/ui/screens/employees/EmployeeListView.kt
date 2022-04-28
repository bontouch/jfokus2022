package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import com.bontouch.example.compose.ui.theme.BontouchLightBlue

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
            .onGloballyPositioned { onListViewPositioned(it) }
            .background(BontouchLightBlue)
            .animateContentSize()
    ) {

        itemsIndexed(items = items) { itemIndex, item ->
            when (item) {
                is ListItem.JfokusLogo -> JfokusLogoView()
                is ListItem.Team -> TeamView(item)
                is ListItem.Employee -> EmployeeView(
                    employeeItem = item,
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