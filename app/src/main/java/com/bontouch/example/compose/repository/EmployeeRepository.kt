package com.bontouch.example.compose.repository

import com.bontouch.example.compose.domain.Teams
import com.bontouch.example.compose.ui.util.update
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

object EmployeeRepository {
    private val teamsStateFlow = MutableStateFlow<Teams>(EmployeeData.TEAMS)

    val teamsFlow: Flow<Teams>
        get() = teamsStateFlow

    fun setEmployeeNotes(name: String, notes: String) {
        teamsStateFlow.update { teams ->
            Teams(
                teams = teams.teams.map { team ->
                    team.copy(employees = team.employees.map { employee ->
                        if (employee.name == name) {
                            employee.copy(
                                notes = notes
                            )
                        } else {
                            employee
                        }
                    })
                }
            )
        }
    }
}
