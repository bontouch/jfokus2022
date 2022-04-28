package com.bontouch.example.compose.domain

import androidx.annotation.DrawableRes
import org.threeten.bp.LocalDate

data class Teams(
    val teams: List<Team> = emptyList()
)

data class Team(
    val name: String,
    @DrawableRes val imageResource: Int,
    val employees: List<Employee>
)

data class Employee(
    val name: String,
    val role: Role,
    val notes: String,
    val startDate: LocalDate,
    @DrawableRes val imageResource: Int
)

enum class Role {
    AndroidDeveloper,
    IosDeveloper,
    WebDeveloper,
    BackEndDeveloper
}