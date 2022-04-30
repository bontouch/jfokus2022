package com.bontouch.example.compose.ui.screens.employees

import android.util.Log
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.boundsInParent
import androidx.lifecycle.ViewModel
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.domain.Role
import com.bontouch.example.compose.repository.EmployeeRepository
import com.bontouch.example.compose.ui.util.update
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

@ExperimentalCoroutinesApi
class EmployeesViewModel : ViewModel() {
    private var listViewCoordinates: LayoutCoordinates? = null
    private val employeeViewCoordinatesByIndex = HashMap<Int, LayoutCoordinates>()
    private val employeeAnimationStateFlow = MutableStateFlow(EmployeeDetailsAnimationState())

    val employeeDetailsAnimationFlow
        get(): Flow<EmployeeDetailsAnimationState> = employeeAnimationStateFlow

    val listItemsFlow: Flow<List<ListItem>>
        get() = combine(
            EmployeeRepository.teamsFlow,
            SettingsRepository.manyItemsFlow
        )
        { teams, manyItems ->

            val listItems = ArrayList<ListItem>()

            listItems.add(
                ListItem.JfokusLogo
            )

            val duplicates = if (manyItems) 100 else 1

            for (i in 1..duplicates) {
                teams.teams.forEach { team ->

                    team.name?.let { name ->
                        listItems.add(
                            ListItem.Team(
                                name = name,
                                logoResource = team.logoResource
                            )
                        )
                    }

                    team.employees.forEach { employee ->

                        listItems.add(
                            ListItem.Employee(
                                name = employee.name,
                                role = employee.role.forDisplay(),
                                notes = employee.notes,
                                employmentDate = if (SettingsRepository.OMIT_TEAMS_AND_EMPLOYMENT_DURATION) {
                                    null
                                } else {
                                    employee.startDate
                                },
                                photoResource = employee.imageResource
                            )
                        )
                    }
                }
            }

            Log.i("SIZE", "${listItems.size}")
            listItems
        }


    fun onListViewPositioned(coords: LayoutCoordinates) {
        listViewCoordinates = coords
    }

    fun onEmployeeViewPositioned(
        itemIndex: Int,
        coords: LayoutCoordinates
    ) {
        employeeViewCoordinatesByIndex[itemIndex] = coords
    }

    fun onEmployeeViewClicked(selectedItemIndex: Int) {
        employeeAnimationStateFlow.update {
            it.startExpansion(
                itemIndex = selectedItemIndex,
                collapsedRect = employeeViewCoordinatesByIndex[selectedItemIndex]!!.boundsInParent(),
                expandedRect = listViewCoordinates!!.boundsInParent()
            )
        }
    }

    fun onEmployeeNotesChangeRequest(employeeItem: ListItem.Employee, notes: String) {
        EmployeeRepository.setEmployeeNotes(employeeItem.name, notes)
    }

    fun onEmployeeAnimationStateChangeRequest(state: EmployeeDetailsAnimationState) {
        employeeAnimationStateFlow.update {
            state
        }
    }

    fun onBackPressed() {
        employeeAnimationStateFlow.update {
            it.startCollapse()
        }
    }

}

private fun Role.forDisplay() =
    when (this) {
        Role.AndroidDeveloper -> "Android Developer"
        Role.IosDeveloper -> "iOS Developer"
        Role.WebDeveloper -> "Web Developer"
        Role.BackEndDeveloper -> "Back-end Developer"
        Role.EventCommunicationsManager -> "Event & Communications Manager"
        Role.SocialMediaManager -> "Social Media Manager"
    }






