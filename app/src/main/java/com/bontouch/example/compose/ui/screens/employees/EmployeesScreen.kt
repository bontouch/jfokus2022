package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateRectAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.util.asBoundsModifier
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun EmployeesScreen(viewModel: EmployeesViewModel) {

    val listItems by viewModel.listItemsFlow
        .collectAsState(emptyList<ListItem>())

    val employeeDetailsAnimationState by viewModel.employeeDetailsAnimationFlow
        .collectAsState(EmployeeDetailsAnimationState())

    JfokusScaffold(
        isShowingEmployeeDetail = employeeDetailsAnimationState.isInOrApproachingDetailsView,
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

                    val employeeDetailsRect by animateRectAsState(
                        targetValue = employeeDetailsAnimationState.targetRect()!!,
                        animationSpec = tween(SettingsRepository.animationTimeMillis)
                    )

                    val animatingBoundsModifier = employeeDetailsRect.asBoundsModifier(LocalDensity.current)

                    EmployeeDetailsView(
                        modifier = animatingBoundsModifier,
                        name = selectedEmployeeItem.name,
                        role = selectedEmployeeItem.role,
                        photoResource = selectedEmployeeItem.photoResource,
                        employmentDate = selectedEmployeeItem.employmentDate,
                        notes = selectedEmployeeItem.notes,
                        onNotesTyped = {
                            viewModel.onEmployeeNotesChangeRequest(selectedEmployeeItem, it)
                        }
                    )

                    employeeDetailsAnimationState.next(employeeDetailsRect)?.let {
                        viewModel.onEmployeeAnimationStateChangeRequest(it)
                    }
                }
            }
        }
    }
}



