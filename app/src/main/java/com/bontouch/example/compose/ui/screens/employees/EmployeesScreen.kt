package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun EmployeesScreen(viewModel: EmployeesViewModel) {

    val listItems by viewModel.listItemsFlow
        .collectAsState(emptyList<ListItem>())

    val employeeDetailsAnimationState by viewModel.employeeAnimationFlow
        .collectAsState(EmployeeDetailsAnimationState())

    JfokusScaffold(
        isShowingEmployeeDetail = employeeDetailsAnimationState.isInOrApproachingFullScreen,
        onBackPressed = {
            viewModel.onBackPressed()
        }
    ) {
        Column {
            SettingsPanel()
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                EmployeesListView(
                    items = listItems,
                    onListViewPositioned = { coords ->
                        viewModel.onListViewPositioned(coords)
                    },
                    onEmployeeViewClicked = { itemIndex ->
                        viewModel.onEmployeeViewClicked(itemIndex)
                    },
                    onEmployeeViewPositioned = { itemIndex, coords ->
                        viewModel.onEmployeeViewPositioned(itemIndex, coords)
                    }
                )

                employeeDetailsAnimationState.selectedItemIndex?.let { index ->
                    val selectedEmployeeItem = listItems[index] as ListItem.Employee

                    AnimatedEmployeeDetailsView(
                        employeeItem = selectedEmployeeItem,
                        onNotesChanged = {
                            viewModel.onEmployeeNotesChangeRequest(selectedEmployeeItem, it)
                        },
                        employeeDetailsAnimationState = employeeDetailsAnimationState,
                        onEmployeeAnimationStateChangeRequest = {
                            viewModel.onEmployeeAnimationStateChangeRequest(it)
                        }
                    )
                }
            }
        }
    }
}



